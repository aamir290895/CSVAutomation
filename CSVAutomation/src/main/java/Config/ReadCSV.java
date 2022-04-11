package Config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.exceptions.CsvException;

public class ReadCSV {

	public static Set<String> readIndex(int index) throws FileNotFoundException, IOException, CsvException {

		List<String[]> data = null;

		try (CSVReader reader = new CSVReader(new FileReader(FilePath.fileInput))) {
			data = reader.readAll();
		}

		Set<String> set = new HashSet<>();
		for (String[] arrays : data)

			set.add(arrays[index]);
		return set;

	}

	public static String[] arrayOfString(int index) throws FileNotFoundException, IOException, CsvException {

		Set<String> s = readIndex(index);

		String[] arrayOfString = new String[s.size()];

		int i = 0;
		for (String str : s)
			arrayOfString[i++] = str;
		return arrayOfString;

	}

	public static String[] arrayOfSplitedString(int index) throws FileNotFoundException, IOException, CsvException {

		String[] s = arrayOfString(index);

		String[] t = {};
		
	    List<String> strings = new ArrayList<>();

		for (String x : s) {

			x.lines().forEach(c -> strings.add(c));
			t = strings.toArray(new String[strings.size()]);

		}



		return t;

	}
	
	
	public static String[] arrayOfSteps(int index) throws FileNotFoundException, IOException, CsvException{
		
		String[] s = arrayOfString(index);
        String[] n = {};
	    List<String> strings = new ArrayList<>();
        
       
        
        for(String x : s) {
        	n= x.split( "[\\d][.]");
        	
        	for(String y: n) {
        		
        		strings.add(y);
        	}
        	
        }
        
		n = strings.toArray(new String[strings.size()]);

		
		return n;
		
		
		
	}

}
