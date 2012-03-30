
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ncpa
 */
public class test {

    public test(){

    }

    public static void main(String[] args){
        BufferedReader buf1,buf2;
        FileInputStream fis1,fis2;
        DataInputStream dis1,dis2;
        String str;
        ArrayList tdoa = new ArrayList();
        ArrayList gps = new ArrayList();
        ArrayList fin = new ArrayList();

        try{
            fis1=new FileInputStream("G:/Experiments/EARS 02 19 2010/EARS_TDOA_EARS_Binary_08.txt");
            dis1 = new DataInputStream(fis1);
            buf1 = new BufferedReader(new InputStreamReader(dis1));
            while((str=buf1.readLine())!=null){
                tdoa.add(str);
            }
            fis2=new FileInputStream("G:/Experiments/GPS2Cartesian/GPSCoordCartesianCoverted_8.txt");
            dis2 = new DataInputStream((fis2));
            buf2=new BufferedReader(new InputStreamReader(dis2));
            while((str=buf2.readLine())!=null){
                gps.add(str);
            }
            String s="";
            int k=0;
            int j=0;
            for(int i=0;i<52;i++){
                fin.add(gps.get(i) + " " + tdoa.get(k));
                fin.add(gps.get(i+52) + " " + tdoa.get(k+1));
                fin.add(gps.get(i+2*52) + " " + tdoa.get(k+2));
                fin.add(gps.get(i+3*52) + " " + tdoa.get(k+3));
                fin.add(gps.get(i+4*52) + " " + tdoa.get(k+4));
                fin.add(gps.get(i+5*52) + " " + tdoa.get(k+5));
                fin.add(gps.get(i+6*52) + " " + tdoa.get(k+6));
                //fin.add(gps.get(i+7*52) + " " + tdoa.get(k+7));
                fin.add(gps.get(i+7*52) + " " + "0.0");
                k=k+7;
            }
            buf1.close();
            buf2.close();
            BufferedWriter out = new BufferedWriter(new FileWriter("8_rearraged.txt"));
            for(int z=0;z<fin.size();z++){
                out.write(String.valueOf(fin.get(z)));
                out.newLine();
            }
            out.close();




        }catch(IOException e){
            System.err.print(e);
            


        }


        
        
        

    }
}
