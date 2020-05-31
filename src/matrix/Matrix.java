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

    public static Matrix identityMatrix(int size){
        double [][] matrix = new double [size][size];
        for(int i=0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                if (i == j){
                    matrix[i][j] = 1;
                }
            }
        }
        return new Matrix(matrix);
    }

    @Override
    public void rowAddition(int row1, int row2, int destination) {
        if(row1 < row && row2 < row) {
            for(int index = 0; index< this.matrix[0].length; index++) {
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
    public void rowAddition(int row1, int row2, int destination, double coefficient1, double coefficient2) {
        if(row1 < row && row2 < row) {
            for(int index = 0; index< this.matrix[0].length; index++) {
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
    public void solve(){
        for (int currentRow = 0; currentRow < this.row; currentRow ++){
            int currentCol = searchForNonZero(currentRow);
            removeNeighbors(currentRow, currentCol);
        }
    }

    private int searchForNonZero(int row){
        for(int currentCol = row; currentCol < this.col; currentCol ++) {
            for(int currentRow = row; currentRow < this.row; currentRow ++) {
                if (this.matrix[currentRow][currentCol] != 0){
                    if (this.matrix[currentRow][currentCol] != 1)
                        rowMultiplication(currentRow, 1/ (this.matrix[currentRow][currentCol]));
                    if (currentRow != row)
                        rowSwap(currentRow, row);
                    return currentCol;
                }
            }
        }
        return this.col;
    }

    private void removeNeighbors(int row, int col){
        for (int rowToEdit = row + 1; rowToEdit < this.row; rowToEdit ++){
            if(this.matrix[rowToEdit][col] != 0){
                rowAddition(row , rowToEdit, rowToEdit,
                        -1 * this.matrix[rowToEdit][col], 1);
            }
        }
    }

    public static Matrix matrixMultiplication (Matrix matrixA, Matrix matrixB) throws MatrixException {
        if (matrixA.col != matrixB.row){
            throw new MatrixMultiplicationException();
        }
        Matrix result = new Matrix(matrixA.row, matrixB.col);
        for (int k = 0; k < matrixB.col; k ++){
            for(int i = 0; i< matrixA.row; i ++){
                int count = 0;
                for(int j = 0; j < matrixA.col; j++){
                    count += matrixA.matrix[i][j] * matrixB.matrix[j][k];
                }
                result.matrix[i][k] = count;
            }
        }
        return result;
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
    public String toString() {
        StringBuilder matrixOutput = new StringBuilder();
        for(double [] row: this.matrix)
        {
            matrixOutput.append("{");
            for(double number: row)
            {
                matrixOutput.append(number).append(" ");
            }
            matrixOutput.append("}\n");
        }

        return matrixOutput.toString();
    }
}
