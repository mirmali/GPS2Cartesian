
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ncpa
 */
public class splitNMEA {
    public splitNMEA(){

    }

    public static void main(String args[]){
        BufferedReader buf1;
        FileInputStream fis1;
        DataInputStream dis1;
        String str;
        String sp[];
        try{
            fis1=new FileInputStream("C:/Users/ncpa/Desktop/NMEA/05.txt");
            dis1 = new DataInputStream(fis1);
            buf1 = new BufferedReader(new InputStreamReader(dis1));
         //   System.out.println(buf1.readLine());
            while((str=buf1.readLine())!=null){
                sp=str.split(",");
                for(int i=1;i<=5;i++)
                    System.out.print(sp[i]+" ");                    
                System.out.println();
            }
            }catch(IOException e){
                System.out.println(e);
                
            }
    }

}
