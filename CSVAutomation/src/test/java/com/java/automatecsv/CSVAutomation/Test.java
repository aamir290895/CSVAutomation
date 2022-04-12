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

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {

//		String s = ArrangeCSV.joinString(20, 3);
////		
//		String[] s = ArrangeCSV.steps();
		
//		Set<String> s = ReadCSV.readInputCSV();

		List<String[]> list = DataFill.arrangeData();
		int p = 0;
//
//		for (String x : list.get(0)) {
//
//			System.out.println(x + "*" + p++ + "*");
//
//		}
//
		for (String[] y : list) {
			
			for(String x: y) {
				
				System.out.println(x + p++ );
			}

			

		}

//		
//		System.out.println(s + "%%%%");

//		   WriteCSV.writeCSV();
//
//        List<Data> beans = new CsvToBeanBuilder(new FileReader(FilePath.fileInput))
//                .withType(Data.class)
//                .build()
//                .parse();
//
//        beans.forEach(System.out::println);

	}

}
