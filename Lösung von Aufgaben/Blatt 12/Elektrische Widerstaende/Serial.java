public class Serial implements Net {

  private Net first;
  private Net second;

  public Serial(Net first, Net second) {
    this.first = first;
    this.second = second;
  }

  public double ohm() {
    return first.ohm() + second.ohm();
  }

  public int resistorCount() {
    return first.resistorCount() + second.resistorCount();
  }

}
