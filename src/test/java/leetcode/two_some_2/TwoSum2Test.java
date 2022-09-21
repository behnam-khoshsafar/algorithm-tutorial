package leetcode.two_some_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSum2Test {
    @Test
    public void twoSum() {
        Integer[] result = TwoSum2.twoSum(new Integer[]{1, 3, 4, 5, 7, 11}, 9);
        assert result != null;
        Assertions.assertEquals(result.length, 2);
        Assertions.assertEquals(result[0], 2);
        Assertions.assertEquals(result[1], 3);
    }
}