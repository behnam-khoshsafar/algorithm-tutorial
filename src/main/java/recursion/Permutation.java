package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public List<String> getPerms(String str) {
        if (str == null) return null;

        List<String> perms = new ArrayList<>();
        if (str.length() == 0) {
            perms.add("");
            return perms;
        }
        char firstCharacter = str.charAt(0);
        List<String> words = getPerms(str.substring(1));
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String s = insertCharacterAt(perms, firstCharacter, word, i);
                perms.add(s);
            }
        }
        return perms;
    }

    private String insertCharacterAt(List<String> perms, char firstCharacter, String word, int i) {
        String firstPart = word.substring(0, i);
        String lastPart = word.substring(i);
        return firstPart + firstCharacter + lastPart;
    }
}
