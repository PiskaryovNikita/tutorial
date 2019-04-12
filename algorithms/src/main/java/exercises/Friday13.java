package exercises;

import java.sql.Date;
import java.util.Arrays;

public class Friday13 {

	// 12614400000000l == 400 years, period of greg calendar
	@SuppressWarnings("deprecation")
	public static void calculate() {
		Long firstFriday = 0l, step = 1 * 24 * 60 * 60 * 1000l;
		// 400 * 365 * 24 * 3600 * 1000l;
		Long _400Years = 12614400000000l;
		Long[] arr = new Long[] {0l, 0l, 0l, 0l, 0l, 0l, 0l};
		Long[] leapYear = new Long[] {0l, 0l, 0l, 0l, 0l, 0l, 0l};
		Long[] commonYear = new Long[] {0l, 0l, 0l, 0l, 0l, 0l, 0l};
		for (long current = firstFriday; current <= _400Years; current += step) {
			Date date = new Date(current);
			if (date.getDate() == 13) {
				arr[date.getDay()]++;
				if (LeapYears.isLeapYear(date.getYear())) {
					leapYear[date.getDay()]++;
				} else {
					commonYear[date.getDay()]++;
				}
			}
		}
		Long total13 = Arrays.asList(arr).stream().reduce((a, b) -> a + b).get();
		Long total13InLeap = Arrays.asList(leapYear).stream().reduce((a, b) -> a + b).get();
		Long total13InCommon = Arrays.asList(commonYear).stream().reduce((a, b) -> a + b).get();
		System.out.println(arr[5]/(double)total13);
		System.out.println(leapYear[5]/(double)total13InLeap);
		System.out.println(commonYear[5]/(double)total13InCommon);
	}

	public static void main(String[] args) {
		calculate();
	}
}
