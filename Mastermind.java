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
	int[] matchvec = cobj.get_matchvec(matrix.length-1);
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
	//int[] guess_vec = this.random_row;
        int[] guess_vec = {0,1,1,4,3};
	//int[] combvec = this.matrix[row];
	int[] combvec = {0,3,3,3,3};
	int k = 0;
	for (int i = 0; i < this.n; i++) {
	    if (combvec[i] == guess_vec[i]) {
		combvec[i] = -1;
		guess_vec[i] = -2;
		this.matchvec[k] = 2;
		k++;
	    }
	}
        
	for (int i = 0; i < this.n; i++) {
	    for (int j = 0; j < this.n; j++) {
		if (combvec[i] == guess_vec[j] && i != j) {
		    combvec[i] = -1;
		    guess_vec[j] = -2;
		    this.matchvec[k] = 1;
		    k++;
                    break;
		}
	    }
	}
	
	return this.matchvec;
    }
    
}
