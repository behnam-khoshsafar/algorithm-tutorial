@file:Suppress("NAME_SHADOWING")

package leetcode.longest_polidrome

fun getLongestPalindrome(s: String): String? {
    var result = ""
    for (i in s.indices) {
        result = if (s.length % 2 != 0) {
            findPalindrome(s, result, i, i)
        } else {
            findPalindrome(s, result, i, i + 1)
        }
    }
    return result
}

private fun findPalindrome(s: String, result: String, left: Int, right: Int): String {
    var result = result
    var left = left
    var right = right
    while (left >= 0 && right < s.length && s[left] == s[right]) {
        if (right - left + 1 > result.length) {
            result = s.substring(left..right)
        }
        left--
        right++
    }
    return result
}