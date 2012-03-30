/*
 * GenerateFilesfromDATfiles.java
 *
 * Created on November 4, 2007, 2:19 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Mir Murtuza Ali
 */
public class GenerateFilesfromDATfiles {
    
    /**
     * Creates a new instance of GenerateFilesfromDATfiles
     */
    public GenerateFilesfromDATfiles() {
    }
    
    public static void main(String[] args){
        String filepath;
        // The directory path where the extracted mote data is to stored
        filepath = "G:/NCPA Job Work/Data Files/MoteDataCollected_4_motes/Mote_2_Extracted/";
        GPSMoteFile g = new GPSMoteFile(filepath);
        g.readfile("G:/NCPA Job Work/Data Files/MoteDataCollected_4_motes/2.dat");

    }
    
}
