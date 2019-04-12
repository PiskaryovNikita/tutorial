package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactors {
	public static Object[] answer(int i) {
		List<Integer> list = new ArrayList<>();
		for (int j = 2; j < i; j++) {
			while (i % j == 0) {
				list.add(j);
				i /= j;
			}
		}
		if (i != 1) {
			list.add(i);
		}
		return list.toArray();
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(Arrays.toString(answer(10000000)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
