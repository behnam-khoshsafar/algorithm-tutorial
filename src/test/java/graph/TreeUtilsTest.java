package graph;

import graph.model.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static graph.TreeUtils.isValidBST;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void isBalancedNullInput() {
        assertFalse(TreeUtils.isBalanced(null));
    }

    @Test
    public void isBalancedOneElement() {
        TreeNode<Integer> root = new TreeNode<>(10);
        assertTrue(TreeUtils.isBalanced(root));
    }

    @Test
    public void isBalancedForInBalanceTree() {
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> rootRightNode = new TreeNode<>(12);
        root.setRight(rootRightNode);
        rootRightNode.setRight(new TreeNode<>(14));
        assertFalse(TreeUtils.isBalanced(root));
    }

    @Test
    public void isBalancedForInBalanceTree2() {
        TreeNode<Integer> root = new TreeNode<>(10);

        TreeNode<Integer> rootRightNode = new TreeNode<>(12);
        root.setRight(rootRightNode);
        rootRightNode.setLeft(new TreeNode<>(2));

        TreeNode<Integer> rootLeftNode = new TreeNode<>(14);
        root.setLeft(rootLeftNode);
        TreeNode<Integer> newNode = new TreeNode<>(13);
        newNode.setRight(new TreeNode<>(14));
        rootLeftNode.setRight(newNode);

        assertFalse(TreeUtils.isBalanced(root));
    }

    @Test
    public void isBalancedForBalanceTree() {
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> rootRightNode = new TreeNode<>(12);
        root.setRight(rootRightNode);
        root.setLeft(new TreeNode<>(14));
        assertTrue(TreeUtils.isBalanced(root));
    }

    @Test
    public void isBalancedForBalanceTree2() {
        TreeNode<Integer> root = new TreeNode<>(10);

        TreeNode<Integer> rootRightNode = new TreeNode<>(12);
        root.setRight(rootRightNode);
        rootRightNode.setLeft(new TreeNode<>(2));

        TreeNode<Integer> rootLeftNode = new TreeNode<>(14);
        root.setLeft(rootLeftNode);
        rootLeftNode.setRight(new TreeNode<>(13));

        assertTrue(TreeUtils.isBalanced(root));
    }

    @Test
    public void isValidBSTEmptyInput() {
        assertTrue(isValidBST(null));
    }

    @Test
    public void isValidBSTOneElement() {
        Assertions.assertTrue(isValidBST(new TreeNode<>(10)));
    }

    @Test
    public void isValidBSTTwoElement() {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.setRight(new TreeNode<>(15));
        Assertions.assertTrue(isValidBST(root));
    }

    @Test
    public void isValidBSTTwoElement2() {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.setRight(new TreeNode<>(5));
        assertFalse((isValidBST(root)));
    }

    @Test
    public void isValidBSTTwoElement3() {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.setLeft(new TreeNode<>(5));
        Assertions.assertTrue((isValidBST(root)));
    }

    @Test
    public void isValidBSTTwoElement4() {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.setLeft(new TreeNode<>(20));
        assertFalse((isValidBST(root)));
    }

    @Test
    public void isValidBSTMoreThanTwoElement() {
        TreeNode<Integer> root = new TreeNode<>(20);
        TreeNode<Integer> leftNode = new TreeNode<>(10);
        leftNode.setRight(new TreeNode<>(25));
        leftNode.setLeft(new TreeNode<>(5));
        root.setLeft(leftNode);

        assertFalse((isValidBST(root)));
    }

    @Test
    public void containsTreeSecondTreeIsEmpty() {
        TreeNode<Integer> firstRoot = new TreeNode<>(10);
        assertTrue(TreeUtils.containsTree(firstRoot, null));
    }

    @Test
    public void containsTreeFirstTreeIsEmpty() {
        TreeNode<Integer> firstRoot = new TreeNode<>(10);
        assertFalse(TreeUtils.containsTree(null, firstRoot));
    }


}