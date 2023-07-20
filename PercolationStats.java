/* *****************************************************************************
 *  Name:              Aspen Morgan
 *  Last modified:     February 9, 2023
 **************************************************************************** */


public class PercolationStats {
    private int t;
    private int n;
    private double[] xValues;

    public PercolationStats(int N, int T) {
        // perform T independent experiments on an N-by-N grid
        this.t = T;
        this.n = N;
        this.xValues = new double[this.t];

        for (int i = 0; i < this.t; i++) {

            Percolation perco = new Percolation(this.n);

            while (!perco.percolates()) {
                perco.open((int) Math.round((this.n - 1) * StdRandom.uniform()),
                           (int) Math.round((this.n - 1) * StdRandom.uniform()));
            }

            this.xValues[i] = ((double) perco.numberOfOpenSites()) / (this.n * this.n);
        }
    }

    public double mean() {
        // sample mean of percolation threshold
        return StdStats.mean(this.xValues);
    }

    public double stddev() {
        // sample standard deviation of percolation threshold
        return StdStats.stddev(this.xValues);
    }

    public double confidenceLow() {
        // low  endpoint of 95% confidence interval
        return StdStats.mean(this.xValues) - ((1.96 * StdStats.stddev(this.xValues)) / Math.sqrt(
                this.t));
    }

    public double confidenceHigh() {
        // high endpoint of 95% confidence interval
        return StdStats.mean(this.xValues) + ((1.96 * StdStats.stddev(this.xValues)) / Math.sqrt(
                this.t));
    }

    public static void main(String[] args) {
        // Not required for the API, but useful to test if
        // your code is doing reasonable things
        Stopwatch clock = new Stopwatch();
        PercolationStats st = new PercolationStats(100, 100);
        StdOut.println("Mean: " + st.mean());
        StdOut.println("Standard Deviation: " + st.stddev());
        StdOut.println("Confidence Lower Bound: " + st.confidenceLow());
        StdOut.println("Confidence Upper Bound: " + st.confidenceHigh());
        StdOut.println(clock.elapsedTime());
    }
}
