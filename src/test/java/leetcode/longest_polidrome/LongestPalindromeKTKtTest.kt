package leetcode.longest_polidrome

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LongestPalindromeKTKtTest {

    @Test
    fun getLongestPalindrome() {
        assertEquals("bab",getLongestPalindrome("babad"))
        assertEquals("bb", getLongestPalindrome("cbbd"))
    }
}