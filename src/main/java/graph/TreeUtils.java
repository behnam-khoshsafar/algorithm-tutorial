package graph;

import graph.model.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

}
