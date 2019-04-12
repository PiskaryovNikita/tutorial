package exercises;

import java.util.Arrays;

public class GrayCode {

	public static boolean[] encode(boolean[] b) {
		boolean[] g = new boolean[b.length];
		for (int i = 0; i < b.length; i++) {
			if (i != 0 && b[i - 1]) {
				g[i] = !b[i];
			} else {
				g[i] = b[i];
			}
		}
		return g;
	}

	public static boolean[] decode(boolean[] g) {
		boolean[] b = new boolean[g.length];
		b[0] = g[0];
		for (int i = 1; i < g.length; i++) {
			b[i] = g[i] ^ b[i - 1];
		}
		return b;
	}

	public static void app(boolean[][] matr) {
		System.out.println("1 stage");
		System.out.println(Arrays.deepToString(matr));// 1
		System.out.println("2 stage");
		for (int i = 0; i < matr.length; i++) {
			System.out.println(Arrays.toString(encode(matr[i])));// 2
		}
		System.out.println("3 stage");
		for (int i = 0; i < matr.length; i++) {
			if (matr[i].length <= 5) {
				System.out.println(Arrays.toString(matr[i]));
			} else {
				System.out.println(Arrays.toString(encode(matr[i])));
			}
		}
	}

	// Test: input -> encoded, encoded -> decoded, assert decoded == input
	public static void main(String[] args) {
		app(new boolean[][] { { true, true, false }, { false, false, false },
				{ true, true, true, false, true, false } });
	}
}
