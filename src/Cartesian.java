/*
 * Cartesian.java
 *
 * Created on October 29, 2007, 8:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/**
 *
 * @author Mir Murtuza Ali
 */
public class Cartesian {
    public double x;
    public double y;
    public double z;
    private static final double NULL_XYZ = 1111111111;
    
    /** Creates a new instance of Cartesian */
    public Cartesian() {
    }
    
    public Cartesian(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public static Cartesian convertGPStoXY(GPSCoordinate point,GPSCoordinate origin){
        double xdistance;
        double ydistance;
        double zdistance;
        GPSCoordinate tempX,tempY;
        tempX = new GPSCoordinate(origin.lat,point.lon,null);
        tempY = new GPSCoordinate(point.lat,origin.lon,null);        
        xdistance = GPSCoordinate.getgreatCircle(tempX,origin);
        ydistance = GPSCoordinate.getgreatCircle(tempY,origin);
        //System.out.println(xdistance);
        //System.out.println(ydistance);
        if(point.lat.getlatitude()-origin.lat.getlatitude() < 0)
            ydistance = -ydistance;        
        if(point.lon.getlongitude()-origin.lon.getlongitude() < 0)
            xdistance = -xdistance;
        
        zdistance = point.alt.getAltitude() - origin.alt.getAltitude();
        
        Cartesian cart = new Cartesian(xdistance,ydistance,zdistance);
        return cart;           
    }
    
}
