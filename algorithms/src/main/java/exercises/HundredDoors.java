package exercises;

import java.util.Arrays;

public class HundredDoors {

	public static boolean[] answer() {
		boolean[] arr = new boolean[100];
		for (int k = 1; k <= arr.length; k++) {
			for (int i = k - 1; i < arr.length; i += k) {
				arr[i] = !arr[i];
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(answer()));
	}
}
