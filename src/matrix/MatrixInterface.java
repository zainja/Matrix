package matrix;

public interface MatrixInterface {
    void rowAddition(int row1, int row2,int destination);
    void rowAddition(int row1, int row2, int destination, double coefficient1, double coefficient2);
    void rowMultiplication(int row, double number);
    void rowSwap(int row, int row2);
    void solve();
    Matrix transpose();

}
