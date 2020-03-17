public class Matrix {
    private int row;
    private int col;
    private int [][] matrix;

    // populate a zero n x m array
    public Matrix(int row, int col)
    {
        this.matrix = new int[row][col];

    }
    public Matrix(int [][] matrix)
    {
        this.matrix = matrix;
    }

}
