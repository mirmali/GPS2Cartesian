/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.File;

/**
 *
 * @author Munther
 */
public class txtFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(File f) {
        return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
    }
    
    public String getDescription() {
        return "correct TDOA File";
    }
}
