public class Array2D{

	public static int[] createArray1D(int size) {
		int[] array = new int[size];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}

		return array;
	}

	public static int[][] createArray2D(int sizeX, int sizeY) {
		int[][] array = new int[sizeX][sizeY];
		
		int counter = 0;
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				array[i][j] = counter++;
			}
		}

		return array;
	}

	public static int[] convert2DArrayTo1D(int[][] array) {
		int sizeX = array.length;
		int sizeY = array[0].length;
		int[] arrayNew = new int[sizeX * sizeY];
		
		int index = 0;
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				arrayNew[index] = array[i][j];
				index++;
			}
		}

		return arrayNew;
	}

	public static int[][] convert1DArrayTo2D(int[] array, int sizeY) {
		int sizeX = array.length / sizeY + 1;

		int[][] arrayNew = new int[sizeX][sizeY];
		
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				arrayNew[i][j] = -1;
			}	
		}

		int indexX = 0;
		int indexY = 0;

		for (int i = 0; i < array.length; i++) {
			arrayNew[indexX][indexY] = array[i];

			indexY++;
	
			if (indexY == sizeY) {
				indexY = 0;	
				indexX++;
			}
		}

		return arrayNew;
	}

	public static void print1D(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void print2D(int[][] array) {
		int sizeX = array.length;
		int sizeY = array[0].length;	

		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
				System.out.print(array[i][j] + " ");
			}
		
			System.out.println();
		}
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
