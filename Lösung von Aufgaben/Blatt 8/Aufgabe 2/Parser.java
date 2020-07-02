public class Parser {

  public static int parseInt(String str) {
    int ret = 0;
    boolean isNegative = false;

    for (int i = 0; i < str.length(); i++) {
      int c = (int) str.charAt(i);

      if (c == 45 && i == 0) {
		isNegative = true;
		continue;
      }

      if (c < 48 || c > 57) {
		System.out.println("String is not a number.");
		return -1;
      }

      ret += (c - 48) * Math.pow(10, str.length() - i - 1);
    }

    if (isNegative) {
      ret *= -1;
    }

    return ret;
  }

  public static void main(String[] args) {

    int res = parseInt("345");
    System.out.println("Read value: " + res);
    res = parseInt("123456789");
    System.out.println("Read value: " + res);
    res = parseInt("-345");
    System.out.println("Read value: " + res);
    res = parseInt("-123456789");
    System.out.println("Read value: " + res);
    res = parseInt("3-45");
    System.out.println("Read value: " + res);
    res = parseInt("345-");
    System.out.println("Read value: " + res);
    res = parseInt("a345");
    System.out.println("Read value: " + res);
    res = parseInt("3a45");
    System.out.println("Read value: " + res);
    res = parseInt("345a");
    System.out.println("Read value: " + res);
  }
}

