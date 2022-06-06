package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripleStairTest {

    @Test
    public void count() {
        TripleStair tripleStair = new TripleStair();
        Assertions.assertEquals(1, tripleStair.countWays(0));
        Assertions.assertEquals(1, tripleStair.countWays(1));
        Assertions.assertEquals(2, tripleStair.countWays(2));
        Assertions.assertEquals(4, tripleStair.countWays(3));
        Assertions.assertEquals(7, tripleStair.countWays(4));
        Assertions.assertEquals(13, tripleStair.countWays(5));
    }

}
