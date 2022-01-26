package arrayandstring;

import java.util.HashSet;
import java.util.Set;

public class UniqueChar {

    public boolean isUnique(String str) {
        if (str == null || str.isBlank() || str.length() > 128)
            return true;

        boolean[] chars = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (chars[ch])
                return false;
            chars[ch] = true;
        }
        return true;
    }

    public boolean isUniqueUsingSet(String str) {
        if (str == null || str.isBlank() || str.length() > 128)
            return true;

        Set<Character> characterSet = new HashSet<>();
        for (Character character : str.toCharArray()) {
            if (characterSet.contains(character))
                return false;
            characterSet.add(character);
        }
        return true;
    }
}
