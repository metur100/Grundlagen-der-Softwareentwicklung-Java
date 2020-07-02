public class Array2D{

	public static int[] createArray1D(int size) {
		
		// TODO
	}

	public static int[][] createArray2D(int sizeX, int sizeY) {
		
		// TODO
	}

	public static int[] convert2DArrayTo1D(int[][] array) {
		
		// TODO
	}

	public static int[][] convert1DArrayTo2D(int[] array, int sizeY) {
		
		// TODO
	}

	public static void print1D(int[] array) {
		
		// TODO
	}

	public static void print2D(int[][] array) {
		
		// TODO
	}

	public static void main(String[] args){
		int[] array1 = createArray1D(10);
		print1D(array1);
		System.out.println("-----------");
		
		int[][] array2 = convert1DArrayTo2D(array1, 3);
		print2D(array2);
		System.out.println("-----------");

		int[][] array3 = createArray2D(5, 5);	
		print2D(array3);
		System.out.println("-----------");

		int[] array4 = convert2DArrayTo1D(array3);
		print1D(array4);	
		System.out.println("-----------");

		// Erwartete Ausgabe:
		// 
		// 0 1 2 3 4 5 6 7 8 9 
		// -----------
		// 0 1 2 
		// 3 4 5 
		// 6 7 8 
		// 9 -1 -1 
		// -----------
		// 0 1 2 3 4 
		// 5 6 7 8 9 
		// 10 11 12 13 14 
		// 15 16 17 18 19 
		// 20 21 22 23 24 
		// -----------
		// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 
		// -----------
	}
}
