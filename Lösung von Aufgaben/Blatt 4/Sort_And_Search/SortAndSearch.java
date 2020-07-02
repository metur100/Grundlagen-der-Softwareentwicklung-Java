public class SortAndSearch {

	public static int search(int[] array, int element) {
		
		int index;
		int rangeStart = 0;
		int rangeEnd = array.length - 1;

		while (rangeStart <= rangeEnd) {

			index = rangeStart + ((rangeEnd - rangeStart) / 2);
			if (array[index] == element) {
				return index;
			} else {
				if (array[index] < element) {
					rangeEnd = index - 1;
				} else {
					rangeStart = index + 1;
				}
			}	 
		}

		return -1;
	}

	public static void sort(int[] array) {
			
		// Leere Liste sowie ein-elementige Liste ist bereits sortiert
		if (array.length <= 1) {
			return;
		}

		boolean finished;	

		do {		
			finished = true;
	
			for (int i = 0; i < array.length - 1; i++) {
				
				if (array[i] < array[i + 1]) {
					int tmp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = tmp;

					finished = false;
				}
			}
		} while (!finished);
		
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}	
		
		System.out.println();
	}

	public static void main(String[] args) {

		if (args.length < 2) {
			System.out.println("Usage: SortAndSearch <array size> <search value>");
			return;
		}

		int n = Integer.parseInt(args[0]);
		int value = Integer.parseInt(args[1]);

		if (n < 0 || value < 0) {
			return;
		}

		int[] array = new int[n];

		// Fuelle array mit Zufallszahlen 0-20
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 20);
		}

		System.out.println("Array vor sort:");
		printArray(array);

		sort(array);

		System.out.println("Array nach sort:");
		printArray(array);

		if (array.length > 1) {
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] < array[i + 1]) {
					System.out.println("!!! Fehler: Array nicht vollstaendig sortiert");
					return;
				}
			}
		} 

		System.out.println("Array sortiert, ok");
		System.out.println("Suche Wert: " + value);

		int index = search(array, value);
		if (index != -1) {
			System.out.println("Wert gefunden an Position " + index);
		} else {
			System.out.println("Wert nicht gefunden");
		}
	}
}
