package Config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.exceptions.CsvException;

public class ArrangeCSV {

	public static String[] csvArray(int a, int b, int c) throws FileNotFoundException, IOException, CsvException {

		String[] ids = ReadCSV.arrayOfString(0);

		String[] titles = ReadCSV.arrayOfString(1);

		String[] steps = ReadCSV.arrayOfSteps();
		String[] expectedResult = ReadCSV.expectedResults();

		String[] testTypes = testTypes();

		List<String> list = new ArrayList<String>();

		List<String> list2 = new ArrayList<String>();
		List<String> list3 = new ArrayList<String>();
		List<String> list4 = new ArrayList<String>();

		List<String> list5 = new ArrayList<String>();

		for (String x : titles) {

			list.add(x);
		}

		for (String y : ids) {

			list2.add(y);
		}

		for (String z : steps) {

			list3.add(z);
		}

		for (String k : expectedResult) {

			list4.add(k);
		}

		for (String k : testTypes) {

			list5.add(k);
		}
		list.add(" ");
		list2.add(" ");
		list3.add(" ");

		list4.add(" ");
		list5.add(" ");

		String[] titles2 = list.toArray(new String[list.size()]);

		String[] ids2 = list2.toArray(new String[list2.size()]);
		String[] steps2 = list3.toArray(new String[list3.size()]);
		String[] expectedResult2 = list4.toArray(new String[list4.size()]);
		String[] testTypes2 = list5.toArray(new String[list5.size()]);

		String[] output = { ids2[a], titles2[b], testTypes2[b], steps2[c], " ", expectedResult2[c], " " };

		return output;

	}

	public static List<Integer> repeatInt(int a) throws FileNotFoundException, IOException, CsvException {

//		List<Integer> n = ReadCSV.countSteps(3);

		List<Integer> s = new ArrayList<>();

		for (int k = 0; k <= a; k++) {

			s.add(k);

		}

		return s;

	}

	public static String[] testTypes() throws CsvException, IOException {

		String[] title = ReadCSV.arrayOfString(1);

		List<String> list = new ArrayList<String>();

		for (int i = 0; i <= title.length - 1; i++) {

			if (title[i].startsWith("Automation")) {

				list.add("Automated");
			} else {
				list.add("Manual");

			}

		}
		return list.toArray(new String[list.size()]);

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
		for (String x : csvArray(3, 3, 3)) {

			System.out.println(x);
		}
	}
}
