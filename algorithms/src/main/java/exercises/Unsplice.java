package exercises;

import java.util.Arrays;

public class Unsplice {
	
	//pointers
	public static int answer(String s) {
		int count = 0;
		String[] arr = s.split("");
		String prev, curr = "";
		for (int i = 0; i < arr.length; i++) {
			prev = curr;
			curr = arr[i];
			if (prev.equals("\\") && curr.equals("\n")) {
				count++;
			}
		}
		System.out.println(Arrays.toString(arr));
		return count;
	}

	public static void main(String[] args) {
		try {
			System.out.println(answer("ab\\\ncd\\\nef"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/**
 * n * {2,3,4,5,6} = n`;
 */
}
