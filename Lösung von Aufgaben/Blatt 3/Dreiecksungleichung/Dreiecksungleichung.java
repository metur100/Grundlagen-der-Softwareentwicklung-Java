/******************************************************************************
 *  Compilation:  javac Dreiecksungleichung.java
 *  Execution:    java Dreiecksungleichung a b c
 *
 *  Eingabe: drei positive Integer a,b und c
 *  Ausgabe: true genau dann, wenn einer der Werte echt groesser ist als die Summe der beiden anderen Werte
 *
 *  Anmerkung: Gehen Sie ausnahmsweise davon aus, dass ihr Programm immer korrekt aufgerufen wird.
 *
 *  Referenz: https://de.wikipedia.org/wiki/Dreiecksungleichung
 * 
******************************************************************************/

public class Dreiecksungleichung {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        boolean resultat = a > b + c || b > a + c || c > a + b;
        System.out.println(resultat);
    }
}

