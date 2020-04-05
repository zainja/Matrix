import matrix.Matrix;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new int[][]{{1,2,3},{4,5,6}});
        Matrix matrix1 = Matrix.matrixMultiplication(matrix, matrix);
        matrix.printMatrix();


    }
}
