/******************************************************************************
   Compilation:  javac Minesweeper1.java
   Execution:    java Minesweeper1

   Eingabe: -
   Ausgabe: Ausgaben der Testfaelle aus der main-Methode

   Sie duerfen keine Funktionen aus StdRandom aufrufen, sonst schlagen die Tests
   fehl!


  Sie muessen vier Methoden implementieren:
    makeRandomBoard(s,z,n) - Bekommt drei Parameter: Spalten s, Zeilen z und
                             die Anzahl von Minen n. Erzeugt ein Spielfeld mit
                             z Zeilen und s Spalten und positioniert die Minen.
                             Die Position der Minen bekommen Sie durch Aufruf
                             der vorgegebenen Methode selectRandomPosition.
                             Rufen Sie n mal selectRandomPosition auf und
                             positionieren Sie die Minen entsprechend.

    isMine - Bekommt drei Parameter: Ein Spielfeld und Spalte und Zeile. Gibt
	     true zurueck, wenn sich auf der Position eine Mine befindet,
	     ansonsten gibt die Methode false zurueck.

    countMines - Bekommt drei Parameter: Ein Spielfeld und Spalte und Zeile. Gibt
                 die Anzahl der Minen auf den Nachbarfeldern zurück.

    boardToString - Bekommt das Spielfeld als Parameter uebergeben und gibt eine
                   String-Darstellung des Feldes zurueck. Felder mit einer Mine
                   werden durch ein *, Felder ohne Mine durch eine 0 dargestellt.
                   Stellen Sie das Spielfeld zweidimensional dar.

  Beachten Sie, dass zweidimensionale Arrays zeilenweise im Speicher liegen und
  somit erst die Zeile und dann die Spalte angegeben werden muss, wohingegen in
  Koordinatensystemen erst die Breite/Spalte und dann die Hoehe/Zeile angegeben
  wird.

 ******************************************************************************/

public class Minesweeper1 {

  // Implementieren Sie ihre Loesung hier

  /**
   * Erzeugt eine Spielfeld-Matrix mit "zufaelliger" Positionierung der Minen
   */
  public static int[][] makeRandomBoard(int maxWidth, int maxHeight, int mines) {
    // Erzeuge das zweidimensionale Array für die Spielfeld-Matrix
    int[][] board = new int[maxHeight][maxWidth];

    // Setze n Minen
    for (int i = 0; i < mines; i++) {
      // Bestimme "zufaellige" Position fuer die Mine
      int[] pos = selectRandomPosition(maxWidth, maxHeight);
      // Setze Mine, prueft nicht, ob sich dort schon eine Mine befindet
      // -> Minenanzahl <= n
      board[pos[0]][pos[1]] = 1;
    }
    return board;
  }

