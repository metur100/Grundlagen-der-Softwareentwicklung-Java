public class Matrix {

  public static void main(String[] args) {
    // Initialisierung
    int[][] matrix = new int[3][3];
    int[][] ergebnis = new int[3][3];

    // Matrix einlesen
    System.out.println("Werte eingeben:");
    for (int i = 0;i < 3;i++) {
      for (int j = 0;j < 3;j++) {
        matrix[i][j] = StdIn.readInt();
      }
    }

    // transponierte Matrix
    for (int i = 0;i < 3; i++) {
      for (int j = 0;j < 3; j++) {
        ergebnis[i][j] = matrix[j][i];
      }
    }

    // Matrix ausgeben
    System.out.println("Matrix:");
    System.out.println(matrix[0][0] + " " + matrix[0][1] + " " + matrix[0][2]);
    System.out.println(matrix[1][0] + " " + matrix[1][1] + " " + matrix[1][2]);
    System.out.println(matrix[2][0] + " " + matrix[2][1] + " " + matrix[2][2]);

    // transponierte Matrix ausgeben
    System.out.println("transponierte Matrix:");
    System.out.println(ergebnis[0][0] + " " + ergebnis[0][1] + " " + ergebnis[0][2]);
    System.out.println(ergebnis[1][0] + " " + ergebnis[1][1] + " " + ergebnis[1][2]);
    System.out.println(ergebnis[2][0] + " " + ergebnis[2][1] + " " + ergebnis[2][2]);
  }

}
