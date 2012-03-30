/*
 * GPStoCartesian.java
 *
 * Created on November 27, 2007, 2:10 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



/**
 *
 * @author Munther Hammouri
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Vector;
import java.io.*;
public class GPStoCartesian {
    
    /** Creates a new instance of GPStoCartesian */
    public GPStoCartesian() {
    }
    
    public static void main(String[] args){
        Vector gps = new Vector(1,1);
        //
        // Enter the coordinate to be used as origin
        GPSCoordinate origin = new GPSCoordinate();
        String filename = "GPS_EARS.txt";
        int numberOfMics = 5;
        int numberOfPulses =0;
        
        try
        {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            try 
            {
                String line = null;
                int counter=0;
                
                while ((line = input.readLine()) != null)
                {
                    counter++;
                }
                input.close();
                
                numberOfPulses = counter/numberOfMics;
                String[] MajorContentsArray = new String[counter];
                String[] contentsArray = new String[numberOfMics];
                counter = 0;
                line = null;
                input = new BufferedReader(new FileReader(filename));
                
                while ((line = input.readLine()) != null)
                {
                    MajorContentsArray[counter] = line;
                    counter++;
                }
                input.close();
                
                
                origin.lat = new Latitude(34 +21.5326/60.0);
                origin.lon = new Longitude(-(89 + 33.5083/60));
                origin.alt = new Altitude(115.4);
                
                String[] SplitArray;
                String Delimiter = ",";
                String tempLine;
                
                double [] LatArray = new double[numberOfMics];
                double [] LonArray = new double[numberOfMics];
                double [] AltArray = new double[numberOfMics];
                
                for (int x=0; x< counter ; x+=numberOfMics)
                {
                    for (int i=0; i< numberOfMics ; i++)
                        contentsArray[i] = MajorContentsArray[x+i];
                    
                    for (int i=0; i< numberOfMics ; i++)
                    {
                        tempLine = contentsArray[i];
                        SplitArray = tempLine.split(Delimiter);
                        LatArray[i]= ConvertToDegrees(SplitArray[2],SplitArray[3]);
                        LonArray[i]= ConvertToDegrees(SplitArray[4],SplitArray[5]);
                        AltArray[i]= Double.parseDouble(SplitArray[9]);
                    }
                    
                    for(int i=0; i < numberOfMics; i++)
                    {
                        GPSCoordinate newcood = new GPSCoordinate();
                        newcood.lat = new Latitude(LatArray[i]);
                        newcood.lon = new Longitude(LonArray[i]);
                        newcood.alt = new Altitude(AltArray[i]);
                        gps.add(newcood);
                    }
                }
                
                GPSCoordinate[] gpslist = new GPSCoordinate[gps.size()];
                gps.copyInto(gpslist);
                Cartesian[] cart = GPSCoordinate.translateCartesian(gpslist,origin);
                BufferedWriter out = new BufferedWriter(new FileWriter("GPS_CARTESIAN_EARS.txt"));
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

