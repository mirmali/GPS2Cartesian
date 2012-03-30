/*
 * Latitude.java
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
public class Latitude {
    double latitude;
    double degree,minutes,seconds;
    char direction;
    
    public static final float NULL_GPS = 1111;
        
    /** Creates a new instance of Latitude */
    public Latitude() {
        latitude = NULL_GPS;
    }
    
public Latitude(float degree,float minutes,float seconds,char direction){
        this.degree = degree;
        this.minutes = minutes;
        this.seconds = seconds;
        this.direction = direction;
        latitude = getlatitude(degree,minutes,seconds,direction);
    }
       
    public Latitude(double latitude){
        this.latitude = latitude;        
    }
    
    public double getlatitude(){
        return latitude;
    }
    
    public double getlatitude(float deg,float min,float sec,char dir){
         int sign=1;
         if((deg>=0&&deg<=90)&&(min>=0&&min<60)&&(sec>=0&&sec<60)&&(dir=='n'|dir=='N'|dir=='s'|dir=='S')){
         if(dir=='n'|dir=='N'){
             return (sign*(deg+(min+sec/60)/60));
         }
         if(dir=='s'|dir=='S'){
             sign=-1;         
             return (sign*(deg+(min+sec/60)/60));
            }
         
         }
             System.err.println("Check the input parameters. The format may be wrong");
             throw new IllegalArgumentException();
         
    }
    
}
             
         
        
        