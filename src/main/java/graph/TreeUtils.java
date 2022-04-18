package graph;

import graph.model.TreeNode;

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


}
