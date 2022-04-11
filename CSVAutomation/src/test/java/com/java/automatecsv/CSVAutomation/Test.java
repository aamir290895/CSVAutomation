package com.java.automatecsv.CSVAutomation;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.exceptions.CsvException;

import Config.ReadCSV;
import Config.WriteCSV;

public class Test {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
		
//		String s = ArrangeCSV.joinString(20, 3);
////		
		String[] s = ReadCSV.arrayOfSplitedString(3);
////		
////		System.out.println(s1[4]);
////		
////	
		int p = 0;
		for(String x : s) {			
			
			System.out.println(x + "*" + p++ + "*");
       	}
////		
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
