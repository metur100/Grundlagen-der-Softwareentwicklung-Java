/******************************************************************************
 *  Compilation:  javac Minesweeper2.java
 *  Execution:    java Minesweeper2
 *
 *  Eingabe: Breite Hoehe Anzahl-an-Minen Mine-Breite Mine-Hoehe
 *  Ausgabe: Graphische Ausgabe des Boards und Audio-Wiedergabe
 *
 * Verwenden Sie die Musterloesung von Minesweeper1 oder Ihre eigene 
 * Implementierung und schreiben Sie eine graphische Ausgabe etwa wie 
 * in der Datei Minesweeper.png dargestellt.
 *
 * Modifizieren Sie die Methode makeRandomBoard so, dass garantiert n Minen
 * gesetzt werden, wenn das Spielfeld mindestens n Felder hat.
 *
 * Geben Sie in der Methode isMine die Datei explosion.wav aus, wenn auf dem
 * Feld eine Mine liegt und die Datei click.wav wenn nicht.
 *
 * Tipp: Unter http://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html
 * finden Sie eine Beschreibung aller Funktionen von StdDraw. Insbesondere die
 * Funktionen scale und setCanvasSize koennten hilfreich sein.
 * 
 * Tipp: Unter http://introcs.cs.princeton.edu/java/stdlib/javadoc/StdAudio.html
 * finden Sie eine Beschreibung aller Funktionen von StdAudio.
 ******************************************************************************/

public class Minesweeper2 {

  // Implementieren Sie ihre Loesung hier 

  //


  /**
   * Berechnet die Anzahl an Minen in der Nachbarschaft
   */
  public static int countMines(int[][] board, int width, int height) {
    // Ermittele die Dimensionen der Spielfeld-Matrix
    int maxHeight = board.length;
    int maxWidth = board[0].length;

    // Zum Merken der Minenanzahl
    int count = 0;

    // Iteriere ueber die Zeile ueber dem Feld, mit dem Feld und unter dem Feld
    for (int i = height - 1; i <= height + 1; i++) {
      // Iteriere ueber die Spalte links neben dem Feld, mit dem Feld und rechts neben dem Feld
      for (int j = width - 1; j <= width + 1; j++) {
        if (i < maxHeight && i >= 0 &&    // Zeile ist gueltig
            j < maxWidth && j >= 0 &&     // Spalte ist gueltig
            board[i][j] == 1              // Es ist eine Mine
			) {
          count++;
        }
      }
    }
    return count;
  }

  /**
   * Gibt eine "zufaellige" Position innerhalb der Spielfeld-Matrix zurueck
   */
  public static int[] selectRandomPosition(int maxWidth, int maxHeight) {
    // Bestimme "zufaellige" Hoehe mithilfe von StdRandom
    int randomHeight = StdRandom.uniform(0, maxHeight);
    // Bestimme "zufaellige" Breite mithilfe von StdRandom
    int randomWidth = StdRandom.uniform(0, maxWidth);
    return new int[]{randomHeight, randomWidth};
  }

  /**
   * Main
   */
  public static void main(String[] args) {
    StdRandom.setSeed(42);
	
	// Implementieren Sie ihre Loesung hier 

	//
  }

}
