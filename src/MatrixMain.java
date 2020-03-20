import java.util.ArrayList;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new int[][]{{1,2,3},{4,5,6}});
        matrix.printMatrix();
        matrix.transpose();
        matrix.printMatrix();
        System.out.println("sdfghj");
        Matrix matrix1 = new Matrix(new int[][]{{1,2,4},{1,2,3},{5,6,7}});
        Matrix matrix2 = new Matrix(new int[][] {{5,6,7},{5,3,5},{1,2,4}});
        Matrix matrix3 = Matrix.matrixMultiplication(matrix1, matrix2);
        matrix3.printMatrix();

    }
}
