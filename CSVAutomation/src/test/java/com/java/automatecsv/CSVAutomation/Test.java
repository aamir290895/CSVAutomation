package com.java.automatecsv.CSVAutomation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opencsv.exceptions.CsvException;

import Config.ArrangeCSV;
import Config.ReadCSV;
import Config.WriteCSV;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException,ArrayIndexOutOfBoundsException {

		String[] titles = ReadCSV.arrayOfString(1);
		
		String[] raw = ArrangeCSV.stepsArray();

		
		System.out.println(raw.length);
//		for (int i = 0; i <= s.length-1; i++) {
//
//			System.out.println(s[0] + "^^" );
//		}

	}

}
