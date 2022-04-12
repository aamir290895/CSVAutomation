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

		String[] s = ArrangeCSV.expectedResults();
		for (int i = 0; i <= s.length; i++) {

			System.out.println(s[i] + "^^" );
		}

	}

}
