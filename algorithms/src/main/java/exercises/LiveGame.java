package exercises;

import java.util.Arrays;

public class LiveGame {

	//clone 2d arrays -> creates new 2d array with the same refs(1d arrays)
	public static String[][] answer(String[][] arr) {
		String[][] result = copyArray(arr);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				int count = countNeighbours(arr, i, j);
				if (arr[i][j].equals(".") && count == 3) {
					result[i][j] = "*";
				} else if (arr[i][j].equals("*")) {
					if (count < 2) {
						result[i][j] = ".";
					} else if (count > 3) {
						result[i][j] = ".";
					}
				}
			}
		}
		return result;
	}

	private static String[][] copyArray(String[][] arr) {
		String[][] result = new String[arr.length][arr[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = arr[i][j];
			}
		}
		return result;
	}

	private static int countNeighbours(String[][] arr, int k, int z) {
		int count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				try {
					if (i == 0 && j == 0) {
						continue;
					}
					if (arr[k + i][z + j].equals("*")) {
						count++;
					}
				} catch (Exception e) {
				}
			}
		}
		System.out.println("k z " + k + ", " + z + " ::" + count);
		return count;
	}

	public static void main(String[] args) {
		String[][] o = new String[][] {
			"........".split(""),
			"...***..".split(""),
			"....**..".split(""),
			"........".split(""),
			};
		String[][] answer = answer(o);
		System.out.println(Arrays.deepToString(o));
		System.out.println(Arrays.deepToString(answer));
		System.out.println(o[0]);
		System.out.println(answer[0]);
	}
}
