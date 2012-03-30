/*
 * Altitude.java
 *
 * Created on December 10, 2007, 12:42 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */


/**
 *
 * @author Mir Murtuza Ali
 */
public class Altitude {
    double altitude;
    public static final float NULL_GPS = 1111;
    
    /** Creates a new instance of Altitude */
    public Altitude() {
        altitude = NULL_GPS;
    }
    
    public Altitude(double altitude){
        this.altitude = altitude;
    }
    
    public double getAltitude(){
        return altitude;
    }
}
