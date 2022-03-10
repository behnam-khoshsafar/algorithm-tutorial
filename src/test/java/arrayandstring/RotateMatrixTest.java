package arrayandstring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RotateMatrixTest {

    @Test
    public void rotateMatrix() {
        int[][] matrix = new int[3][3];
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = counter++;
            }
        }

        RotateMatrix.rotateMatrix(matrix);

        Assertions.assertEquals(0,matrix[0][2]);
        Assertions.assertEquals(1,matrix[1][2]);
        Assertions.assertEquals(2,matrix[2][2]);
        Assertions.assertEquals(3,matrix[0][1]);
        Assertions.assertEquals(4,matrix[1][1]);
        Assertions.assertEquals(5,matrix[2][1]);
        Assertions.assertEquals(6,matrix[0][0]);
        Assertions.assertEquals(7,matrix[1][0]);
        Assertions.assertEquals(8,matrix[2][0]);
    }
}