  /**
   * Ermitteln, ob sich auf dem Feld eine Mine befindet
   */
  public static boolean isMine(int[][] board, int width, int height) {
    return board[height][width] == 1;
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
   * Schreibt die Spielfeld-Matrix in einen String
   */
  public static String boardToString(int[][] board) {
    // Ermittele die Dimensionen der Spielfeld-Matrix
    int maxHeight = board.length;
    int maxWidth = board[0].length;

    String output = "";
    // Iteriere ueber alle Zeilen
    for (int i = 0; i < maxHeight; i++) {
      // Iteriere fuer jede Zeile i ueber alle Spalten
      for (int j = 0; j < maxWidth; j++) {
	// Schreibe eine "0" fuer ein freies Feld, "*" fuer eine Mine
        output += isMine(board, j, i) ? "*" : "0";
      }
      output += System.lineSeparator();
    }
    return output;
  }

  //


  // ####  Ab hier nichts mehr aendern !!!


  /**
   * Gibt eine "zufaellige" Position innerhalb der Spielfeld-Matrix zurueck
   * Rufen Sie diese Methode in ihrer makeRandomBoard Methode auf
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
   * Testfaelle fuer ihre Methoden
   */
  public static void main(String[] args) {
    StdRandom.setSeed(42);

    /* 1. Spielfeld */
    // Erzeuge eine Spielfeld-Matrix mit den Dimensionen 6 (Breite) und 10 (Hoehe) und 15 Minen
    int[][] board = makeRandomBoard(6, 10, 15);

    // Ueberpruefe erzeugte Spielfeld-Matrix und die Methode boardToString
    assertEquals("0*0**0" + System.lineSeparator() +
                 "000000" + System.lineSeparator() +
                 "00*000" + System.lineSeparator() +
                 "000*0*" + System.lineSeparator() +
                 "000000" + System.lineSeparator() +
                 "00*000" + System.lineSeparator() +
                 "*0**00" + System.lineSeparator() +
                 "*00000" + System.lineSeparator() +
                 "00*000" + System.lineSeparator() +
                 "00000*" + System.lineSeparator(), boardToString(board), "boardToString - first Board");
    // Ueberpruefe die Methoden isMine und countMines
    assertEquals(1, countMines(board, 1, 3), "countMines(board, 1, 3)");
    assertTrue(!isMine(board, 1, 3), "!isMine(board, 1, 3)");
    assertEquals(1, countMines(board, 0, 0), "countMines(board, 0, 0)");
    assertTrue(isMine(board, 2, 2), "isMine(board, 2, 2)");

    /* 2. Spielfeld */
    // Erzeuge eine Spielfeld-Matrix mit den Dimensionen 8 x 8 (Breite und Hoehe) und 32 Minen
    board = makeRandomBoard(8, 8, 32);

    // Ueberpruefe erzeugte Spielfeld-Matrix
    assertEquals("00*00000" + System.lineSeparator() +
                 "***00000" + System.lineSeparator() +
                 "0*0*0*00" + System.lineSeparator() +
                 "0000****" + System.lineSeparator() +
                 "*0*00000" + System.lineSeparator() +
                 "000**000" + System.lineSeparator() +
                 "***00**0" + System.lineSeparator() +
                 "*000*000" + System.lineSeparator(), boardToString(board), "boardToString - second Board");
    // Ueberpruefe die Methoden isMine und countMines
    assertEquals(4, countMines(board, 2, 5), "countMines(board, 2, 5)");
    assertTrue(isMine(board, 2, 4), "isMine(board, 2, 4)");
    assertEquals(4, countMines(board, 2, 5), "countMines(board, 2, 5)");
    assertTrue(!isMine(board, 2, 5), "!isMine(board, 2, 5)");
    assertEquals(3, countMines(board, 5, 5), "countMines(board, 5, 5)");
    assertTrue(!isMine(board, 5, 5), "!isMine(board, 5, 5)");
  }

  // Ab hier folgen Hilfsfunktionen fuer die Test in der main-Methode

  /**
   * Prueft, ob die zu testende Methode den richtigen Wert zurueckgibt
   * Vergleicht ints
   */
  public static void assertEquals(int expected, int actual, String method) {
    System.out.print("Testing " + method + " ");
    if (expected != actual) {
      System.out.println("failed. Expected " + expected + " but got " + actual + ".");
    } else {
      System.out.println("succeeded.");
    }
  }

  /**
   * Prueft, ob die zu testende Methode den richtigen Wert zurueckgibt
   * Vergleicht Strings
   */
  public static void assertEquals(String expected, String actual, String method) {
    System.out.print("Testing " + method + " ");
    if (expected == null || !expected.equals(actual)) {
      System.out.println("failed.");
      System.out.println("## Expected:");
      System.out.println(expected);
      System.out.println("## Actual:");
      System.out.println(actual);
      if (expected.length() != actual.length()) {
	System.out.println("Length of the Strings differ. Expected "+ expected.length()+" but got "+actual.length());
      } else {
        System.out.println("Length are ok.");
        for (int i = 0; i < expected.length(); i++) {
          if (expected.charAt(i) != actual.charAt(i)) {
            System.out.println("Difference at position " + i + " expected " + expected.charAt(i) + " but got " + actual.charAt(i));
          }
        }
      }
    }
    else System.out.println("succeeded.");
  }

  /**
   * Prueft, ob die zu testende Methode den richtigen Wert zurueckgibt
   * Vergleicht booleans
   */
  public static void assertTrue(boolean actual, String method) {
    System.out.print("Testing " + method + " ");
    if (!actual) {
      System.out.println("failed. Expected true but was false.");
    } else {
      System.out.println("succeeded.");
    }
  }


}
