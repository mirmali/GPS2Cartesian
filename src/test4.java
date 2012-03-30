
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
public class test4 {
    public test4(){

    }

    public static void main(String[] args){
        BufferedReader buf1,buf2;
        FileInputStream fis1,fis2;
        DataInputStream dis1,dis2;
        String str;
        String time;
        int i=0;
        int z=0;

        try{
            fis1=new FileInputStream("C:/Users/ncpa/Desktop/test/04/tdoa_time.dat");
            dis1=new DataInputStream(fis1);
            buf1=new BufferedReader(new InputStreamReader(dis1));
            fis2=new FileInputStream("I:/NCPABACKUP/EARS Num Analysis/EARS_GPS_Cartesian_TDOA_8.txt");
            dis2=new DataInputStream(fis2);
            buf2=new BufferedReader(new InputStreamReader(dis2));
            time=buf1.readLine();
            String t[]=time.split(",");
            System.out.println(t.length);
            while((str=buf2.readLine())!=null){
                i=i+1;
                if(i!=5)
                    System.out.println(str);
                else{
                    String s[]=str.split(" ");
                    for(int j=0;j<s.length-1;j++){
                        System.out.print(s[j]+" ");
                    }
                    System.out.println(t[z]);
                    z=z+1;
                }
                if(i==8)
                    i=0;
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }

}
