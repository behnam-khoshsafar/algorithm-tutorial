package arrayandstring;

import org.junit.jupiter.api.Test;

import static arrayandstring.StringRotationSubstring.isRotation;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringRotationSubstringTest {

    @Test
    public void shouldReturnCorrectResult() {
        assertFalse(isRotation(null, null));
        assertFalse(isRotation("String1", "String"));
        assertTrue(isRotation("waterbottle", "erbottlewat"));
        assertTrue(isRotation("waterbottle", "waterbottle"));
        assertFalse(isRotation("waterbottle", "erbottletaw"));
    }
}
