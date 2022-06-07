package recursion;

public class MagicIndex {

    public static int findMagicIndex(int[] items) {
        return findMagicIndex(items, 0, items.length - 1);
    }

    private static int findMagicIndex(int[] items, int left, int right) {
        if (left > right)
            return -1;

        int mid = (right + left) / 2;

        if (items[mid] < mid)
            return findMagicIndex(items, mid + 1, right);
        else if (items[mid] > mid)
            return findMagicIndex(items, left, mid - 1);
        else
            return mid;
    }

}
