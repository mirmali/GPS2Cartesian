/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;

/**
 *
 * @author Munther
 */
public class leftFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith("leftnmea.txt");
    }
    
    public String getDescription() {
        return "correct channel NMEA Files";
    }
}
