package arrayandstring;

import org.junit.jupiter.api.Test;

import static arrayandstring.StringCompression.compress;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StringCompressionTest {

    @Test
    public void shouldReturnCorrectResponse() {
        assertEquals("", compress(""));
        assertNull(compress(null));
        assertEquals("abc", compress("abc"));
        assertEquals("a2b1c5a3", compress("aabcccccaaa"));
    }

}
