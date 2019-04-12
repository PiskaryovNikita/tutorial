package exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HarryPotter {

	private static class ComparatorImpl implements Comparator<Integer> {

		@Override
		public int compare(Integer i1, Integer i2) {
			if (i2 > i1) {
				return 1;
			} else if (i1 == i2) {
				return 0;
			} else {
				return -1;
			}
		}

	}

	public static double answer(Integer[] arr) {
		double total = 0;
		double[] sales = new double[] { 1, 0.95, 0.9, 0.8, 0.75 };
		Arrays.sort(arr, new ComparatorImpl());
		if (arr[3] + arr[4] == arr[2]) {
			arr[3] += arr[4];
			arr[4] = 0;
		}
		while (arr[0] > 0) {
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 0) {
					count++;
				}
				arr[i] = arr[i] - 1;
			}
			if (count > 0) {
			total += count * 8 * sales[count - 1];
			}
		}
		return total;
	}

	//Напряжно находить ключ по к-му надо сет знач
	public static double answer2(String[] arr) {
		int price = 8;
		double totalPrice = 0;
		double[] sales = new double[] { 1, 0.95, 0.9, 0.8, 0.75 };
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		while (map.size() > 0) {
			totalPrice += map.size() * price * sales[map.size() - 1];
			for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext();) {
				String key = iterator.next();
				if (map.get(key) == 1) {
					iterator.remove();
				} else {
					map.put(key, map.get(key) - 1);
				}
			}
		}
		return totalPrice;
	}

	public static void main(String[] args) {
		double answer = answer2(new String[] { "hp1", "hp2", "hp3", "hp4", "hp5", "hp1", "hp2", "hp3" });
		System.out.println(answer);
		double answer2 = answer(new Integer[] { 4, 4, 4, 2, 2 });
		System.out.println(answer2);
	}
}
