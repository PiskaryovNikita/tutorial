package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {
	static int count = 0;

	public static List<String> answer(String[] prefix, String[] sarr) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < sarr.length; i++) {
			if (sarr.length > 2) {
				String[] copyprefix = Arrays.copyOf(prefix, prefix.length + 1);
				copyprefix[copyprefix.length - 1] = sarr[i];
				String[] copysarr = new String[sarr.length - 1];
				for (int j = 0, k = 0; j < sarr.length; j++) {
					if (sarr[j] != sarr[i]) {
						copysarr[k++] = sarr[j];
					}
				}
				list.addAll(answer(copyprefix, copysarr));
			} else {
				count++;
				if (i == sarr.length - 1) {
					String temp = sarr[0];
					sarr[0] = sarr[i];
					sarr[i] = temp;
				} else {
					String temp = sarr[i + 1];
					sarr[i + 1] = sarr[i];
					sarr[i] = temp;
				}
				String[] total = new String[prefix.length + sarr.length];
				System.arraycopy(prefix, 0, total, 0, prefix.length);
				System.arraycopy(sarr, 0, total, prefix.length, sarr.length);
				list.add(merge(total));
			}
		}
		return list;
	}
	
	public static String merge(String[] arr) {
		String s = "";
		for (int i = 0; i < arr.length; i++) {
			s += arr[i];
		}
		return s;
	}

	public static void main(String[] args) {
		try {
			List<String> answer = answer(new String[0], new String[] {"a", "b", "c", "d", "e"});
			System.out.println(answer);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
