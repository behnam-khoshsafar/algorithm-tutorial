package leetcode.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<Integer[]> threeSum(Integer[] items) {
        var result = new ArrayList<Integer[]>();
        Arrays.sort(items);
        for (int i = 0; i < items.length; i++) {
            var firstElement = items[i];
            if (i > 0 && firstElement.equals(items[i - 1]))
                continue;

            int[] index = twoSum(items, i + 1, items.length - 1, -firstElement);

            if (index != null)
                result.add(new Integer[]{items[i], items[index[0]], items[index[1]]});
        }
        return result;
    }

    private static int[] twoSum(Integer[] items, int leftPointer, int rightPointer, int target) {
        while (leftPointer < rightPointer) {
            int value = items[leftPointer] + items[rightPointer];
            if (value < target)
                leftPointer++;
            else if (value > target)
                rightPointer--;
            else
                return new int[]{leftPointer, rightPointer};
        }
        return null;
    }


}
