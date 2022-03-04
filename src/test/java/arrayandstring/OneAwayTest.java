package arrayandstring;

import org.junit.jupiter.api.Test;

import static arrayandstring.OneAway.isOneAway;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneAwayTest {

    @Test
    public void shouldReturnCorrectResponse() {
        assertFalse(isOneAway("pale", "pl"));
        assertTrue(isOneAway("pale", "ple"));
        assertTrue(isOneAway("pale", "bale"));
        assertTrue(isOneAway("ple", "pale"));
        assertFalse(isOneAway("pl", "pale"));
        assertFalse(isOneAway("pale", "bea"));
    }

}
