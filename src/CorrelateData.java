/*
 * CorrelateData.java
 *
 * Created on November 26, 2007, 10:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Mir Murtuza Ali
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class CorrelateData {
    
    /** Creates a new instance of CorrelateData */
    public CorrelateData() {
    }
    
    /*
     * IN THIS PROGRAM WE CORRELATE TWO DATA FILES "REFERENCE" & "COMPARE" FILES
     * THE USER MUST PASS THE PATH TO THESE DATA FILES. THESE DATA FILES ARE 
     * GENERATED FROM THE MOTE .dat FILES USING GenerateFilesfromDATfiles.java
     * IN "Data Files Read" PROJECT FOLDER. SELECT THE METHOD OF CORRELATION 
     * PASSED AS A PARAMETER TO 'CorrelateXY.findcorrelation()' method.
     */
    public static void main(String[] args){
        // Open file and store it in a double array
        FileInputStream fin;
        DataInputStream in;
        String reference = "E:/NCPA/Data Files/mote1.txt";
        String compare = "E:/NCPA/Data Files/mote2.txt";
        double[] reference_data;
        double[] comparewith_data;
        int i=0;
        reference_data = readfileas_double(reference);
        comparewith_data = readfileas_double(compare);
        int sync;
        sync = CorrelateXY.findcorrelation(reference_data,comparewith_data,2);
        System.out.println(sync);
        
    }
    
    // THIS METHOD READS THE FILE AND RETURNS THE DATA AS A DOUBLE ARRAY
    public static double[] readfileas_double(String filename){
        FileInputStream fin;
        DataInputStream in;
        String str;
        Vector<Double> data = new Vector<Double>();       
        int i=0;
        try{
            fin = new FileInputStream(filename);
            in = new DataInputStream(fin);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            // Go past the Time and GPS data(time,latitude,longitude,altitude)  
           // br.readLine();br.readLine();br.readLine();br.readLine();
            while((str=br.readLine())!=null){
                data.add(Double.parseDouble(str));
                i++;
            }
            br.close();            
        }catch(IOException er){
            System.err.println("Unable to read file");
        }        
       
        // HERE WE STORE THE VECTOR ELEMENTS INTO A DOUBLE ARRAY
        double[] datadouble = new double[data.size()];
        int j=0;
        for(Double d : data){
            datadouble[j++] = d;
        }
        return datadouble;     
        
    }
    
}
