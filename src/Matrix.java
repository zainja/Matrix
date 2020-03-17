public class Matrix implements MatrixInterface{
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

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }


    @Override
    public Matrix addition(int row1, int row2) {
        return null;
    }

    @Override
    public Matrix rowMultiplication(int row, int number) {
        return null;
    }

    @Override
    public Matrix ref() {
        return null;
    }

    @Override
    public Matrix rref() {
        return null;
    }

    @Override
    public Matrix solve() {
        return null;
    }
}
