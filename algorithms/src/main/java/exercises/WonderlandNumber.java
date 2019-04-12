package exercises;

import java.util.ArrayList;
import java.util.List;

public class WonderlandNumber {

	public static int getWonderLandNumber() {
		List<Integer> list = new ArrayList<>();
		Integer i = 1;
		outer: for (; true; i++) {
			String s = i + "";
			for (int j = 2; j < 7; j++) {
				String multiplicated = i * j + "";
				if (multiplicated.length() > 6) {
					break outer;
				}
				if (!hasSameCharacters(s, multiplicated) || multiplicated.length() != 6) {
					continue outer;
				}
			}
			list.add(i);
		}
		System.out.println(list);
		return list.get(0);
	}

	private static boolean hasSameCharacters(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			if (s2.contains(s1.charAt(i) + "")) {
				continue;
			}
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(getWonderLandNumber());
	}
}
