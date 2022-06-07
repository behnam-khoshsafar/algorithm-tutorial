package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MagicIndexTest {

    @Test
    public void findMagicIndex() {
        int[] items = {-40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13};
        Assertions.assertEquals(7, MagicIndex.findMagicIndex(items));
    }

}