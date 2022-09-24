package leetcode.three_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ThreeSumTest {

    @Test
    public void threeSum() {
        List<Integer[]> result = ThreeSum.threeSum(new Integer[]{-3, 3, 4, -3, 1, 2});
        Assertions.assertEquals(result.size(), 1);
        result.forEach(items -> {
            Assertions.assertEquals(items[0], -3);
            Assertions.assertEquals(items[1], 1);
            Assertions.assertEquals(items[2], 2);
        });
    }

}