public class MyHashtable {
  final static int size = 67;
  String values[] = new String[size];
  int numberOfValues = 0;
  int numberOfCollisions = 0;
  
  private static int hash(String str) {
    char word[] = new String(str).toCharArray();
    int hash = 0;

    for (int i = 0; i < word.length; i++) {
      hash = (((hash << 8) + (int) word[i]) % size);
    }
    return hash;
  }
  
  public void put(String value) {
    int hash = hash(value);
  
    while (values[hash] != null) {
      numberOfCollisions++;
      hash = (hash + 1) % size;
    }
    values[hash] = value;
    numberOfValues++;
  }
  
  public float getCollisionRate() {
    return (float)numberOfCollisions / numberOfValues;
  }
  
  public String toString() {
    String ret = "MyHashtable:\nFüllgrad: " + ((float)numberOfValues / size) + "(" + numberOfValues + " Werte)"
      + ", Kollisionsrate: " + ((float)numberOfCollisions / numberOfValues)
      + "\n\n";
      
    ret += "  key:value\n";
    for (int i = 0; i < size; i++) {
      if (values[i] != null) {
	ret += "  " + i + ":" + values[i] + "\n";
      }
    }
    return ret;
  }
}
