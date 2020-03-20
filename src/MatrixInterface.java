public interface MatrixInterface {
    public void rowAddition(int row1, int row2,int destination);
    public void rowAddition(int row1, int row2,int destination, int coefficient1, int coefficient2);
    public void rowMultiplication(int row, int number);
    public int [] solve();
    public void printMatrix();
    public Matrix transpose();

}
