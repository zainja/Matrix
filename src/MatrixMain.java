import java.util.ArrayList;

public class MatrixMain {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(new int[][]{{1,2,3},{4,5,6}});
        matrix.addition(0,1,1);
        matrix.rowMultiplication(0,10);
        matrix.printMatrix();

    }
}
