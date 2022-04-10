package Config;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.opencsv.exceptions.CsvException;

public class ArrangeCSV {

	public static String[] csvArray(int a, int b, int c, int m)
			throws FileNotFoundException, IOException, CsvException {


		String[] id = ReadCSV.arrayOfString(0);

		String[] title = ReadCSV.arrayOfString(1);

		String[] output = { id[a], title[b], joinString(c, m) };


		

		return output;

	}
	
	
	
	public static String joinString(int k, int i) throws FileNotFoundException, IOException, CsvException {
		String[] steps = ReadCSV.arrayOfSplitedString(3);
		
		String output = "";
		
		for( int j=0; j<=i;j++) {
			
			output = output + "\n"+ steps[j+k];
			
		}
		return output;

		
		
	}



	
	
	

}
