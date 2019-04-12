package exercises;

import java.util.LinkedList;
import java.util.List;

public class Haiku {

	public static List<Object> answer(String s) {
		List<Object> res = new LinkedList<>();
		String[] lines = s.split("/");
		for (String line : lines) {
			Integer count = 0;
			char curr = 0, prev;
			for (int i = 0; i < line.length(); i++) {
				prev = curr;
				curr = line.charAt(i);
				boolean predicate1 = curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u'
						|| curr == 'y';
				boolean predicate2 = prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u'
						|| prev == 'y';
				if (predicate1 && !predicate2) {
					count++;
				}
			}
			res.add(count);
		}
		res.add("N");
		if (res.get(0).equals(5) && res.get(1).equals(7) && res.get(2).equals(5)) {
			res.set(3, "Y");
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(answer("happy purple frog/eating bugs in the marshes/get indigestion"));
	}
}
