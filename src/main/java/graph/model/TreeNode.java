package graph.model;

public class TreeNode<E> {
    private final E value;
    private TreeNode<E> left;
    private TreeNode<E> right;

    public TreeNode(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<E> left) {
        this.left = left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public void setRight(TreeNode<E> right) {
        this.right = right;
    }
}
