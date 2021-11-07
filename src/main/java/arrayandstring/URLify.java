package arrayandstring;

public class URLify {

    public char[] doUrlify(char[] input, int actualSize) {
        int spaceCounter = getSpaceCount(input, actualSize);
        return replaceSpaces(input, actualSize, spaceCounter);
    }

    private char[] replaceSpaces(char[] inputChar, int actualSize, int spaceCounter) {
        int index = actualSize + spaceCounter * 2;
        if (index > inputChar.length)
            return inputChar;
        char[] replacedInput = new char[index];
        for (int i = actualSize - 1; i >= 0; i--) {
            if (inputChar[i] == ' ') {
                replacedInput[index - 1] = '0';
                replacedInput[index - 2] = '2';
                replacedInput[index - 3] = '%';
                index = index - 3;
            } else {
                replacedInput[index - 1] = inputChar[i];
                index--;
            }
        }
        return replacedInput;
    }

    private int getSpaceCount(char[] inputChar, int actualSize) {
        int spaceCounter = 0;
        for (int i = 0; i < actualSize; i++) {
            if (inputChar[i] == ' ')
                spaceCounter++;
        }
        return spaceCounter;
    }
}
