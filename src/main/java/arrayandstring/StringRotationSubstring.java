package arrayandstring;

public class StringRotationSubstring {
    public static boolean isRotation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;
        if (str1.equals(str2))
            return true;

        int rotationPoint = getRotationPoint(str1, str2);

        String rotated = str1.substring(rotationPoint) + str1.substring(0, rotationPoint);
        return rotated.equals(str2);
    }

    private static int getRotationPoint(String str1, String str2) {
        int j = 0;
        int rotationPoint = 0;
        for (int i = 0; i < str1.toCharArray().length; i++) {
            char ch = str1.charAt(i);
            if (ch == str2.charAt(j)) {
                j++;
                if (rotationPoint == 0) rotationPoint = i;
            } else {
                j = 0;
                rotationPoint = 0;
            }
        }
        return rotationPoint;
    }
}
