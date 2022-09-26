package leetcode.longest_polidrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    @Test
    void getLongestPalindrome() {
        Assertions.assertEquals("bab",LongestPalindrome.getLongestPalindrome("babad"));
        Assertions.assertEquals("bb",LongestPalindrome.getLongestPalindrome("cbbd"));
    }
}