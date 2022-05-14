###BST sequence
Document= https://medium.com/@jackwootton/binary-search-tree-sequences-53163b1f374a


#39
What is the very first value that must be in each array?

#48
The root is the very first value that must be in every array. What can you say about the order of the values in the left subtree as compared to the values in the right subtree? Do the left subtree values need to be inserted before the right subtree?
#66
The relationship between the left subtree values and the right subtree values is, essen­ tially, anything. The left subtree values could be inserted before the right subtree, or the reverse (right values before left), or any other ordering.
#82
Break this down into subproblems. Use recursion. If you had all possible sequences for the left subtree and the right subtree, how could you create all possible sequences for the entire tree?


###Check Subtree
#4
If T2 is a subtree of Tl, how will its in-order traversal compare to Tl's? What about its pre-order and post-order traversal?
#11
The in-order traversals won't tell us much. After all, every binary search tree with the same values (regardless of structure) will have the same in-order traversal. This is what in-order traversal means: contents are in-order. (And if it won't work in the specific case of a binary search tree, then it certainly won't work for a general binary tree.) The pre­ order traversal, however, is much more indicative.
#18
You may have concluded that if T2.preorderTraversal() is a substring of Tl. preorderTraversal(), then T2 is a subtree of Tl. This is almost true, except that the trees could have duplicate values. Suppose Tl and T2 have all duplicate values but different structures. The pre-order traversals will look the same even though T2 is not a subtree of Tl. How can you handle situations like this?
#31
Although the problem seems like it stems from duplicate values, it's really deeper than that. The issue is that the pre-order traversal is the same only because there are null nodes that we skipped over (because they're null). Consider inserting a placeholder value into the pre-order traversal string whenever you reach a null node. Register the null node as a "real" node so that you can distinguish between the different structures.
#37
Alternatively, we can handle this problem recursively. Given a specific node within Tl, can we check to see if its subtree matches T2?