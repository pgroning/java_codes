public class Mastermind {
   public static void main(String[] args) {
      // Prints "Hello, World" in the terminal window.
      System.out.println("Hello, World");

      int n = 5;  // Number of positions
      int k = 5;  // Number of colors

      int nc = (int) Math.pow(k, n);  // Number of combinations
      System.out.println(nc);
      
      // Declare a 2D array of integers
      int[][] matrix = new int[nc][n];

      int i = 0;  // First combination
      for (int j=0; j < n; j++) {
	  matrix[i][j] = 0;
      }

      for (i=1; i < nc; i++) {

	  for (int j=0; j < n; j++) {
	      matrix[i][j] = matrix[i-1][j];  // copy previous combination
	  }
	  
	  for (int j=0; j < n; j++) {    
	      if (matrix[i][j] < k-1) {
		  matrix[i][j]++;
		  break;
	      }
	      else {
		  matrix[i][j] = 0;
	      }
	  }
	  
      }

      for (int[] rowvec : matrix) {
	  for (int elem : rowvec) {
	      System.out.print(elem + " ");
	  }
	  System.out.println();
      }
      
   }
}
