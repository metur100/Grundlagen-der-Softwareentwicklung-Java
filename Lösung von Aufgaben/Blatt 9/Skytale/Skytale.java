public class Skytale {

  private int n;
  private int m;

  public Skytale() {
    n = 4;
    m = 7;
  }

  public Skytale(int n, int m) {
    this.n = n;
    this.m = m;
  }

  public String encrypt(String klartext) {
    String geheimtext = "";
    char[][] buchstaben = new char[n][m];
    int pos = 0;

    // Fill char-array line by line
    for (int i = 0;i < n;i++) {
      for (int j = 0;j <m;j++) {
	buchstaben[i][j] = klartext.charAt(pos++);
      }
    }

    // Read from char-array column by column
    for (int j= 0;j < m;j++) {
      for (int i = 0;i < n;i++) {
	geheimtext += buchstaben[i][j];
      }	
    }

    return geheimtext;
  }

  public String decrypt(String geheimtext) {
    String klartext = "";
    char[][] buchstaben = new char[n][m];
    int pos = 0;

    // Fill char-array column by column
    for (int j= 0;j < m;j++) {
      for (int i = 0;i < n;i++) {
	buchstaben[i][j] = geheimtext.charAt(pos++);
      }
    }

    // Read from char-array line by line
    for (int i = 0;i < n;i++) {
      for (int j = 0;j <m;j++) {
	klartext += buchstaben[i][j];
      }	
    }

    return klartext;
  }

}
