public interface MatrixInterface {
    public Matrix addition(int row1, int row2);
    public Matrix rowMultiplication(int row, int number);
    public Matrix ref();
    public Matrix rref();
    public Matrix solve();
}
