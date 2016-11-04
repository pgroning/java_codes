public class Mastermind {
    public static void main(String[] args) {

	System.out.println("Welcome to Mastermind!");
	
	int n = 5;  // Number of positions
	int k = 5;  // Number of colors
	int nc = (int) Math.pow(k, n); // Number of combinations
	
	Combinations cobj = new Combinations(n, k);
	int[][] matrix = cobj.create_matrix();

	for (int[] rowvec : matrix) {
	    for (int elem : rowvec) {
		System.out.print(elem + " ");
	    }
	    System.out.println();
	}
	System.out.println("------");

	int[] random_row = cobj.draw_row();
	for (int c : random_row) {
	    System.out.print(c + " ");
	}
	System.out.println();
    }
}


class Combinations {
    
    int n, k;
    int number_of_rows;
    int[][] matrix;
    int[] random_row;
    
    public Combinations(int n, int k) { // Class constructor
	this.n = n;
	this.k = k;
    }
    
    public int[][] create_matrix() {
	
	this.number_of_rows = (int) Math.pow(k, n);
	
	// Declare a 2D array of integers
	int[][] matrix = new int[this.number_of_rows][n];
	
	int i = 0;  // First row is a vector with zeros
	for (int j=0; j < n; j++) {
	    matrix[i][j] = 0;
	}
	
	for (i=1; i < number_of_rows; i++) {
	    
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

	this.matrix = matrix;
	return this.matrix;
	
    }

    public int[] draw_row() {
	int random_number = (int) (Math.random()*this.number_of_rows);

	this.random_row = matrix[random_number];
	return this.random_row;
    }
    
}
