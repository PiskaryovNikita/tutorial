package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaddlePoint {
	/**
	 * ##3##
	 * ##4##
	 * 00100
	 * ##6##
	 * ##7##
	 * 
	 * @param arr
	 * @return
	 */
	public static List<int[]> answer(int[][] arr) {
		if (arr.length != 5 || arr[0].length != 5) {
			throw new IllegalArgumentException();
		}
		List<int[]> res = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				//compare value with entire row
				boolean match = true;
				for (int k = 0; k < arr.length; k++) {
					if (arr[i][j] < arr[i][k] || arr[i][j] > arr[k][j]) {
						match = false;
					}
				}
				if (match) {
					res.add(new int[] {i, j});
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		try {
			List<int[]> answer = answer(new int[][] {
					{1, 2, 5, 4, 5},
					{1, 2, 5, 4, 5},
					{1, 2, 5, 4, 5},
					{1, 2, 5, 4, 5},
					{1, 2, 5, 4, 5}
			});
			answer.stream().forEach(n -> {System.out.println(Arrays.toString(n));});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
