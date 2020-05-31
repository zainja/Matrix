package matrix;

public class Matrix implements MatrixInterface{
    private int row;
    private int col;
    private double [][] matrix;

    // populate a zero n x m array
    public Matrix(int row, int col)
    {
        this.matrix = new double[row][col];
    }

    public Matrix(double [][] matrix) {
        this.matrix = matrix;
        this.row = matrix.length;
        this.col = matrix[0].length;
        System.out.printf("matrix rows: %d columns: %d \n", this.row, this.col);
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
    public void rowAddition(int row1, int row2, int destination)
    {
        if(row1 < row && row2 < row)
        {
            for(int index = 0; index< this.matrix[0].length; index++)
            {
                this.matrix[destination][index] = this.matrix[row1][index] + this.matrix[row2][index];
            }
        }
    }

    @Override
    public void rowSwap(int row, int row2) {
        for(int index = 0; index< this.col; index ++)
        {
            double temp = this.matrix[row2][index];
            this.matrix[row2][index] = this.matrix[row][index];
            this.matrix[row][index] = temp;
        }
    }

    @Override
    public void rowAddition(int row1, int row2, int destination, int coefficient1, int coefficient2)
    {
        if(row1 < row && row2 < row)
        {
            for(int index = 0; index< this.matrix[0].length; index++)
            {
                this.matrix[destination][index] = coefficient1*this.matrix[row1][index] +
                        coefficient2*this.matrix[row2][index];
            }
        }

    }

    @Override
    public void rowMultiplication(int row, double number) {
        for(int index =0; index<this.matrix[row].length; index++) {
            this.matrix[row][index] = this.matrix[row][index] * number;
        }
    }


    @Override
    public int[] solve(){
        return null;
    }

    public static Matrix matrixMultiplication(Matrix matrixA, Matrix matrixB) {
        int [][] matrixResult = new int[matrixA.row][matrixB.col];

        if(matrixA.col != matrixB.row)
        {
            return null;
        }
        for(int i = 0; i<matrixResult.length; i ++)
        {
            for(int j=0; j<matrixB.col; j++)
            {
                int sum = 0;
                for(int k = 0; k<matrixA.row; k ++)
                {
                    sum += matrixA.matrix[i][k]*matrixB.matrix[k][j];
                }
                matrixResult[i][j] = sum;
            }
        }

        return new Matrix(matrixResult);
    }

    @Override
    public Matrix transpose() {
        double [] [] tempArray = new double [this.col][this.row];
        for(int i= 0; i < this.col; i ++)
        {
            for(int j = 0; j < this.row; j ++)
            {
                tempArray[i][j] = this.matrix[j][i];
            }
        }
        return new Matrix(tempArray);
    }

    @Override
    public void printMatrix() {
        for(int[] row: this.matrix)
        {
            System.out.print("{");
            for(int number: row)
            {
                System.out.print(number + " ");
            }
            System.out.println("}");
        }

    }
}
