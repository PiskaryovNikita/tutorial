package exercises;

public class CountCoins {

	public static int answer(int i) {
		int _25 = 0, _10 = 0, _5 = 0, _1 = i, count = 0;
		while (true) {
			System.out.println(_25 + " " + _10 + " " + _5 + " " + _1);
			count++;
			if (_1 - 5 >= 0) {
				_1 -= 5;
				_5++;
			} else if (_5 - 2 >= 0) {
				_10++;
				_5 -= 2;

				_1 = _5 * 5;
				_5 = 0;
			} else if (_10 - 2 >= 0 && _5 - 1 >= 0) {
				_25++;
				_10 -= 2;
				_5 -= 1;

				_1 += _10 * 10;
				_10 = 0;
			} else if (_10 - 3 >= 0) {
				_25++;
				_10 -= 3;

				_1 += _10 * 10 + 5;
				_10 = 0;
			} else {
				break;
			}
		}
		System.out.println("cannot resolve " + _25 + " " + _10 + " " + _5 + " " + _1);
		return count;
	}

	public static void main(String[] args) {
		System.out.println(answer(30));
	}

}
