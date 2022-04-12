package com.java.automatecsv.CSVAutomation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import Config.ArrangeCSV;
import Config.ReadCSV;

public class DataFill {

//	public static List<String[]> setData() throws FileNotFoundException, IOException, CsvException {
//
//		List<String[]> list = new ArrayList<String[]>();
//		list.add(new String[] { "ID", "Title", "Steps", "Expected Results" });
//
//		list.addAll(arrangeData());
//
//		return list;
//
//	}

	public static List<String[]> arrangeData() throws FileNotFoundException, IOException, CsvException {
		
	    String[] s = ArrangeCSV.steps();
		
		List<Integer> steps = ReadCSV.countSteps(3);
		
		List<Integer> id = ReadCSV.countSteps(0);

		List<Integer> title = ReadCSV.countSteps(1);

		
		


		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[] {"ID" , "Title" , "Steps" ,"Expected Result:"});

		int j = list.size() + 1;
		
		
		
		for(int i=0;i<=s.length;i++) {
			
			
			list.add(ArrangeCSV.csvArray(steps.get(i), 1, steps.get(i)+j, id.get(i)));
		}
		

		return list;

	}

}
