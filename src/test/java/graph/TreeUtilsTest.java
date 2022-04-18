package graph;

import graph.model.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TreeUtilsTest {

    @Test
    public void createMinimalBSTEmptyInput() {
        assertNull(TreeUtils.createMinimalBST(new Integer[10]));
        assertNull(TreeUtils.createMinimalBST(null));
    }

    @Test
    public void createMinimalBSTWithOneItem() {
        Integer[] items = new Integer[1];
        items[0] = 1;
        assertEquals(1, TreeUtils.createMinimalBST(items).getValue());
        assertNull(TreeUtils.createMinimalBST(items).getLeft());
        assertNull(TreeUtils.createMinimalBST(items).getRight());
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

}