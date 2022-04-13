package com.java.automatecsv.CSVAutomation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import Config.ArrangeCSV;
import Config.ReadCSV;

public class DataFill {

	public static List<String[]> setData() throws FileNotFoundException, IOException, CsvException {

		List<String[]> list = new ArrayList<String[]>();
		list.add(new String[] { "ID", "Title", "Steps", "Expected Results" });

		list.addAll(arrangeData());

		return list;

	}

	public static List<String[]> arrangeData() throws FileNotFoundException, IOException, CsvException {
		List<String[]> list = new ArrayList<String[]>();

		List<Integer> steps = ReadCSV.countSteps(3);

		String[] ids = ReadCSV.arrayOfString(0);



		List<Integer> numOfIds = new ArrayList<Integer>();
		
		List<Integer> title = new ArrayList<Integer>();



		for (int j = 0; j <= ids.length-1; j++) {

			// 1 //2 //9 //3
			title.add(j);
			numOfIds.add(j);

			for(int k=0; k<=steps.indexOf(j)-1; k++) {
				
				numOfIds.add(j);
				title.add(0);
			}

		}
		int c = numOfIds.size()-1;

		for (int i = 0; i <= c; i++) {

			list.add(ArrangeCSV.csvArray(numOfIds.indexOf(i), title.indexOf(i), i));
		}

		return list;

	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
		List<String[]> list = new ArrayList<String[]>();

		List<Integer> steps = ReadCSV.countSteps(3);

		String[] ids = ReadCSV.arrayOfString(0);

        String[] steps2 = ArrangeCSV.stepsArray();

		List<Integer> numOfIds = new ArrayList<Integer>();
		
		List<Integer> title = new ArrayList<Integer>();



		for (int j = 0; j <= ids.length-1; j++) {

			// 1 //2 //9 //3
			title.add(j);
			numOfIds.add(j);
			for(int k=0; k<=steps.indexOf(j)-1; k++) {
				
				numOfIds.add(j);
				title.add(0);
			}

		}
		
//		for(int x : numOfIds) {
//			
//			System.out.println(x);
//			
//		}
		
		System.out.println(title.size());
		System.out.println(numOfIds.size());
		System.out.println(steps2.length);

	}
	

}
