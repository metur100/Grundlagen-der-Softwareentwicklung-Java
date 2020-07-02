public class Zufallszahl {


	public static void main(String[] args) {
  
  	int n;
    
	int m;
    
	int random;

  
  	n = -5;
    
	m = 12;

    
	random = (int)(Math.random() * (m - n) + 1) + n;

  
 	System.out.print("Zufallszahl: ");
   
 	System.out.println(random);
  
	}

}
