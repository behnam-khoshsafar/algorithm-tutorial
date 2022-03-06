package arrayandstring;

public class StringCompression {

    public static String compress(String str) {
        if (str == null || str.isEmpty())
            return str;
        int count = 0;
        StringBuilder resultStr = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            count++;
            if (i == (chars.length - 1) || str.charAt(i) != str.charAt(i + 1)) {
                resultStr.append(str.charAt(i)).append(count);
                count = 0;
            }
        }
        return resultStr.length() >= str.length() ? str : resultStr.toString();
    }

}
