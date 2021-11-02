package arrayandstring;

import java.util.Arrays;

public class Permutation {


    public boolean checkPermutationWithoutSort(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        int[] chars = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            chars[ch]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            chars[ch]--;
            if (chars[ch] < 0)
                return false;
        }
        return true;
    }

    public boolean checkPermutationWithSort(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        return sort(str1).equals(sort(str2));
    }

    private String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}
