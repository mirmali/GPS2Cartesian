/*
 * Generate.java
 *
 * Created on December 11, 2007, 12:42 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Mir Murtuza Ali
 */
public class Generate {
    
    /** Creates a new instance of Generate */
    public Generate() {
    }
    
    public static void main(String[] args){
        
        GenerateMoteData.generate(700,0,"E:/NCPA/Data Files/mote1.txt");
        GenerateMoteData.generate(700,-283,"E:/NCPA/Data Files/mote2.txt");
        GenerateMoteData.generate(700,288,"E:/NCPA/Data Files/mote3.txt");
    }
    
}
