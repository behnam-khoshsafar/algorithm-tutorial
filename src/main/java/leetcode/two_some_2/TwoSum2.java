package leetcode.two_some_2;

public class TwoSum2 {

    public static Integer[] twoSum(Integer[] aceOrderedItems, Integer target) {
        int left = 0;
        int right = aceOrderedItems.length - 1;
        while (left < right) {
            int value = aceOrderedItems[left] + aceOrderedItems[right];
            if (value > target)
                right--;
            else if (value < target)
                left++;
            else
                return new Integer[]{left, right};

        }
        return null;
    }

}
