/*
 * GPStoCartesianOld.java
 *
 * Created on November 27, 2007, 2:10 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/**
 *
 * @author Mir Murtuza Ali
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;
import java.io.*;
public class GPStoCartesianOld {
    
    /** Creates a new instance of GPStoCartesianOld */
    public GPStoCartesianOld() {
    }
    
    public static void main(String[] args){
        Vector gps = new Vector(1,1);
        //
        // Enter the coordinate to be used as origin
        GPSCoordinate origin = new GPSCoordinate();
        int numberOfMics;
        try
        {
            BufferedReader input = new BufferedReader(new FileReader("C:/Documents and Settings/Munther/Desktop/NCPA/GPSData.txt"));
            try 
            {
                String line = null;
                int counter=0;
                
                while ((line = input.readLine()) != null)
                {
                    counter++;
                }
                input.close();
                
                numberOfMics = counter;
                String[] contentsArray = new String[numberOfMics];
                counter = 0;
                line = null;
                input = new BufferedReader(new FileReader("C:/Documents and Settings/Munther/Desktop/NCPA/GPSData.txt"));
                
                while ((line = input.readLine()) != null)
                {
                    contentsArray[counter] = line;
                    counter++;
                }
                input.close();
                
                String[] SplitArray;
                String Delimiter = ",";
                String tempLine;
                
                double [] LatArray = new double[numberOfMics];
                double [] LonArray = new double[numberOfMics];
                double [] AltArray = new double[numberOfMics];
                
                for (int i=0; i< numberOfMics ; i++)
                {
                    tempLine = contentsArray[i];
                    SplitArray = tempLine.split(Delimiter);
                    LatArray[i]= ConvertToDegrees(SplitArray[2],SplitArray[3]);
                    LonArray[i]= ConvertToDegrees(SplitArray[4],SplitArray[5]);
                    AltArray[i]= Double.parseDouble(SplitArray[9]);
                }
                
                origin.lat = new Latitude(LatArray[0]);
                origin.lon = new Longitude(LonArray[0]);
                origin.alt = new Altitude(AltArray[0]);
                
                for(int i=1; i < numberOfMics; i++)
                {
                    GPSCoordinate newcood = new GPSCoordinate();
                    newcood.lat = new Latitude(LatArray[i]);
                    newcood.lon = new Longitude(LonArray[i]);
                    newcood.alt = new Altitude(AltArray[i]);
                    gps.add(newcood);
                }
                

                GPSCoordinate[] gpslist = new GPSCoordinate[gps.size()];
                gps.copyInto(gpslist);
                Cartesian[] cart = GPSCoordinate.translateCartesian(gpslist,origin);
                BufferedWriter out = new BufferedWriter(new FileWriter("C:/Documents and Settings/Munther/Desktop/NCPA/GPSCoordCartesianCoverted.txt"));
                for(int j=0;j<cart.length;j++)
                {
                    //String fileentry = gpslist[j].lat + " " + (double)gpslist[j].lon + "\t";
                    String fileentry2 = cart[j].x + "  " + cart[j].y + "  " + cart[j].z + "\n";
                    // out.write(fileentry);
                    out.write(fileentry2);
                }
                out.close();
            }
            finally
            {
                input.close();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
       }

    
    static double ConvertToDegrees(String ValueToConvert,String Sign)
    {
            double ValueConverted;
            String[] ConversionArray = ValueToConvert.split("\\.");
            String Degree = ConversionArray[0].substring(0,ConversionArray[0].length()-2);
            String Mins = ConversionArray[0].substring(ConversionArray[0].length()-2,ConversionArray[0].length());
            String MinsAfterDecimal = ConversionArray[1];
            double MinsConvertedToDegrees = (Double.parseDouble(Mins + "." + MinsAfterDecimal) / 60);
            
            ValueConverted  = Double.parseDouble(Degree) + MinsConvertedToDegrees;
            int SignComparison = Sign.compareToIgnoreCase("S") * Sign.compareToIgnoreCase("W"); 
            if (SignComparison == 0)
                ValueConverted *= -1;            
            return ValueConverted;
    }
}
