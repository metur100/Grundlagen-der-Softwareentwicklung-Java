/******************************************************************************
 *  Compilation:  javac Minesweeper3.java
 *  Execution:    java Minesweeper3
 *
 *  Eingabe: Breite Hoehe Anzahl-an-Minen
 *  Ausgabe: Graphische Ausgabe des Boards und Audio-Wiedergabe, spielfaehig
 *
 * Verwenden Sie die Musterloesung von Minesweeper2 oder Ihre eigene
 * Implementierung und schreiben Sie eine spielfaehige Loesung.
 *
 ******************************************************************************/

import java.awt.Font;

 
public class Minesweeper3 {

  // Implementieren Sie ihre Loesung hier 

  /**
   * Zeichnet das Spielfeld/Gitter mithilfe von StdDraw
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
    // Veraendere den Font, erfordert den Import von java.awt.Font
    StdDraw.setFont(new Font("Arial", Font.BOLD, 30));

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
   * Zeichnet das Spielfeld/Gitter und alle Minen
   */
  public static void drawUncoveredBoard(int[][] board) {
    // Ermittele die Dimensionen der Spielfeld-Matrix
    int maxWidth = board[0].length;
    int maxHeight = board.length;

    // Zeichne das Spielfeld/Gitter
    drawBoard(board);

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
   * Zeichnet nur das Spielfeld/Gitter
   */
  public static void drawCoveredBoard(int[][] board) {
    // Zeichne das Spielfeld/Gitter
    drawBoard(board);
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
	  // Setze Mine, speichere Array "auf dem Kopf" um dem gezeichnetem Spielfeld zu entsprechen ((0,0) ist unten links)
          board[(maxHeight - 1) - pos[0]][pos[1]] = 1;
          unset = false;
        }
      }
    }
    return board;
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

  /**
   * Ermittelt, ob das Spiel gewonnen wurde
   */
  public static boolean isWinner(int maxWidth, int maxHeight, int mines, int uncoveredFields) {
    // Ermittele die Anzahl an Feldern ohne Mine
    int fieldsToUncover = maxWidth * maxHeight - mines;

    // Pruefe, ob alle Felder ohne Mine aufgedeckt wurden
    if (uncoveredFields == fieldsToUncover) {
      // Gewonnen
      return true;
    } else {
      // Noch nicht gewonnen
      return false;
    }
  }

  /**
   * Vermittelt die Niederlage
   */
  public static void defeat(int[][] board, int maxWidth, int maxHeight) {
    // Zeichne Spielfeld mit allen Minen
    drawUncoveredBoard(board);

    // Schreibe in großer, roter Schrift oben auf das Spielfeld "Verloren!"
    StdDraw.setPenColor(255, 0, 0);
    StdDraw.setFont(new Font("Arial", Font.BOLD, 60));
    StdDraw.text((float) maxWidth / 2, (float) maxHeight - 0.25, "Verloren!");
  }

  /**
   * Vermittelt den Sieg
   */
  public static void victory(int maxWidth, int maxHeight) {
    // Schreibe in großer, gruener Schrift oben auf das Spielfeld "Gewonnen!"
    StdDraw.setPenColor(0, 255, 0);
    StdDraw.setFont(new Font("Arial", Font.BOLD, 60));
    StdDraw.text((float) maxWidth / 2, (float) maxHeight - 0.25, "Gewonnen!");
    StdAudio.play("cheering.wav");
  }

  /**
   * Main
   */
  public static void main(String[] args) {
    StdRandom.setSeed(42);

    if (args.length < 3) {
      System.out.println("Error: Not enough parameters! Usage: width height number_of_mines");
      return;
    }

    int maxWidth = Integer.parseInt(args[0]);
    int maxHeight = Integer.parseInt(args[1]);
    int mines = Integer.parseInt(args[2]);
    if (maxWidth <= 0 || maxHeight <= 0 || mines > maxWidth * maxHeight) {
      System.out.println("Invalid combination! Please change parameters.");
      return;
    }

    // Erzeuge eine Spielfeld-Matrix
    int[][] board = makeRandomBoard(maxWidth, maxHeight, mines);
    // Erzeuge ein Array mit den Dimensionen des Spielfelds zum Merken der aufgedeckten Felder
    int[][] uncovered = new int[maxHeight][maxWidth];
    // Variable zum Merken der Anzahl an aufgedeckten Feldern
    int uncoveredFields = 0;
    
    // Zeichne das zugedeckte Spielfeld
    drawCoveredBoard(board);

    // Spielschleife
    while (true) {
      // Pruefe, ob die Mouse geclickt wurde
      if (StdDraw.mousePressed()) {
        // Ermittle die Position, an der die Mouse geclickt wurde
	int width = (int) StdDraw.mouseX();
	int height = (int) StdDraw.mouseY();
	
	// Pruefe, ob Feld bereits aufgedeckt wurde
        if (uncovered[height][width] == 0) {
	  // Markiere Feld als aufgedeckt
	  uncovered[height][width] = 1;

	  // Pruefe, ob auf aufgedecktem Feld eine Mine platziert wurde
	  if (!isMine(board, width, height)) {
	    // Keine Mine -> schreibe die Anzahl an Minen in der Nachbarschaft in aufgedecktes Feld
            String text = Integer.toString(countMines(board, width, height));
            StdDraw.text(width + 0.5, height + 0.5, text);
            uncoveredFields++;
	  } else {
	    // Mine -> vermittele die Niederlage
            defeat(board, maxWidth, maxHeight);
            break;
	  }

	  // Pruefe, ob alle möglichen Felder aufgedeckt wurden
          if (isWinner(maxWidth, maxHeight, mines, uncoveredFields)) {
            victory(maxWidth, maxHeight);
          }
	}
      }
    }
  }

}
