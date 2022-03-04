package arrayandstring;

public class OneAway {
    public static boolean isOneAway(String firstStr, String secondStr) {
        if ((firstStr == null || secondStr == null) || (Math.abs(firstStr.length() - secondStr.length()) > 1))
            return false;
        String smallStr = getSmallStr(firstStr, secondStr);
        String biggerStr = getBiggerStr(firstStr, secondStr);
        return doProcess(smallStr, biggerStr);
    }

    private static boolean doProcess(String smallStr, String biggerStr) {
        int smallIndex = 0;
        int biggerIndex = 0;
        boolean isMoreThanOneDiffExist = false;
        while (biggerIndex < biggerStr.length() && smallIndex < smallStr.length()) {
            if (smallStr.charAt(smallIndex) != biggerStr.charAt(biggerIndex)) {
                if (isMoreThanOneDiffExist) return false;
                isMoreThanOneDiffExist = true;
                if (smallStr.length() == biggerStr.length())
                    smallIndex++;
            } else {
                smallIndex++;
            }
            biggerIndex++;
        }
        return true;
    }

    private static String getBiggerStr(String firstStr, String secondStr) {
        return firstStr.length() < secondStr.length() ? secondStr : firstStr;
    }

    private static String getSmallStr(String firstStr, String secondStr) {
        return firstStr.length() > secondStr.length() ? secondStr : firstStr;
    }
}
