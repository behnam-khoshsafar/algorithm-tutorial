package leetcode.longest_substring;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(getLengthOfLongestSubstring("abcabcbb"));
    }

    public static int getLengthOfLongestSubstring(String input) {
        Set<Character> characters = new HashSet<>();
        int length = 0;
        int left = 0;
        int right = 0;
        while (right < input.length()) {
            char c = input.charAt(right);
            while (characters.contains(c)) {
                characters.remove(input.charAt(left));
                left++;
            }
            characters.add(c);
            if (length < characters.size())
                length = characters.size();
            right++;
        }
        return length;
    }
}
