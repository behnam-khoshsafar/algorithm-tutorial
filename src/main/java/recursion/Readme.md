* When you hear a problem beginning with the following statements, it's often (though not always) a good candidate for
  recursion: "Design an algorithm to compute the nth ..."; "Write code to list the first n ..."; "Implement a method to
  compute all..."; and so on.
* Recursive solutions, by definition, are built off of solutions to subproblems.
* There are many ways you might divide a problem into subproblems. Three of the most common approaches to develop an
  algorithm are bottom-up, top-down, and half-and-half.

# How to Approach?

## Bottom-Up Approach

* The bottom-up approach is often the most intuitive. We start with knowing how to solve the problem for a simple case,
  like a list with only one element. Then we figure out how to solve the problem for two elements, then for three
  elements, and so on. The key here is to think about how you can build the solution for one case off of the previous
  case (or multiple previous cases).

## Top-Down Approach

* In these problems, we think about how we can divide the problem for case N into subproblems.

## Half-and-Half Approach

* it's often effective to divide the data set in half. For example, binary search works with a "half-and-half" approach.

# Recursive vs. Iterative Solutions

* Recursive algorithms can be very space inefficient. Each recursive call adds a new layer to the stack, which means
  that if your algorithm recurses to a depth of n,it uses atleast O(n) memory.

# Dynamic Programming & Memoization

* Dynamic programming is mostly just a matter of taking a recursive algorithm and finding the overlapping subproblems (
  that is, the repeated calls). You then cache those results for future recursive calls.