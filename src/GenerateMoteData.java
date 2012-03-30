import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
/*
 * GenerateMoteData.java
 *
 * Created on December 11, 2007, 10:32 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Mir Murtuza Ali
 */
public class GenerateMoteData {
    
    /** Creates a new instance of GenerateMoteData */
    public GenerateMoteData() {
    }
    
    public static void generate(int sample,int delay,String filename){
        FileOutputStream fout;
        DataOutputStream dout;
        try{
            fout = new FileOutputStream(filename);
            dout = new DataOutputStream(fout);
            BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(dout));
            int i=1;
            while(i<1300){
                if(i==sample-delay){
                    buf.write("50000\n");
                    buf.write("20000\n");
                }
                else
                    buf.write("32768\n");   
                i=i+1;
            }
            buf.close();
        }catch(IOException er){
            System.out.println("Write error");
        }
    }
    
}
