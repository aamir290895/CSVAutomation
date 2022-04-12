package com.java.automatecsv.CSVAutomation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import Config.ArrangeCSV;

public class DataFill {
	
	
	public static List<String[]> setData() throws FileNotFoundException, IOException, CsvException{
		
		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[] { "ID", "Title", "Steps", "Expected Results" });
		list.add(ArrangeCSV.csvArray(0, 1, 1));
		list.add(ArrangeCSV.csvArray(0, 0, 2));
		list.add(ArrangeCSV.csvArray(0, 0, 3));
		list.add(ArrangeCSV.csvArray(1, 2, 4));
		list.add(ArrangeCSV.csvArray(1, 0, 5));
		list.add(ArrangeCSV.csvArray(1, 0, 6));
		list.add(ArrangeCSV.csvArray(1, 0, 7));
		list.add(ArrangeCSV.csvArray(1, 0, 8));
		list.add(ArrangeCSV.csvArray(1, 0, 9));
		list.add(ArrangeCSV.csvArray(1, 0, 10));
		list.add(ArrangeCSV.csvArray(1, 0, 11));
		list.add(ArrangeCSV.csvArray(1, 0, 12));
		list.add(ArrangeCSV.csvArray(1, 0, 13));
		list.add(ArrangeCSV.csvArray(2, 3, 14));
		list.add(ArrangeCSV.csvArray(2, 0, 15));
		

		
		
		
		return list;
		
		
	}

}
