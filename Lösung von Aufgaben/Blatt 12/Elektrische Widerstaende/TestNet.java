public class TestNet {

  public static void main(String[] args) {
    Net net_1 = new Resistor(100);
    Net net_2 = new Resistor(200);
    Net net_3 = new Resistor(300);
    Net net_4 = new Resistor(400);
    Net net_5 = new Resistor(500);
    Net net_6 = new Resistor(600);
    Net net_7 = new Resistor(700);

    Net net_23 = new Parallel(net_2, net_3);
    Net net_123 = new Serial(net_1, net_23);
    Net net_45 = new Parallel(net_4, net_5);
    Net net_456 = new Serial(net_45, net_6);
    Net net_123456 = new Parallel(net_123, net_456);
    Net net_1234567 = new Serial(net_123456, net_7);

    System.out.println("Ohm: " + net_1234567.ohm());
    System.out.println("Resistors: " + net_1234567.resistorCount());
  }

}
