/******************************************************************************
 *  Name: Aspen Morgan
 * 
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates? This should be something like 3-5 sentences.
 *****************************************************************************/

  I implemented Percolation.java by mapping a two-dimensional array (the grid)
  to a WeightedQU/QU object (named id). The id array had a couple extra elements
  to signify the top and bottom of the area being modeled. The grid array held 
  boolean values so that it could communicate if a site is open or not. The id
  array held integer values, and as soon as a node was opened on the grid, 
  the open(row, col) function would connect the corresponding id nodes if any
  adjacent sites were opened. Because of the extra two elements in id, 
  I used row * N + col + 1 to map between id and the grid. The system percolated 
  if the top node was connected to the bottom node in id.

/******************************************************************************
 *  Perform computational experiments to estimate the running time of
 *  PercolationStats.java for values values of n and T when implementing
 *  Percolation.java with QuickFindUF.java.
 *
 *  To do so, fill in the two tables below. Each table must have at least
 *  4 data points, ranging in time from around 0.1 seconds to at most a few
 *  minutes. Do not include data points that takes less than 0.1 seconds.
 *  Each data point should be double the size of the preceding data point
 *****************************************************************************/

(keep T constant; n doubles)

 n          time (seconds)
------------------------------
100		0.238
200		1.041
400		7.365
800		45.668



(keep n constant; T doubles)

 T          time (seconds)
------------------------------
100		0.238
200		0.471
400		0.785
800		1.786


/******************************************************************************
 *  Using the empirical data from the above two tables, give an estimate
 *  of the running time of PercolationStats.java as function of both n and 
 *  T, using asymptotic notation, like:
 *
 *       O( n^5.0 * T^1.5 )
 *
 *  Recall that with asymptotic notation, you are interested in the
 *  growth rate of run time as input sizes grow - you drop lower-order
 *  terms and constant factors. In class, we've discussed a way to 
 *  estimate polynomial factors from empirical run times.
 *
 *  How does this estimate compare to the theoretical run time growth
 *  rate, according to analysis of your code?
 *
 *****************************************************************************/

 Using (t2/t1)=2^b and taking the average of the 3b's:

 O( n^2.5 * T^1.0 )

 It makes sense that the array size (n) is associated with quadratic time. 
 PercolationStats creates a Percolation object, which has a quadratic runtime
 in its constructor. It also makes sense that T (number of trials) is associated
 with linear time since the trials are created using a single for loop.


/******************************************************************************
 *  Repeat the previous three questions, but using WeightedQuickUnionUF
 *  (instead of QuickFindUF).
 *****************************************************************************/

(keep T constant; n doubles)

 n          time (seconds)
------------------------------
100		0.176
200		0.442
400		1.895
800		8.754



(keep n constant; T doubles)

 T          time (seconds)
------------------------------
100		0.176
200		0.281
400		0.526
800		0.882



Run time estimate:

O( n^1.9 * T^0.9 )

It makes sense that the weighted quick union implementation is faster, but 
still quadratic when it comes to n. There is still a nested for loop to 
create a 2d grid. 



 
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/

The Percolation class is unfortunately marking sites that only connect to the 
bottom as full if the system percolates. 


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, TA,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
 
  Lindsey gave me a hint on mapping between the grid (named array in my implementation) 
  and the QuickUnion array (named id in my code). She helped me cut out unnecessary
  grid accesses. 

  I also discussed the PercolationStats class with Jayce Holdsambeck. We bounced 
  ideas off of each other.


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
I've had some issues trying to fix the logic for marking nodes connected to the 
bottom as (not) full if the system percolates. 



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed (or hated) doing it.                                             
 *****************************************************************************/

