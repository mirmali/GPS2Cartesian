
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
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
public class test3 {
    public test3(){

    }

    public static void main(String[] args){
        BufferedReader buf1,buf2;
        FileInputStream fis1,fis2;
        DataInputStream dis1,dis2;
        String str;
        ArrayList lines = new ArrayList(7);
        int cnt=0;
        
        try{
            fis1=new FileInputStream("EARS_GPS_Cartesian_TDOA_8.txt");
            dis1 = new DataInputStream(fis1);
            buf1 = new BufferedReader(new InputStreamReader(dis1));
            while(true){
            for(int i=0;i<7;i++){
                str=buf1.readLine();
                lines.add(str);
            }
            System.out.println(buf1.readLine());
            for(int j=0;j<lines.size();j++)
                System.out.println(lines.get(j));
            cnt=cnt+8;
            lines.clear();
            if(cnt==400)
                break;
        }

        }catch(IOException e){
            
        }
            
    }

}
