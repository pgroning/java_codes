public class Mastermind {
    public static void main(String[] args) {
	// Prints "Hello, World" in the terminal window.
	System.out.println("Welcome to Mastermind!");
	
	int n = 5;  // Number of positions
	int k = 5;  // Number of colors
	int nc = (int) Math.pow(k, n); // Number of combinations
	
	int[][] matrix = create_matrix(n, k);
	for (int[] rowvec : matrix) {
	    for (int elem : rowvec) {
		System.out.print(elem + " ");
	    }
	    System.out.println();
	}
	System.out.println("------");

	int rnum = (int) (Math.random()*nc);
	int[] guess_row = matrix[rnum];
	for (int c : guess_row) {
	    System.out.print(c + " ");
	}
	System.out.println();

	Combinations comb = new Combinations();
	//comb.create_matrix();
	System.out.println(comb.create_matrix());
	
    }

    public static int[][] create_matrix(int n, int k) {

	int nrows = (int) Math.pow(k, n); //Number of rows

	// Declare a 2D array of integers
	int[][] matrix = new int[nrows][n];
	
	int i = 0;  // First row is a vector with zeros
	for (int j=0; j < n; j++) {
	    matrix[i][j] = 0;
	}
	
	for (i=1; i < nrows; i++) {
	    
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
	
	return matrix;
    }
    
}

class Combinations {

    public String create_matrix() {

	//System.out.println("This creates a matrix");

	String str = "This creates a matrix";

	return str;
	
    }

}
