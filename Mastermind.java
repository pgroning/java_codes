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

	boolean[] boolvec = cobj.create_boolvec();
	//for (boolean r : boolvec) {
	//    System.out.println(r);
	//}
	int[] matchvec = cobj.get_matchvec(0);
	for (int e : matchvec) {
	    System.out.println(e);
	}
	
    }
}


class Combinations {
    
    int n, k;
    int number_of_rows;
    int[][] matrix;
    int[] random_row, matchvec;
    boolean[] boolvec;
    
    public Combinations(int n, int k) { // Class constructor
	this.n = n;
	this.k = k;
	this.matchvec = new int[n];
    }
    
    public int[][] create_matrix() {
	
	this.number_of_rows = (int) Math.pow(k, n);
	
	// Declare a 2D array of integers
	this.matrix = new int[this.number_of_rows][n];
	
	int i = 0;  // First row is a vector with zeros
	for (int j=0; j < n; j++) {
	    this.matrix[i][j] = 0;
	}
	
	for (i=1; i < number_of_rows; i++) {
	    
	    for (int j=0; j < n; j++) { // copy previous combination
		this.matrix[i][j] = this.matrix[i-1][j];
	    }
	    
	    for (int j=0; j < n; j++) {    
		if (this.matrix[i][j] < k-1) {
		    this.matrix[i][j]++;
		    break;
		}
		else {
		    this.matrix[i][j] = 0;
		}
	    }
	    
	}

	return this.matrix;
	
    }

    public boolean[] create_boolvec() {
	// Declare a 1D array of booleans
	this.boolvec = new boolean[this.number_of_rows];
	for (int i = 0; i < this.number_of_rows; i++) {
	    this.boolvec[i] = true;
	}
	return this.boolvec;
    }
    
    public int[] draw_row() {
	int random_number = (int) (Math.random()*this.number_of_rows);
	this.random_row = matrix[random_number];
	return this.random_row;
    }

    public int[] get_matchvec(int row) {
	int[] rvec = this.random_row;
	int[] combvec = this.matrix[row];

	int j = 0;
	for (int i = 0; i < this.n; i++) {
	    if (combvec[i] == rvec[i]) {
		this.matchvec[j] = 2;
		j++;
	    }
	}
	return this.matchvec;
    }
    
}
