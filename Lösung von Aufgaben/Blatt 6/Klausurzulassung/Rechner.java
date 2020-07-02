public class Rechner {

  public static void main(String[] args) {
    StdRandom.setSeed(42);
    int num = 13;

    Uebungsblatt[] exercises = new Uebungsblatt[num];
    for (int i = 0; i < num; i++) {
	exercises[i] = new Uebungsblatt(i + 1, 60, StdRandom.uniform(0, 60));
    }

    int pointsToReach = 0;
    int pointsReached = 0;
    for (int i = 0; i < num; i++) {
      pointsToReach += exercises[i].pointsToReach;
      pointsReached += exercises[i].pointsReached;
    }

    System.out.println("Es koennen insgesamt " + pointsToReach + " Punkte erzielt werden.");
    System.out.println("Davon wurden " + pointsReached + " Punkte erreicht.");
    int percentage = (int) ((float) pointsReached / pointsToReach * 100);
    System.out.println("Das entspricht " + percentage + "%.");

    if (percentage > 50) {
      System.out.println("Die Klausurzulassunggrenze wurde erreicht.");
    } else {
      System.out.println("Die Klausurzulassunggrenze wurde nicht erreicht.");
    }
  }

}
