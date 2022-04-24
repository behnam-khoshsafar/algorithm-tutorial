package graph;

import graph.model.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TreeUtilsTest {

    @Test
    public void createMinimalBSTEmptyInput() {
        assertNull(TreeUtils.createMinimalBST(null));
    }

    @Test
    public void createMinimalBSTWithOneItem() {
        Integer[] items = new Integer[1];
        items[0] = 1;

        TreeNode<Integer> minimalBST = TreeUtils.createMinimalBST(items);

        assertEquals(1, minimalBST.getValue());
        assertNull(minimalBST.getLeft());
        assertNull(minimalBST.getRight());
    }

    @Test
    public void createMinimalBST() {
        Integer[] items = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode<Integer> root = TreeUtils.createMinimalBST(items);

        assertEquals(4, root.getValue());
        assertEquals(1, root.getLeft().getValue());
        assertEquals(0, root.getLeft().getLeft().getValue());
        assertEquals(2, root.getLeft().getRight().getValue());
        assertNull(root.getLeft().getRight().getLeft());
        assertEquals(3, root.getLeft().getRight().getRight().getValue());
        assertNull(root.getLeft().getRight().getRight().getLeft());
        assertNull(root.getLeft().getRight().getRight().getRight());
        assertEquals(7, root.getRight().getValue());
        assertEquals(5, root.getRight().getLeft().getValue());
        assertNull(root.getRight().getLeft().getLeft());
        assertEquals(6, root.getRight().getLeft().getRight().getValue());
        assertNull(root.getRight().getLeft().getRight().getLeft());
        assertNull(root.getRight().getLeft().getRight().getRight());
        assertEquals(8, root.getRight().getRight().getValue());
        assertNull(root.getRight().getRight().getLeft());
        assertEquals(9, root.getRight().getRight().getRight().getValue());
        assertNull(root.getRight().getRight().getRight().getLeft());
        assertNull(root.getRight().getRight().getRight().getRight());
        assertEquals(7, root.getRight().getValue());
    }

    @Test
    public void createLevelLinkedListNullInput() {
        assertEquals(Collections.emptyList(), TreeUtils.createLevelLinkedList(null));
    }

    @Test
    public void createLevelLinkedListOneNodeInput() {
        TreeNode<Integer> root = new TreeNode<>(10);

        List<LinkedList<TreeNode<Integer>>> result = TreeUtils.createLevelLinkedList(root);

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(10, result.get(0).getFirst().getValue());
        assertNull(result.get(0).getFirst().getRight());
        assertNull(result.get(0).getFirst().getLeft());
    }

    @Test
    public void createLevelLinkedListWithMultiLevel() {
        TreeNode<Integer> root = new TreeNode<>(10);

        TreeNode<Integer> rootLeft = new TreeNode<>(5);
        root.setLeft(rootLeft);
        rootLeft.setLeft(new TreeNode<>(3));
        rootLeft.setRight(new TreeNode<>(7));

        TreeNode<Integer> rootRight = new TreeNode<>(15);
        root.setRight(rootRight);
        rootRight.setLeft(new TreeNode<>(12));
        rootRight.setRight(new TreeNode<>(17));

        List<LinkedList<TreeNode<Integer>>> result = TreeUtils.createLevelLinkedList(root);

        assertEquals(3, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(10, result.get(0).getFirst().getValue());

        assertEquals(2, result.get(1).size());
        assertEquals(5, result.get(1).get(0).getValue());
        assertEquals(15, result.get(1).get(1).getValue());

        assertEquals(4, result.get(2).size());
        assertEquals(3, result.get(2).get(0).getValue());
        assertEquals(7, result.get(2).get(1).getValue());
        assertEquals(12, result.get(2).get(2).getValue());
        assertEquals(17, result.get(2).get(3).getValue());
    }

}