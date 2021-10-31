package arrayandstring;

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

}
