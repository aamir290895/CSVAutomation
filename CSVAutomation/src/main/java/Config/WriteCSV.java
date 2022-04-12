package Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.java.automatecsv.CSVAutomation.DataFill;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class WriteCSV {

	public static void writeCSV(List<String[]> list) throws CsvException, FileNotFoundException, IOException {

		File file = new File(FilePath.fileOutput);
		try {
			FileWriter outputfile = new FileWriter(file);

			CSVWriter writer = new CSVWriter(outputfile);

			writer.writeAll(list);

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
