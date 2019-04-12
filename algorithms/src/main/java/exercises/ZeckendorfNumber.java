package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZeckendorfNumber {

	public static List<Integer> generateFibonacciRow(int i) {
		List<Integer> fbSeq = new ArrayList<>(Arrays.asList(1, 2));
		int prePrev = 1;
		int prev = 2;
		int curr = 3;
		while (curr < i) {
			fbSeq.add(curr);
			prePrev = prev;
			prev = curr;
			curr = prev + prePrev;
		}
		return fbSeq;
	}

	public static void printTable() {
		List<Integer> row = generateFibonacciRow(20);
		List<String> table = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			String s = i + ": ";
			if (row.contains(i)) {
				table.add(s + i);
				continue;
			}
			int j = i;
			do {
				s += " " + findClosestInRow(row, j);
			} while ((j = j % findClosestInRow(row, j)) != 0);
			table.add(s);
		}
		table.forEach(i -> System.out.println(i));
	}

	public static int findClosestInRow(List<Integer> row, int num) {
		int min = row.get(0);
		for (int i = 1; i < row.size() && row.get(i) <= num; i++) {
			if (num - row.get(i) < num - min) {
				min = row.get(i);
			}
		}
		return min;
	}

	public static void main(String[] args) {
		/*
		 * Теперь из ряда составить числа 1-20
		 */
		System.out.println(generateFibonacciRow(20));
		printTable();
	}
}
