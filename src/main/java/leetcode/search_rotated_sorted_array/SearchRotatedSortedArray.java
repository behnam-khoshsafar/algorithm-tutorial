package leetcode.search_rotated_sorted_array;

import java.util.Random;

public class SearchRotatedSortedArray {

    public static int findIndex(int[] items, int target) {
        int left = 0;
        int right = items.length - 1;

        while (left <= right) {
            int mid = right + left / 2;
            if (items[mid] == target)
                return mid;
            if (items[left] <= items[mid]) {
//                left part
                if (target > items[mid]) {
                    left = mid + 1;
                } else {
                    if (target > items[left])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            } else {
//                right part
                if (target < items[mid])
                    right = mid - 1;
                else {
                    if (target > items[right])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findIndex(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(findIndex(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

}
