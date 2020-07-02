public class Resistor implements Net {

  private final double ohm;

  public Resistor(double ohm) {
    this.ohm = ohm;
  }

  public double ohm() {
    return ohm;
  }

  public int resistorCount() {
    return 1;
  }

}
