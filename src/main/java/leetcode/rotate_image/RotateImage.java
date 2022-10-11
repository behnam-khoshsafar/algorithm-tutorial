package leetcode.rotate_image;

public class RotateImage {

    public static void rotateImage(int[][] matrix) {

        int left = 0;
        int right = matrix.length - 1;

        while (left < right) {
            for (int i = left; i < right; i++) {
                int top = left;
                int bottom = right;
                //save top left
                var topLeft = matrix[top][left + i];

                // move bottom left to top left
                matrix[top][left + i] = matrix[bottom - i][left];

                //move bottom right to bottom left
                matrix[bottom - i][left] = matrix[bottom][right - i];

                //move top right to bottom right
                matrix[bottom][right - i] = matrix[top + i][right];

                //move top left into top right
                matrix[top + i][right] = topLeft;
            }
            right--;
            left++;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 19, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        rotateImage(matrix);
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] m) {
        try {
            int rows = m.length;
            int columns = m[0].length;
            String str = "|\t";

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    str += m[i][j] + "\t";
                }
                System.out.println(str + "|");
                str = "|\t";
            }
        } catch (Exception e) {
            System.out.println("Matrix is empty!!");
        }
    }
}
