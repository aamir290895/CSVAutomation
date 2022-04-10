package com.java.automatecsv.CSVAutomation;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.exceptions.CsvException;

import Config.WriteCSV;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, CsvException, IOException
    {
    	
    	WriteCSV.writeCSV();
    	
    	System.out.println("Congratulations ! your output csv file generate.......");
    }
}
