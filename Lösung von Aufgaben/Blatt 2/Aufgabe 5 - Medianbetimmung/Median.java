public class Median {

 
 	public static void main(String[] args) {
    
	int a = 19;
   
 	int b = 5;
   
 	int c = 1;
    
	int median = 0;

   
 	if (a <= b && a >= c) {
   
   		median = a;
  
  	} 
         else if (a >= b && a <= c) {
     
 		median = a;
    
	} 
         else if (b <= a && b >= c) {
     	
	 median = b;
    
	}
         else if (b >= a && b <= c) {
      	
 	median = b;
		
        }
         else if (c <= a && c >= b) {
      
		median = c;
	
	} else if (c >= a && c <= b) {
      	
	median = c;
    
	}

   
 	System.out.print("Der Median ist: ");
    
	System.out.println(median);
 
	}


}
