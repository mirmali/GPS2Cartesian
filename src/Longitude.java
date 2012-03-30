/*
 * Longitude.java
 *
 * Created on October 28, 2007, 1:59 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/**
 *
 * @author Mir Murtuza Ali
 */
public class Longitude {
    double longitude;
    double degree,minutes,seconds;
    char direction;
    public static final float NULL_GPS = 1111;
        
    /** Creates a new instance of Longitude */
    public Longitude() {
        longitude = NULL_GPS;
    }
    
    public Longitude(float degree,float minutes,float seconds,char direction){
        this.degree = degree;
        this.minutes = minutes;
        this.seconds = seconds;
        this.direction = direction;
        longitude = getlongitude(degree,minutes,seconds,direction);
    }
       
    public Longitude(double longitude){
        this.longitude = longitude;        
    }
    
    public double getlongitude(){
        return longitude;
    }
    
    public double getlongitude(float deg,float min,float sec,char dir){
         int sign=1;
         if((deg>=0&&deg<=180)&&(min>=0&&min<60)&&(sec>=0&&sec<60)&&(dir=='e'|dir=='E'|dir=='w'|dir=='W')){
         if(dir=='e'|dir=='E'){
             return (sign*(deg+(min+sec/60)/60));
         }
         if(dir=='e'|dir=='W'){
             sign=-1;         
             return (sign*(deg+(min+sec/60)/60));
            }
         
         }
             System.err.println("Check the input parameters. The format may be wrong");
             throw new IllegalArgumentException();
         
    }
    
}
             
         
        
        