public class Polynom {

  private int a;
  private int b;
  private int c;
  private int d;

  public Polynom(int d) {
    this(0, 0, 0, d);
  }

  public Polynom(int c, int d) {
    this(0, 0, c, d);
  }

  public Polynom(int b, int c, int d) {
    this(0, b, c, d);
  }

  public Polynom(int a, int b, int c, int d) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }

  public void add(Polynom p) {
    this.a += p.a;
    this.b += p.b;
    this.c += p.c;
    this.d += p.d;
  }
  
  public void substract(Polynom p) {
    this.a -= p.a;
    this.b -= p.b;
    this.c -= p.c;
    this.d -= p.d;
  }

  public int map(int x) {
    int ret = 0;

    if (a != 0) {
      ret += a * Math.pow(x, 3);
    }
    if (b != 0) {
      ret += b * Math.pow(x, 2);
    }
    if (c != 0) {
      ret += c * x;
    }
    ret += d;

    return ret;
  }

  public static Polynom derivation(Polynom p) {
    return new Polynom(p.a * 3, p.b * 2, p.c);
  }

  public String toString() {
    String ret = "";

    if (a != 0) {
      if (a != 1 && a != -1) {
	  ret += a + "*";
      }
      if (a != -1) {
	ret += "x^3";
      } else {
	ret += "-x^3";
      }
    }

    if (b != 0) {
      if (ret.length() > 0) {
	if (b > 0) {
	  ret += " + ";
	} else {
	  ret += " - ";
	}
      }
      if (b != 1 && b != -1) {
	// Die Methode Math.abs(b) gibt den absoluten Wert von b zurueck. Alternativ
	// kann man dies mit einer Bedingung loesen:
	// if (b > 0) ret += b + "*"; else ret += -b + "*";
	ret += Math.abs(b) + "*";
      }
      ret += "x^2";
    }

    if (c != 0) {
      if (ret.length() > 0) {
	if (c > 0) {
	  ret += " + ";
	} else {
	  ret += " - ";
	}
      }
      if (c != 1 && c != -1) {
	ret += Math.abs(c) + "*";
      }
      ret += "x";
    }

    if (d != 0) {
      if (ret.length() > 0) {
	if (d > 0) {
	  ret += " + " + d;
	} else {
	  ret += " - " + -d;
	}
      }
    }
    
    if (ret.length() == 0) {
      ret = "0";
    }

    return ret;
  }

  public static void main(String[] args) {
    Polynom p1 = new Polynom(2, 0, 1, 3);
    Polynom p2 = new Polynom(1, 2, 6, 5);
    Polynom p3 = new Polynom(3, 3, 0, 3);
    Polynom p4 = new Polynom(6, 4, 10, 5);
    Polynom p5 = new Polynom(8, 9, 6, 0);
    Polynom p6 = new Polynom(0, 2, 5, 8);
    Polynom p7 = new Polynom(6, 5, 4, 9);
    Polynom p8 = new Polynom(5, 7, 0, 1);

    assertEquals("2*x^3 + x + 3", p1.toString(), "toString");
    assertEquals("x^3 + 2*x^2 + 6*x + 5", p2.toString(), "toString");
    assertEquals("3*x^3 + 3*x^2 + 3", p3.toString(), "toString");
    assertEquals("6*x^3 + 4*x^2 + 10*x + 5", p4.toString(), "toString");
    assertEquals("8*x^3 + 9*x^2 + 6*x", p5.toString(), "toString");
    assertEquals("2*x^2 + 5*x + 8", p6.toString(), "toString");
    assertEquals("6*x^3 + 5*x^2 + 4*x + 9", p7.toString(), "toString");
    assertEquals("5*x^3 + 7*x^2 + 1", p8.toString(), "toString");
    
    assertEquals(21, p1.map(2), "map");
    assertEquals(329, p2.map(6), "map");
    assertEquals(2433, p3.map(9), "map");
    assertEquals(25, p4.map(1), "map");
    assertEquals(0, p5.map(0), "map");
    assertEquals(26, p6.map(2), "map");
    assertEquals(24, p7.map(1), "map");
    assertEquals(433, p8.map(4), "map");
    
    assertEquals("6*x^2 + 1", Polynom.derivation(p1).toString(), "derivation");
    assertEquals("3*x^2 + 4*x + 6", Polynom.derivation(p2).toString(), "derivation");
    assertEquals("9*x^2 + 6*x", Polynom.derivation(p3).toString(), "derivation");
    assertEquals("18*x^2 + 8*x + 10", Polynom.derivation(p4).toString(), "derivation");
    assertEquals("24*x^2 + 18*x + 6", Polynom.derivation(p5).toString(), "derivation");
    assertEquals("4*x + 5", Polynom.derivation(p6).toString(), "derivation");
    assertEquals("18*x^2 + 10*x + 4", Polynom.derivation(p7).toString(), "derivation");
    assertEquals("15*x^2 + 14*x", Polynom.derivation(p8).toString(), "derivation");
    
    p6.add(p5);
    assertEquals("8*x^3 + 11*x^2 + 11*x + 8", p6.toString(), "add");
    p2.add(p7);
    assertEquals("7*x^3 + 7*x^2 + 10*x + 14", p2.toString(), "add");
    p3.add(p4);
    assertEquals("9*x^3 + 7*x^2 + 10*x + 8", p3.toString(), "add");
    p5.add(p1);
    assertEquals("10*x^3 + 9*x^2 + 7*x + 3", p5.toString(), "add");
    
    p7.substract(p2);
    assertEquals("-x^3 - 2*x^2 - 6*x - 5", p7.toString(), "substract");
    p3.substract(p5);
    assertEquals("-x^3 - 2*x^2 + 3*x + 5", p3.toString(), "substract");
    p1.substract(p6);
    assertEquals("-6*x^3 - 11*x^2 - 10*x - 5", p1.toString(), "substract");
    p4.substract(p8);
    assertEquals("x^3 - 3*x^2 + 10*x + 4", p4.toString(), "substract");
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

}
