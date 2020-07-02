public class NEck {

  public static void main(String[] args) {
    int N;
    Turtle t = new Turtle();

    // Schildkroete positionieren
    t.up();
    t.forward(20);
    t.left(90);
    t.forward(30);
    t.right(90);
    t.down();

    // Dreieck zeichnen
    N = 3;
    for (int n = 0;n < N;n++) {
      t.forward(10);
      t.right(360 / N);
    }

    // Schildkroete positionieren
    t.up();
    t.right(90);
    t.forward(50);
    t.left(90);
    t.down();

    // Viereck zeichnen
    N = 4;
    for (int n = 0;n < N;n++) {
      t.forward(10);
      t.right(360 / N);
    }

    // Schildkroete positionieren
    t.up();
    t.backward(50);
    t.down();

    // Achteck zeichnen
    N = 8;
    for (int n = 0;n < N;n++) {
      t.forward(10);
      t.right(360 / N);
    }

    // Schildkroete positionieren
    t.up();
    t.left(90);
    t.forward(50);
    t.right(90);
    t.down();

    // Zehneck zeichnen
    N = 10;
    for (int n = 0;n < N;n++) {
      t.forward(10);
      t.right(360 / N);
    }
  }

}