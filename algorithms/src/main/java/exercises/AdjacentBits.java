package exercises;


public class AdjacentBits {
	//YDKB02
	public static int answer(String[] arr) {
        int count = 0;
        for(int i = 0;i < arr.length;i++) {
            for(int j = 0;j < arr[i].length() - 1;j++) {
                if(arr[i].charAt(j) == '1' && arr[i].charAt(j + 1) == '1'){
                    count += 1;
                    break;
                }
            }
        }
        return arr.length - count;
    }

	public static void main(String[] args) {
	}
}
