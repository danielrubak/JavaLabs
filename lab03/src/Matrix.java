import java.util.Random;

public class Matrix {
    double[] data;
    int rows;
    int cols;

    Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows * cols];
    }

    /**
     * @param d - two dimensional double array, max length of row is a number of columns
     */
    public Matrix(double[][] d) {
        this.rows = d.length;

        int cols = -1;
        for (int i = 0; i < this.rows; i++) {
            cols = Math.max(cols, d[i].length);
        }
        this.cols = cols;

        this.data = new double[this.rows * this.cols];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (j > (d[i].length - 1)) {
                    this.data[i * this.cols + j] = 0;
                } else {
                    this.data[i * this.cols + j] = d[i][j];
                }
            }
        }
    }

    /**
     * @return two dimensional double array
     */
    public double[][] asArray() {
        double resultMatrix[][] = new double[this.rows][this.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                resultMatrix[i][j] = this.data[i * this.cols + j];
            }
        }
        return resultMatrix;
    }

    /**
     * @param r - row index
     * @param c - column index
     * @return value from data[r][c]
     */
    double get(int r, int c) {
        return this.data[this.cols * r + c];
    }

    /**
     * @param r - row index
     * @param c - column index
     * @param value - setting value to data[r][c]
     */
    void set(int r, int c, double value) {
        this.data[this.cols * r + c] = value;
    }

    /**
     * @return data from this.data as an array formatted as string
     */
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("[");

        for (int i = 0; i < this.rows; i++) {
            buf.append("[");
            int j = 0;
            for (; j < this.cols - 1; j++) {
                buf.append(this.data[i * this.cols + j]);
                buf.append(", ");
            }
            buf.append(this.data[i * this.cols + (j++)]);
            buf.append("]\n");
        }

        buf.deleteCharAt(buf.length() - 1);
        buf.append("]");

        return buf.toString();
    }

    /**
     * @param newRows - new number of rows
     * @param newCols - new number of columns
     */
    void reshape(int newRows, int newCols) {
        if (rows * cols != newRows * newCols)
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d", rows, cols, newRows, newCols));
        else {
            this.cols = newCols;
            this.rows = newRows;
        }
    }

    /**
     * @return vector which contain number of rows on index 0 and number of columns on index 1
     */
    public int[] shape() {
        int[] shape = new int[2];
        shape[0] = rows;
        shape[1] = cols;

        return shape;
    }

    /**
     * @param m - Matrix object to add to this
     * @return result of matrices adding
     */
    public Matrix add(Matrix m) {
        if (this.shape()[0] != m.shape()[0] || this.shape()[1] != m.shape()[1])
            throw new RuntimeException("Matrices differ in dimensions");

        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i = 0; i < tempMatrix.length; i++) {
            tempMatrix[i] += m.data[i];
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    /**
     * @param w - value to add to every element of this object
     * @return result of matrices adding
     */
    public Matrix add(double w) {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i = 0; i < tempMatrix.length; i++) {
            tempMatrix[i] += w;
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    /**
     * @param m - Matrix object to subtract from this
     * @return result of matrices subtraction
     */
    public Matrix sub(Matrix m) {
        if (this.shape()[0] != m.shape()[0] || this.shape()[1] != m.shape()[1])
            throw new RuntimeException("Matrices differ in dimensions");

        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i = 0; i < tempMatrix.length; i++) {
            tempMatrix[i] -= m.data[i];
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    /**
     * @param w - value to subtract from every element of this object
     * @return result of matrices subtraction
     */
    public Matrix sub(double w) {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i = 0; i < tempMatrix.length; i++) {
            tempMatrix[i] -= w;
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    /**
     * @param m - Matrix object to multiply with this (only items on the same index are multiplied)
     * @return result of matrices multiplication
     */
    public Matrix mul(Matrix m) {

        if (this.shape()[0] != m.shape()[0] || this.shape()[1] != m.shape()[1])
            throw new RuntimeException("Matrices differ in dimensions");

        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] newData = this.data.clone();
        for (int i = 0; i < newData.length; i++) {
            newData[i] *= m.data[i];
        }
        resultMatrix.data = newData;
        return resultMatrix;
    }

    /**
     * @param w - value by which all elements are to be multiplied
     * @return result of matrices multiplication
     */
    public Matrix mul(double w) {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i = 0; i < tempMatrix.length; i++) {
            tempMatrix[i] *= w;
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    /**
     * @param m - Matrix object to divide with this (only items on the same index are divided)
     * @return result of matrices division
     */
    public Matrix div(Matrix m) {
        if (this.shape()[0] != m.shape()[0] || this.shape()[1] != m.shape()[1])
            throw new RuntimeException("Matrices differ in dimensions");

        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i = 0; i < tempMatrix.length; i++) {
            if ( m.data[i] == 0 ) {
                tempMatrix[i] = 0;
            } else {
                tempMatrix[i] /= m.data[i];
            }
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    /**
     * @param w - value by which all elements are to be divided
     * @return result of matrices division
     */
    public Matrix div(double w) {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i = 0; i < tempMatrix.length; i++) {
            tempMatrix[i] /= w;
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    /**
     * @param other - Matrix object to multiply with this
     * @return result of matrices multiplication
     */
    public Matrix dot(Matrix other) {
        if (this.rows != other.cols || this.cols != other.rows)
            throw new RuntimeException("Matrices should have sizes: n x m and m x n");

        Matrix resultMatrix = new Matrix(2, 2);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.get(i, k) * other.get(k, j);
                }
                resultMatrix.set(i, j, sum);
            }
        }
        return resultMatrix;
    }

    /**
     * @return frobenius norm
     */
    public double frobenius() {
        double sum = 0;
        for ( int i = 0; i < this.data.length; i++ ) {
            sum += data[i] * data[i];
        }
        return Math.sqrt(sum);
    }

    /**
     * @param rows - number of rows
     * @param cols - number of columns
     * @return matrix of size rowsxcols filled with random values
     */
    public static Matrix random(int rows, int cols){
        Matrix m = new Matrix(rows,cols);
        Random r = new Random();
        for ( int i = 0; i < rows; i++ ) {
            for ( int j = 0; j < cols; j++ ) {
                m.set(i, j, r.nextDouble());
            }
        }
        return m;
    }

    /**
     * @param n - matrix size
     * @return the unit matrix of size nxn
     */
    public static Matrix eye(int n){
        Matrix m = new Matrix(n,n);
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                if ( i == j ) {
                    m.set(i, j,1);
                } else {
                    m.set(i, j,0);
                }
            }
        }
        return m;
    }

    /**
     * @param rows - number of rows
     * @param cols - number of columns
     * @return matrix of size rows X cols filled with zeros
     */
    public static Matrix zeros(int rows, int cols) {
        Matrix m = new Matrix(rows,cols);
        for ( int i = 0; i < rows; i++ ) {
            for ( int j = 0; j < cols; j++ ) {
                m.set(i, j, 0);
            }
        }
        return m;
    }

    // ---------------------- //
    // Task on the colloquium //
    // ---------------------- //

    public Matrix sumRows() {
        Matrix resultMatrix = new Matrix(1, this.rows);
        for (int i = 0; i < this.cols; i++) {
            double sum = 0;
            for (int j = 0; j < this.rows; j++) {
                sum += this.data[j * this.cols + i];
            }
            resultMatrix.data[i] = sum;
        }
        return resultMatrix;
    }
}
