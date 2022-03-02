package arrayandstring;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty())
            return false;

        char[] chars = getChars(str);

        Map<Character, Integer> frequencyMap = new HashMap<>();
        var oddCounter = 0;
        for (Character ch : chars) {
            int value = (frequencyMap.getOrDefault(ch, 1)) + 1;
            if (value % 2 == 0)
                oddCounter--;
            else
                oddCounter++;
            frequencyMap.put(ch, value);
        }

        boolean isOdd = lengthIsOdd(chars);
        return (isOdd && oddCounter == 1) || (!isOdd && oddCounter == 0);
    }

    private static boolean lengthIsOdd(char[] chars) {
        return (chars.length % 2) != 0;
    }

    private static char[] getChars(String str) {
        str = str.replaceAll("\\s+", "");
        return str.toLowerCase().toCharArray();
    }
}
