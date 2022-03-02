package arrayandstring;

import org.junit.jupiter.api.Test;

import static arrayandstring.PalindromePermutation.isPalindrome;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromePermutationTest {

    @Test
    public void shouldReturnValidResponse() {
        assertFalse(isPalindrome(null));
        assertFalse(isPalindrome(""));
        assertTrue(isPalindrome("xyxzxxyz"));
        assertTrue(isPalindrome("xyxzwxxyz"));
        assertTrue(isPalindrome("Tact Coa"));
    }

}
