public class PotRec {
	
	public static int potRec(int x, int y) {
		int pot;

		if (y == 0) {
			pot = 1;
		} else {
			pot = x * potRec(x, y - 1);
		}

		return pot;
	}	

	public static void main(String[] args) {
		System.out.println("2^3: " + potRec(2, 3));
		System.out.println("2^0: " + potRec(2, 0));
		System.out.println("10^5: " + potRec(10, 5));
	}
}
