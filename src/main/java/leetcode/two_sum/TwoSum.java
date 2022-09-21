package leetcode.two_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static Integer[] twoSum(Integer[] items, Integer target) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            Integer x = target - items[i];
            if (result.containsKey(x))
                return new Integer[]{result.get(x), i};
            result.put(items[i], i);
        }
        return null;
    }

}
