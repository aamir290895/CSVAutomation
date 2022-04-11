package Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class WriteCSV {
	
	public static void writeCSV() throws CsvException, FileNotFoundException, IOException {
		
		
		
		 File file = new File(FilePath.fileOutput);
		    try {
		        FileWriter outputfile = new FileWriter(file);
		  
		        CSVWriter writer = new CSVWriter(outputfile);
		        
		        List<String[]> newList =new ArrayList<>();
		        newList.add(new String[] {"ID" , "Title" ,"Steps" , "Expected Results"});
		        newList.add(ArrangeCSV.csvArray(0, 0, 0, 5));
		        newList.add(ArrangeCSV.csvArray(0, 0, 10, 5));	
		        newList.add(ArrangeCSV.csvArray(0, 0, 15, 5));		
		        newList.add(ArrangeCSV.csvArray(0, 0, 25, 5));		
		        newList.add(ArrangeCSV.csvArray(0, 0, 25, 5));		
		        newList.add(ArrangeCSV.csvArray(1, 1, 10, 4));		
		        newList.add(ArrangeCSV.csvArray(1, 1, 35, 5));		
		        newList.add(ArrangeCSV.csvArray(3, 0, 36, 5));		
		        newList.add(ArrangeCSV.csvArray(4, 0, 37, 5));		
		        newList.add(ArrangeCSV.csvArray(0, 0, 38, 5));		


		        writer.writeAll(newList);
		       
	   
		        writer.close();
		    }
		    catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	}

}
