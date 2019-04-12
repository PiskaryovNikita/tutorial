package exercises;

public class MagicSquares {

	static void generateSquare(int n) {
		int[][] magicSquare = new int[n][n];
		// position for 1
		int i = n / 2;
		int j = n - 1;
		for (int num = 1; num <= n * n;) {
			// 3rd condition
			if (i == -1 && j == n) {
				j = n - 2;
				i = 0;
			} else {
				//циклический перенос
				if (j == n) {
					j = 0;
				}
				if (i < 0) {
					i = n - 1;
				}
			}
			// 2nd condition
			if (magicSquare[i][j] != 0) {
				j -= 2;
				i++;
				continue;
			} else {
				magicSquare[i][j] = num++;
			}
			// 1st condition, next number
			j++;
			i--;
		}

		System.out.println("The Magic Square for " + n + ":");
		System.out.println("Sum of each row or column " + n * (n * n + 1) / 2 + ":");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				System.out.print(magicSquare[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		try {
			generateSquare(6);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
