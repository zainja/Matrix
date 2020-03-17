public interface MatrixInterface {
    public void rowAddition(int row1, int row2,int destination);
    public void rowAddition(int row1, int row2,int destination, int coefficient1, int coefficient2);
    public void rowMultiplication(int row, int number);
    public Matrix ref();
    public Matrix rref();
    public Matrix solve();
    public void printMatrix();
}
