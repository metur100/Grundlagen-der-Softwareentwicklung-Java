/******************************************************************************
 *  Compilation:  javac Schachbrett.java
 *  Execution:    java Schachbrett
 *
 *  Eingabe: Dimension (n x n)
 *  Ausgabe: Graphische Ausgabe des Schachbretts
 *
 * Schreiben Sie eine graphische Ausgabe etwa wie in der Datei Schachbrett.png
 * dargestellt.
 *
 * Tipp: Unter http://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html
 * finden Sie eine Beschreibung aller Funktionen von StdDraw. Insbesondere die
 * Funktion scale koennte hilfreich sein.
 ******************************************************************************/

public class Schachbrett {

  // Implementieren Sie ihre Loesung hier 

  /**
   * Zeichnet das einfarbige Schachbrett mithilfe von StdDraw.line(...)
   */
  public static void drawBoardWithLines(int dimension) {
    int maxWidth = dimension;
    int maxHeight = dimension;

    // Setze den Scale auf die Längen des Schachbrettes
    StdDraw.setXscale(0, maxWidth);
    StdDraw.setYscale(0, maxHeight);

    // Zeilen zeichnen
    for (int i = 0; i <= maxHeight; i++) {
      StdDraw.line(0, i, maxWidth, i);
    }
    // Spalten zeichnen
    for (int i = 0; i <= maxWidth; i++) {
      StdDraw.line(i, 0, i, maxHeight);
    }
  }

  /**
   * Zeichnet das einfarbige Schachbrett mithilfe von StdDraw.square(...)
   */
  public static void drawBoardWithSquares(int dimension) {
    // Setze den Scale auf die Längen des Schachbrettes
    StdDraw.setXscale(0, dimension);
    StdDraw.setYscale(0, dimension);

    // Quadrate zeichnen
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
	StdDraw.square(j + 0.5, i + 0.5, 0.5);
      }
    }
  }

  /**
   * Zeichnet das einfarbige Schachbrett mithilfe von StdDraw.filledSquare(...)
   */
  public static void drawBoardWithFilledSquares(int dimension) {
    // Setze den Scale auf die Längen des Schachbrettes
    StdDraw.setXscale(0, dimension);
    StdDraw.setYscale(0, dimension);

    // Quadrate zeichnen
    for (int i = 0; i < dimension; i++) {
      for (int j = 0; j < dimension; j++) {
	if ((i + j) % 2 == 0) {
	  StdDraw.filledSquare(j + 0.5, i + 0.5, 0.5);
	}
      }
    }

    // Raender zeichnen
    StdDraw.line(0, 0, 0, dimension);
    StdDraw.line(0, 0, dimension, 0);
    StdDraw.line(dimension, dimension, 0, dimension);
    StdDraw.line(dimension, dimension, dimension, 0);
  }

  /**
   * Main
   */
  public static void main(String[] args) {

    if (args.length < 1) {
      System.out.println("Error: Missing parameter! Usage: dimension");
      return;
    }

    int dimension = Integer.parseInt(args[0]);
    if (dimension <= 0) {
      System.out.println("Invalid parameter!");
      return;
    }

    //drawBoardWithLines(dimension);
    //drawBoardWithSquares(dimension);
    drawBoardWithFilledSquares(dimension);
  }

}
