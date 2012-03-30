
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/*
 * GPSMoteFile.java
 *
 * Created on November 3, 2007, 10:56 AM
 *
 * THIS CLASS READS THE MOTE DATA FROM THE .DAT FILES OBTAINED 
 * DURING THE EXPERIMENT. THE DATA OBTAINED CONSISTS OF MULTIPLE
 * PAIRS OF LINES. THE FIRST LINE IN THE PAIR GIVES THE GPS LOCATION  
 * INFORMATION AND THE FOLLOWING LINE GIVES THE DATA SAMPLES COLLECTED
 * THE .DAT FILE PASSED TO THIS CLASS IS USED TO GENERATE SEPARATE FILES
 * FOR DATA COLLECTED AT DIFFERENT TIMES. THIS CLASS ALSO GENERATES A 
 * SEPARATE TIMEFILE.txt (CONTAINS TIMES AT WHICH DATA WAS SAMPLED) AND
 * PLOTFILE.txt (CONTAINS THE CORRECT DATA SEPARATED ACCORDING TO TIME 
 * TO HELP IN MATLAB PLOTTING)
 * 
 */

/**
 *
 * @author Mir Murtuza Ali
 */
public class GPSMoteFile {
    String file;
    
    /** Creates a new instance of GPSMoteFile */
    public GPSMoteFile(String file) {
        this.file = file;
    }
    
    public void readfile(String filename){
        FileInputStream fin;
        DataInputStream in;
        FileWriter out;
        int filesequence = 0;                            
       String[] splitstring=null;
       try
        {
            fin = new FileInputStream(filename);
            in = new DataInputStream(fin);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
           // String datefilename = "Date_File.txt";            
            BufferedWriter datefile = new BufferedWriter(new FileWriter(file+"TIMEFILE.txt"));
            // PLOTFILE IS GENERATED HERE FOR EASY PLOTTING OF DATA FILES USING MATLAB
            BufferedWriter plotfile = new BufferedWriter(new FileWriter(file+"PLOTFILE.txt"));
            String str;
           while((str=br.readLine())!=null){
                Pattern pattern = Pattern.compile("West");
                Matcher matcher = pattern.matcher(str);
                if(matcher.find()){
                    splitstring = str.split(", ");
                    int i=0;
                    boolean state=true;
                    while(state){
                        if(i<splitstring.length && splitstring[i].contains("North")){
                            String outfilename="Mote_Extracted_Data_";                            
                            try{
                                filesequence++;
                                outfilename = outfilename.concat(String.valueOf(filesequence).concat(".txt"));
                                BufferedWriter buf = new BufferedWriter(new FileWriter(file + outfilename));
                                // WRITE [TIME] IN THE FILE
                                buf.write(splitstring[i-1]);buf.write("\n");
                                // WRITE [TIME] IN THE TIMEFILE
                                datefile.write(splitstring[i-1]);datefile.write("\n");
                                // WRITE [TIME] IN THE PLOTFILE
                                plotfile.write(splitstring[i-1]);plotfile.write("\n");
                                buf.write(splitstring[i]);buf.write("\n");      // LATITUDE
                                buf.write(splitstring[i+1]);buf.write("\n");    // LONGITUDE
                                buf.write(splitstring[i+2]);buf.write("\n");    // ALTITUDE
                                str=br.readLine();                                
                                String[] datastring = str.split(",");                                
                                for(int j=0;j<datastring.length;j++){
                                buf.write(datastring[j]);
                                buf.write("\n");
                                // WRITE THIS DATA BELOW THE TIME IT WAS TAKEN IN THE PLOTFILE
                                plotfile.write(datastring[j]);
                                if(j<datastring.length-1)
                                plotfile.write(" ");
                                }
                                plotfile.write("\n");
                                buf.close();
                                
                                state=false;
                            }catch(IOException e){
                                System.out.println("Unable to write to file");
                            }
                        }
                         else
                             if(i<splitstring.length)
                                    i++;
                                else
                                    state=false;
                        }                    
                        
                    }
                                        
                }      
            datefile.close();
            plotfile.close();

        }catch(IOException e){
            System.err.println(e);
        } 
      
        
        
    }
    
}
