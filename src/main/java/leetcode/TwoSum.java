package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static Integer[] twoSum(Integer[] items, Integer target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            Integer x = target - items[i];
            if (map.containsKey(x))
                return new Integer[]{map.get(x), i};
            map.put(items[i], i);
        }
        return null;
    }

}
