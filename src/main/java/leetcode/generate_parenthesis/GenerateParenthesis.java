package leetcode.generate_parenthesis;

import java.util.HashSet;
import java.util.Set;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static Set<String> generateParenthesis(int count) {
        Set<String> result = new HashSet<>();
        generateParenthesis(result, "", 0, 0, count);
        return result;
    }

    private static void generateParenthesis(Set<String> result, String item, int open, int close, int count) {
        if (open == close && open == count) {
            result.add(item);
            return;
        }

        if (open < count)
            generateParenthesis(result, item + "(", open + 1, close, count);
        if (close < open)
            generateParenthesis(result, item + ")", open, close + 1, count);
    }

}
