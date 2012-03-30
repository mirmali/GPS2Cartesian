/*
 * ConvertCoordinates.java
 *
 * Created on December 10, 2007, 12:21 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


import java.io.*;

/**
 *
 * @author Mir Murtuza Ali
 */
public class ConvertCoordinates {
    
    /** Creates a new instance of ConvertCoordinates */
    public ConvertCoordinates() {
    }
    
    public static void main(String[] args){
        Latitude or_lat = new Latitude(34+21.5326/60.0);
        Longitude or_lon = new Longitude(-(89+33.5083/60.0));
        Altitude or_alt = new Altitude(115.4);

        Latitude p2_lat = new Latitude(34+21.5299/60.0);
        Latitude p3_lat = new Latitude(34+21.5174/60.0);
        Latitude p4_lat = new Latitude(34+21.5159/60.0);
        Latitude p5_lat = new Latitude(34+21.5228/60.0);

        
        Longitude p2_lon = new Longitude(-(89+33.4962/60.0));
        Longitude p3_lon = new Longitude(-(89+33.4890/60.0));
        Longitude p4_lon = new Longitude(-(89+33.5023/60.0));
        Longitude p5_lon = new Longitude(-(89+33.5018/60.0));
        //Altitude or_alt = new Altitude(0);
        
        Altitude p2_alt = new Altitude(126.1);
        Altitude p3_alt = new Altitude(122.8);
        Altitude p4_alt = new Altitude(120.1);
        Altitude p5_alt = new Altitude(116.5);
        //GPSCoordinate origin = new GPSCoordinate(or_lat,or_lon,or_alt);
        GPSCoordinate origin = new GPSCoordinate(or_lat,or_lon,or_alt);
        GPSCoordinate point_two = new GPSCoordinate(p2_lat,p2_lon,p2_alt);
        GPSCoordinate point_thr = new GPSCoordinate(p3_lat,p3_lon,p3_alt);
        GPSCoordinate point_four = new GPSCoordinate(p4_lat,p4_lon,p4_alt);
        GPSCoordinate point_five = new GPSCoordinate(p5_lat,p5_lon,p5_alt);
        
        GPSCoordinate[] ar = {point_two,point_thr,point_four,point_five};
        Cartesian[] car = GPSCoordinate.translateCartesian(ar,origin);
        
        try{
        BufferedWriter out = new BufferedWriter(new FileWriter("GPSCoordCartesianCoverted.txt"));
        for(int i=0;i<4;i++){
            out.write(car[i].x + "\t" + car[i].y + "\t" + car[i].z);
            out.write("\n");
        }
        out.close();
        }catch(IOException er){
            System.out.println("write error");
        }  
     
    }
    
}
