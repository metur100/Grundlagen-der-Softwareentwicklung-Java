public class MyHashtableTest {

  final static String words[] = { "Bleistift", "Pflanze", "Fussballer", "Regenschirm", "Kartographie",
    "spielen", "Fahrrad", "Strasse", "Weltreise", "Schloss", "fahren", "Stadt", "Kaufhaus", "fliegen",
    "Golf", "Gewitter", "Erholung", "erholen", "Klingel", "Wetterhahn", "Urlaub", "Hund", "einkaufen",
    "Wasser", "schlendern", "Feldweg", "traeumen", "Pizzeria", "Kurierfahrer", "Zoo", "Buch", "Yacht",    
    "Papagei", "reisen", "Baum" };
    

  public static void main(String args[]) {
    MyHashtable hashtable = new MyHashtable();
    
    for (int i = 0; i < words.length; i++) {
      hashtable.put(words[i]);
      System.out.println("Kollisionsrate nach " + (i + 1) + " Wörtern: " + hashtable.getCollisionRate());
    }
    System.out.println();
    System.out.println(hashtable.toString());
  }
}