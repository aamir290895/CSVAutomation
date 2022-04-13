package com.java.automatecsv.CSVAutomation;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.exceptions.CsvException;

import Config.ArrangeCSV;
import Config.ReadCSV;

public class Test2 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
		
		String[] titles = ReadCSV.arrayOfString(1);
		int i =0;
		for(String x: titles) {
			
			System.out.println(x + i++);
		}
		
	}

}
