
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
public class ParseNMEA {
    public ParseNMEA(){

    }

    public static void main(String[] args){
        BufferedReader buf1;
        FileInputStream fis1;
        DataInputStream dis1;
        String str;
        ArrayList lines;
        int cnt=0;
        String split[];
        Latitude orlat=new Latitude(34.4044816666667);
        Longitude orlon=new Longitude(-89.5756283333334);
        Altitude oralt=new Altitude(0.0);
        GPSCoordinate origin = new GPSCoordinate(orlat,orlon,oralt);
        Latitude templat;
        Longitude templon;
        Altitude tempalt;
        GPSCoordinate gps_list[] = new GPSCoordinate[3100];
        int i=0;

        try{
            fis1=new FileInputStream("C:/Users/ncpa/Desktop/GPS_NMEA/02.txt");
            dis1 = new DataInputStream(fis1);
            buf1 = new BufferedReader(new InputStreamReader(dis1));
            while((str=buf1.readLine())!=null){
                split  = str.split(" ");
                double lat = Double.parseDouble(split[1]);
                lat = ((lat%100)/60.0 + (((int)lat-((int)lat%100))/100.0));
                if(split[2].matches("N"))
                    templat = new Latitude(lat);
                else
                    templat = new Latitude(-1.0*lat);
                double lon = Double.parseDouble(split[3]);
                lon = ((lon%100)/60.0 + (((int)lon-((int)lon%100))/100.0));
                if(split[4].matches("W"))
                    templon = new Longitude(-1*lon);
                else
                    templon = new Longitude(lon);
                tempalt = new Altitude(0.0);
                gps_list[i] = new GPSCoordinate(templat, templon, tempalt);
                i=i+1;
            }

            buf1.close();
            BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/ncpa/Desktop/GPS_NMEA/02_xy.txt"));
            Cartesian car[] = GPSCoordinate.translateCartesian(gps_list, origin);
            for(int z=0;z<car.length;z++){
                out.write(car[z].x + " " + car[z].y);
                out.write("\n");
                }
            out.close();
        
    }catch(IOException e){
        System.out.println(e);
    }

}

}
