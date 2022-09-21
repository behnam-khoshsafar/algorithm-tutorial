package leetcode.two_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    public void twoSum() {
        Integer[] result = TwoSum.twoSum(new Integer[]{2, 7, 11, 15}, 9);
        assert result != null;
        Assertions.assertEquals(result.length, 2);
        Assertions.assertEquals(result[0], 0);
        Assertions.assertEquals(result[1], 1);
    }

}