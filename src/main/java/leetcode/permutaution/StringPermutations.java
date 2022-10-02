package leetcode.permutaution;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String args[]) {
        permutation("123");
    }

    public static void permutation(String input) {
        List<String> result = new ArrayList<>();
        permutation(result, "", input);
        System.out.println(result);
    }

    private static void permutation(List<String> result, String perm, String word) {
        if (word.isEmpty()) {
            result.add(perm);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(result, perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1));
            }
        }
    }
}
