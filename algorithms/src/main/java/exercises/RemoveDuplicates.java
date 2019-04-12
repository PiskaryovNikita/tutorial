package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {
	
	public static List<Integer> removeDuplicates(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if (i != j && list.get(i).equals(list.get(j))) {
					list.remove(i);
					i--;
					break;
				}
			}//i == -1
		}//i == 0
		return list;
	}

	public static void main(String[] args) {
		List<Integer> duplicates = new ArrayList<>();
		duplicates.addAll(Arrays.asList(1, 1, 1, 2, 2, 3, 3));
		try {
			System.out.println(removeDuplicates(duplicates));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
