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
		list.add(new String[] { "ID", "Title", "Test Type", "Steps", "Data", "Expected Results", "Summary" });

		list.addAll(arrangeData());

		return list;

	}

	public static List<String[]> arrangeData() throws FileNotFoundException, IOException, CsvException {

		List<Integer> steps = ReadCSV.countSteps();

		String[] ids = ReadCSV.arrayOfString(0);

		String[] er = ReadCSV.expectedResults();

		List<Integer> numOfIds = new ArrayList<Integer>();

		List<Integer> title = new ArrayList<Integer>();
		List<String[]> list = new ArrayList<String[]>();

		for (int j = 0; j <= steps.size() - 1; j++) {

			// 1 //2 //9 //3
			title.add(j);
			numOfIds.add(j);
			for (int k = 1; k < steps.get(j); k++) {

				numOfIds.add(j);
				title.add(ids.length);

			}

		}
		int c = er.length;

		for (int i = 0; i < c; i++) {

			list.add(ArrangeCSV.csvArray(numOfIds.get(i), title.get(i), i));
		}

		return list;

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {

		List<Integer> steps = ReadCSV.countSteps();

		String[] ids = ReadCSV.arrayOfString(0);

		String[] er = ReadCSV.expectedResults();

		List<Integer> numOfIds = new ArrayList<Integer>();

		List<Integer> title = new ArrayList<Integer>();

		for (int j = 0; j < steps.size() - 1; j++) {

			// 1 //2 //9 //3

			if (steps.get(j) != 0) {
				title.add(j);
				numOfIds.add(j);

			}

			for (int k = 1; k < steps.get(j); k++) {

				if (steps.get(j) != 0) {
					numOfIds.add(j);
					title.add(ids.length);
				}
			}

		}

		System.out.println(numOfIds.size());
		System.out.println(er.length);

		System.out.println(title.size());
	}
}
