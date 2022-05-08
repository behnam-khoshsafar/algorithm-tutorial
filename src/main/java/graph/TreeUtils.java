package graph;

import graph.model.TreeNode;

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
}
