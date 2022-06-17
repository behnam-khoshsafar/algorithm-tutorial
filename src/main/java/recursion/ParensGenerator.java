package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParensGenerator {

    public static Set<String> generateParens(int numberOfParensPair) {
        HashSet<String> result = new HashSet<>();
        if (numberOfParensPair == 0) {
            result.add("");
            return result;
        }
        Set<String> prevParens = generateParens(numberOfParensPair - 1);
        for (String prev : prevParens) {
            for (int i = 0; i < prev.length(); i++) {
                if (prev.charAt(i) == '(') {
                    String newItem = insertInside(prev, i);
                    result.add(newItem);
                }
            }
            result.add("()" + prev);
        }
        return result;
    }

    private static String insertInside(String str, int i) {
        String beginningPart = str.substring(0, i + 1);
        String lastPart = str.substring(i + 1);
        return beginningPart + "()" + lastPart;
    }

    private static List<String> generateParens2(int count) {
        char[] str = new char[count * 2];
        List<String> list = new ArrayList<>();
        addParen(list, count, count, str, 0);
        return list;
    }

    private static void addParen(List<String> list, int leftRem, int rightRem, char[] str, int index) {
        if (leftRem < 0 || rightRem < leftRem) return;//invalid state
        if (leftRem == 0 && rightRem == 0) {
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '(';//Add left and recurse
            addParen(list, leftRem - 1, rightRem, str, index + 1);
            str[index] = ')';//Add right and recurse
            addParen(list, leftRem, rightRem - 1, str, index + 1);
        }
    }
}
