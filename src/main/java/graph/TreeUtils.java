package graph;

import graph.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class TreeUtils {

    public static <E> TreeNode<E> createMinimalBST(E[] items) {
        if (items == null)
            return null;
        if (items.length == 1)
            return new TreeNode<>(items[0]);
        return createMinimalBST(items, 0, items.length - 1);
    }

    private static <E> TreeNode<E> createMinimalBST(E[] items, int left, int right) {
        if (right < left)
            return null;
        int midIndex = (right + left) / 2;
        E item = items[midIndex];
        TreeNode<E> node = new TreeNode<>(item);
        node.setLeft(createMinimalBST(items, left, midIndex - 1));
        node.setRight(createMinimalBST(items, midIndex + 1, right));
        return node;
    }

    public static <E> List<LinkedList<TreeNode<E>>> createLevelLinkedList(TreeNode<E> root) {
        if (root == null)
            return Collections.emptyList();
        List<LinkedList<TreeNode<E>>> result = new LinkedList<>();
        createLevelLinkedList(root, result, 0);
        return result;
    }

    private static <E> void createLevelLinkedList(TreeNode<E> root, List<LinkedList<TreeNode<E>>> result, int level) {
        if (root == null)
            return;
        LinkedList<TreeNode<E>> nodes;
        if (result.size() == level) {
            nodes = new LinkedList<>();
            result.add(nodes);
        } else {
            nodes = result.get(level);
        }
        nodes.add(root);
        createLevelLinkedList(root.getLeft(), result, level + 1);
        createLevelLinkedList(root.getRight(), result, level + 1);
    }


    public static <E> boolean isBalanced(TreeNode<E> root) {
        if (root == null)
            return false;
        return getHeights(root) != MIN_VALUE;
    }

    private static <E> int getHeights(TreeNode<E> root) {
        if (root == null) return -1;

        int leftHeights = getHeights(root.getLeft());
        if (leftHeights == MIN_VALUE)
            return MIN_VALUE;

        int rightHeights = getHeights(root.getRight());
        if (rightHeights == MIN_VALUE)
            return MIN_VALUE;


        if (Math.abs(leftHeights - rightHeights) > 1)
            return MIN_VALUE;
        else
            return Math.max(leftHeights, rightHeights) + 1;
    }

    public static <E extends Comparable<E>> boolean isValidBST(TreeNode<E> root) {
        return isValidBST(root, null, null);
    }

    private static <E extends Comparable<E>> boolean isValidBST(TreeNode<E> root, E min, E max) {
        if (root == null)
            return true;
        if (min != null && root.getValue().compareTo(min) <= 0 || max != null && root.getValue().compareTo(max) >= 0)
            return false;
        return isValidBST(root.getLeft(), min, root.getValue()) && isValidBST(root.getRight(), root.getValue(), max);
    }

    public static <E> TreeNode<E> findFirstCommonAncestor(TreeNode<E> q, TreeNode<E> p) {
        int delta = depth(q) - depth(p);
        TreeNode<E> shallowerNode = delta > 0 ? p : q;
        TreeNode<E> deeperNode = delta > 0 ? q : p;
        deeperNode = goUpBy(deeperNode, delta);

        while (shallowerNode != null && deeperNode != null && !shallowerNode.equals(deeperNode)) {
            shallowerNode = shallowerNode.getParent();
            deeperNode = deeperNode.getParent();
        }
        return shallowerNode != null && deeperNode != null ? shallowerNode : null;
    }

    private static <E> TreeNode<E> goUpBy(TreeNode<E> node, int delta) {
        while (delta > 0 && node != null) {
            node = node.getParent();
            delta--;
        }
        return node;
    }

    private static <E> int depth(TreeNode<E> node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.getParent();
        }
        return depth;
    }

    public static <E> ArrayList<LinkedList<E>> allSequence(TreeNode<E> node) {
        ArrayList<LinkedList<E>> result = new ArrayList<>();
        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }
        LinkedList<E> prefix = new LinkedList<>();
        prefix.add(node.getValue());

        /* Recurse on left and right subtrees. */
        ArrayList<LinkedList<E>> leftSeq = allSequence(node.getLeft());
        ArrayList<LinkedList<E>> rightSeq = allSequence(node.getRight());

        /* Weave together each list from the left and right sides. */
        for (LinkedList<E> left : leftSeq) {
            for (LinkedList<E> right : rightSeq) {
                ArrayList<LinkedList<E>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    /* Weave lists together in all possible ways. This algorithm works by removing the 29 * head from one list, recursing, and then doing the same thing with the other
     * list. */
    private static <E> void weaveLists(LinkedList<E> first, LinkedList<E> second, ArrayList<LinkedList<E>> results, LinkedList<E> prefix) {
        /*  One list is empty. Add remainder to [a cloned] prefix and store result. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<E> result = (LinkedList<E>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        /* Recurse with head of first added to the prefix. Removing the head will damage
         * first, so we'll need to put it back where we found it afterwards. */
        E headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with second, damaging and then restoring the list.*/
        E headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);
    }

    public static <E> boolean containsTree(TreeNode<E> firstTree, TreeNode<E> secondTree) {
        if (secondTree == null)
            return true;
        return isSubtree(firstTree, secondTree);
    }

    private static <E> boolean isSubtree(TreeNode<E> firstTree, TreeNode<E> secondTree) {
        if (firstTree == null)
            return false;
        else if (firstTree.getValue().equals(secondTree.getValue()) && matchTree(firstTree, secondTree))
            return true;
        else
            return isSubtree(firstTree.getLeft(), secondTree) || isSubtree(firstTree.getRight(), secondTree);
    }

    private static <E> boolean matchTree(TreeNode<E> firstTree, TreeNode<E> secondTree) {
        if (firstTree == null && secondTree == null)
            return true;
        else if (firstTree == null || secondTree == null)
            return false;
        else if (!firstTree.getValue().equals(secondTree.getValue()))
            return false;
        else
            return matchTree(firstTree.getRight(), secondTree.getRight()) && matchTree(firstTree.getLeft(), secondTree.getLeft());
    }


}
