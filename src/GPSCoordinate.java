/*
 * GPSCoordinate.java
 *
 * Created on October 28, 2007, 1:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


/**
 *
 * @author Mir Murtuza Ali
 */
public class GPSCoordinate {
    public static final double EARTH_RADIUS = 6372795.0;
    public Latitude lat;
    public Longitude lon;
    public Altitude alt;
    
    /** Creates a new instance of GPSCoordinate */
    
    public GPSCoordinate(){
        
    }
            
    public GPSCoordinate(Latitude lat,Longitude lon,Altitude alt) {
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
    }
    
    public static double getgreatCircle(GPSCoordinate A,GPSCoordinate B){
        double distance;
        double phi_s = (Math.PI/180)*A.lat.getlatitude();
        double lambda_s = (Math.PI/180)*A.lon.getlongitude();
        double phi_d = (Math.PI/180)*B.lat.getlatitude();
        double lambda_d = (Math.PI/180)*B.lon.getlongitude();
        double diff_longitude = lambda_d - lambda_s;
        double n1 = Math.cos(phi_d); double n2 = Math.sin(phi_d);
        double n3 = Math.cos(phi_s); double n4 = Math.sin(phi_s);
        double n5 = Math.cos(diff_longitude); double n6 = Math.sin(diff_longitude);
        distance = Math.atan(Math.sqrt((Math.pow(n1*n6,2))+(Math.pow((n3*n2-n4*n1*n5),2)))/(n4*n2+n3*n1*n5));
        distance = distance * (double)EARTH_RADIUS;        
        return (Math.abs(distance));
        
    }
    
     public static Cartesian[] translateCartesian(GPSCoordinate[] points,GPSCoordinate origin){
        Cartesian[] coodlist = new Cartesian[points.length];
       for(int i=0;i<points.length;i++){
         coodlist[i] = Cartesian.convertGPStoXY(points[i],origin);
        }
        return coodlist;
    }
    
        
}
