package exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CombinedNumbers {
	
	public static String answer(String[] arr) {
        List<String> list = Arrays.asList(arr);
        list.sort(new Comparator<String>() {
        	public double count(String s) {
        		double sum = 0;
        		for (int i = 0; i < s.length(); i++) {
					sum += Integer.parseInt(s.charAt(i) + "");
				}
        		System.out.println(sum/s.length());
        		return sum/s.length();//relation sum/len
        	}
        	
			public int compare(String s1, String s2) {
				if (count(s2) > count(s1)) {
					return 1;
				} else if (count(s2) == count(s1)) {
					return 0;
				} else {
					return -1;
				}
			}
		});
        String res= "";
        for (String string : list) {
			res += string;
		}
        return res;
    }

	public static void main(String[] args) {
		System.out.println(answer(new String[] {"42", "423", "420"}));
	}

}
