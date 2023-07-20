/**
 * ****************************************************************************
 * Name:              Aspen Morgan
 * Last modified:     January 27, 2023
 * ***************************************************************************
 */
// rRow * N + rCol + 1

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int n;
    private boolean[][] array;
    private int counter = 0;
    private WeightedQuickUnionUF id;

    public Percolation(int N) {

        // Handle N <= 0 case
        if (N <= 0) {
            throw new IndexOutOfBoundsException("N must be a positive integer.");
        }

        // Match global variable to the given N
        this.n = N;

        // create N-by-N grid, with all sites initially blocked
        // and create instance of WeightedQuickUnionUF object
        this.array = new boolean[this.n][this.n];
        this.id = new WeightedQuickUnionUF(this.n * this.n + 2);
    }

    public void open(int row, int col) {
        // Handle exceptions
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException("Column or row out of range.");
        }

        // open the site (row, col) if it is not open already
        if (!this.array[row][col]) {
            this.array[row][col] = true;
            this.counter++;
        }

        // connect to top node if row = 0
        if (row == 0) {
            id.union(col + 1, 0);
        }

        // connect to bottom node if row = n - 1
        if (row == this.n - 1) {
            id.union(row * this.n + col + 1, this.n * this.n + 2);
        }

        // connect to adjacent open sites
        if (col - 1 >= 0 && this.array[row][col - 1]) {
            // update the id values
            id.union(row * this.n + (col + 1), row * this.n + col);

        }
        if (row - 1 >= 0 && this.array[row - 1][col]) {
            // update the id values
            id.union(row * this.n + (col + 1), (row - 1) * this.n + (col + 1));
        }
        if (row + 1 < this.n && this.array[row + 1][col]) {
            // update the id values
            id.union(row * this.n + (col + 1), (row + 1) * this.n + (col + 1));
        }
        if (col + 1 < this.n && this.array[row][col + 1]) {
            // update the id values
            id.union(row * this.n + (col + 1), row * this.n + (col + 2));
        }

    }

    public boolean isOpen(int row, int col) {
        // Handle exceptions
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException("Column or row out of range.");
        }

        if (this.array[row][col]) return true;
        return false;
    }

    public boolean isFull(int row, int col) {
        // Handle exceptions
        if (row < 0 || col < 0) {
            throw new IndexOutOfBoundsException("Column or row out of range.");
        }

        // is the site (row, col) full? (Connected to top of grid)
        if (id.connected(row * this.n + col + 1, 0)) return true;
        return false;


    }

    public int numberOfOpenSites() {
        // number of open sites
        return this.counter;
    }

    public boolean percolates() {
        if (this.id.connected(0, this.n * this.n + 2)) return true;
        return false;
    }

    public static void main(String[] args) {

        // unit testing
        int testN = 4;
        Percolation test = new Percolation(testN);
        test.open(0, 0);
        test.open(0, 1);
        test.open(1, 1);
        test.open(2, 1);
        test.open(3, 1);
        StdOut.println(test.isFull(2, 1));
        StdOut.println(test.numberOfOpenSites());
        StdOut.println(test.percolates());

    }
}
