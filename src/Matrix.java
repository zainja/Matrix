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
    public void rowAddition(int row1, int row2, int destination) {
        if(row1 < this.matrix[0].length && row2 < this.matrix[0].length)
        {
            for(int index = 0; index< this.matrix[0].length; index++)
            {
                this.matrix[destination][index] = this.matrix[row1][index] + this.matrix[row2][index];
            }
        }
    }

    @Override
    public void rowAddition(int row1, int row2, int destination, int coefficient1, int coefficient2) {

    }

    @Override
    public void rowMultiplication(int row, int number) {
        for(int index =0; index<this.matrix[row].length; index++)
        {
            this.matrix[row][index] = this.matrix[row][index] * number;
        }
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

    @Override
    public void printMatrix() {
        for(int[] row: this.matrix)
        {
            System.out.print("[ ");
            for(int number: row)
            {
                System.out.print(number + " ");
            }
            System.out.println("]");
        }
    }
}
