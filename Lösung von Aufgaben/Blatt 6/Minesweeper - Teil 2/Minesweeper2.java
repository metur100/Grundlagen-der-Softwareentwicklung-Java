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

  /**
   * Zeichnet das Spielfeld/Gitter und alle Minen mithilfe von StdDraw
   */
  public static void drawBoard(int[][] board) {
    // Ermittele die Dimensionen der Spielfeld-Matrix
    int maxWidth = board[0].length;
    int maxHeight = board.length;

    // Bestimme die Leinwandgröße, längste Seite ist 1024 Pixel lang
    int pixelWidth = Math.min(1024, (int)((float) maxWidth / maxHeight * 1024));
    int pixelHeight = Math.min(1024, (int)((float) maxHeight / maxWidth * 1024));
    StdDraw.setCanvasSize(pixelWidth, pixelHeight);
    // Setze den Scale auf die Längen der Spielfeldmatrix
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

    // Zahlen eintragen
    for (int i = 0; i < maxHeight; i++) {
      for (int j = 0; j < maxWidth; j++) {
        String text = Integer.toString(board[i][j]);
        // Schreibe die Zahlen in die Mitte des Feldes
        StdDraw.text(j + 0.5, i + 0.5, text);
      }
    }
  }

  /**
   * Erzeugt eine Spielfeld-Matrix mit "zufaelliger" Positionierung der Minen
   */
  public static int[][] makeRandomBoard(int maxWidth, int maxHeight, int mines) {
    // Erzeuge das zweidimensionale Array für die Spielfeld-Matrix
    int[][] board = new int[maxHeight][maxWidth];

    // Zum Merken, ob eine Mine gesetzt wurde -> stellt sicher, dass n Minen gesetzt werden
    boolean unset = true;

    // Setze n Minen
    for (int i = 0; i < mines; i++) {
      // Ermittele solange eine Position fuer die Mine, bis ein Feld gefunden wurde, das noch nicht besetzt ist
      unset = true;
      while (unset) {
	// Bestimme "zufaellige" Position fuer die Mine
        int[] pos = selectRandomPosition(maxWidth, maxHeight);

        // Pruefe, ob Feld leer ist
        if (board[(maxHeight - 1) - pos[0]][pos[1]] == 0) {
	  // Setze Mine
	  // Achtung!: Speichere Array "auf dem Kopf" um dem gezeichnetem Spielfeld zu entsprechen ((0,0) ist unten links)
          board[(maxHeight - 1) - pos[0]][pos[1]] = 1;
          unset = false;
        }
      }
    }
    return board;
  }

  /**
   * Ermitteln, ob sich auf dem Feld eine Mine befindet
   */
  public static boolean isMine(int[][] board, int width, int height) {
    // Pruefe, ob auf dem Feld eine Mine liegt
    if (board[height][width] == 1) {
      // Mine -> spiele Audiodatei ab und gebe true zurueck
      StdAudio.play("explosion.wav");
      return true;
    } else {
      // Mine -> spiele Audiodatei ab und gebe false zurueck
      StdAudio.play("click.wav");
      return false;
    }
  }

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
	
    if (args.length < 5) {
      System.out.println("Error: Not enough parameters! Usage: Minesweeper2 width height number_of_mines width_mine height_mine");
      return;
    }

    int maxWidth = Integer.parseInt(args[0]);
    int maxHeight = Integer.parseInt(args[1]);
    int mines = Integer.parseInt(args[2]);
    int widthMine = Integer.parseInt(args[3]);
    int heightMine = Integer.parseInt(args[4]);
    if (maxWidth <= 0 || maxHeight <= 0
       || mines > maxWidth * maxHeight
       || widthMine < 0 || widthMine > maxWidth
       || heightMine < 0 || heightMine > maxHeight) {
      System.out.println("Invalid combination! Please change parameters.");
      return;
    }

    // Erzeuge eine Spielfeld-Matrix
    int[][] board = makeRandomBoard(maxWidth, maxHeight, mines);

    // Zeichne das Spielfeld
    drawBoard(board);

    // Pruefe, ob auf uebergebenen Feld eine Mine platziert wurde
    System.out.println("Is there a mine on field (" + widthMine + ", " + heightMine + ")?: " + isMine(board, widthMine, heightMine));
	
    //
  }

}
