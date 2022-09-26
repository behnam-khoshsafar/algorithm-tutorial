package leetcode.longest_polidrome;

public class LongestPalindrome {

    public static String getLongestPalindrome(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.length() % 2 != 0) {
                result = findPalindrome(s, result, i, i);
            } else {
                result = findPalindrome(s, result, i, i + 1);
            }
        }
        return result;
    }

    private static String findPalindrome(String s, String result, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if ((right - left + 1) > result.length()) {
                result = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
        return result;
    }
}
