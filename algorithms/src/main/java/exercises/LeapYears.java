package exercises;

public class LeapYears {
	
	public static boolean isLeapYear(int i) {
		if (i % 400 == 0) {
			return true;
		} else if (i % 4 == 0 && i % 100 != 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isLeapYear(2400));
	}
}
