import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private final boolean[][] grid;
	private int count;
	private final int length;
	private final WeightedQuickUnionUF wquf;
	private final WeightedQuickUnionUF wquf2;

	// creates n-by-n grid, with all sites initially blocked
	public Percolation(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException();
		}
		this.grid = new boolean[n + 1][n + 1];	
		this.wquf = new WeightedQuickUnionUF((n + 1) * n + 2);
		this.wquf2 = new WeightedQuickUnionUF((n + 1) * n + 2);
		this.count = 0;
		this.length = n;
	}

	// opens the site (row, col) if it is not open already
	public void open(int row, int col) {
		if (row <= 0 || row > length || col <= 0 || col > length) {
			throw new IllegalArgumentException();
		}
		if (!grid[row][col]) {
			grid[row][col] = true;
			count++;
			if(row == 1) {
				wquf.union(0, row * length + col);
				wquf2.union(0, row * length + col);
			}
			
			if(row == length) {
				wquf2.union((length + 1) * length  + 1, row * length + col);
			}
			
        	if(col > 1 && grid[row][col - 1]) {
        		wquf.union(row * length + col, row * length + col - 1);
        		wquf2.union(row * length + col, row * length + col - 1);
        	}
        	if(col < length && grid[row][col + 1]) {
        		wquf.union(row * length + col, row * length + col + 1);
        		wquf2.union(row * length + col, row * length + col + 1);
        	} 
        	if(row > 1 && grid[row - 1][col]) {
        		wquf.union((row - 1) * length + col, row * length + col);
        		wquf2.union((row - 1) * length + col, row * length + col);
        	} 
        	if(row < length && grid[row + 1][col]) {
        		wquf.union((row + 1) * length + col, row * length + col);
        		wquf2.union((row + 1) * length + col, row * length + col);
        	}        			
		}
	}

	// is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		if (row <= 0 || row > length || col <= 0 || col > length) {
			throw new IllegalArgumentException();
		}
		return grid[row][col];
	}

	// is the site (row, col) full?
	public boolean isFull(int row, int col) {
		if (row <= 0 || row > length || col <= 0 || col > length) {
			throw new IllegalArgumentException();
		}		
		return wquf.connected(0, row * length + col);
	}


	// returns the number of open sites
	public int numberOfOpenSites() {
		return count;
	}

	// does the system percolate?
	public boolean percolates() {	
		return wquf2.connected(length * (length + 1) + 1, 0);
	}

	// test client (optional)
	public static void main(String[] args) {
		int n = 2;
		Percolation Percolation = new Percolation(n);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				Percolation.open(i, j);
			}
		}
		System.out.println(Percolation.percolates());
	}
}