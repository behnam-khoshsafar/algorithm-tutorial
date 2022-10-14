package leetcode.Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    private static Map<Character, String[]> phoneNumberMap = Map.of(
            '2', new String[]{"a", "b", "c"},
            '3', new String[]{"d", "e", "f"},
            '4', new String[]{"g", "h", "i"},
            '5', new String[]{"j", "k", "l"},
            '6', new String[]{"m", "n", "o"},
            '7', new String[]{"p", "q", "r", "s"},
            '8', new String[]{"t", "u", "v"},
            '9', new String[]{"w", "x", "y", "z"}
    );

    public static List<String> letterCombinationsOfAPhoneNumber(String phoneNumber) {
        List<String> result = new ArrayList<>();
        letterCombinationsOfAPhoneNumber(phoneNumber, result, "", 0);
        return result;
    }

    private static void letterCombinationsOfAPhoneNumber(String phoneNumber, List<String> result, String currentString, int index) {
        if (currentString.length() == phoneNumber.length()) {
            result.add(currentString);
            return;
        }
        String[] characters = phoneNumberMap.get(phoneNumber.charAt(index));
        for (String character : characters)
            letterCombinationsOfAPhoneNumber(phoneNumber, result, currentString + character, index + 1);
    }


    public static void main(String[] args) {
        List<String> result = letterCombinationsOfAPhoneNumber("23");
        result.forEach(System.out::println);
    }
}
