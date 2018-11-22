package lab2;

public class Matrix {
    double[]data;
    int rows;
    int cols;

    Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        data = new double[rows*cols];
    }

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
                if ( j > (d[i].length - 1)) {
                    this.data[i * this.cols + j] = 0;
                } else {
                    this.data[i * this.cols + j] = d[i][j];
                }
            }
        }
    }

    public double[][] asArray() {
        double resultMatrix[][] = new double[this.rows][this.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                resultMatrix[i][j] = this.data[i * this.cols + j];
            }
        }
        return resultMatrix;
    }

    double get(int r,int c) {
        return this.data[this.cols * r + c];
    }

    void set (int r,int c, double value) {
        this.data[this.cols * r + c] = value;
    }

    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("[");

        for (int i=0; i<this.rows; i++) {
            buf.append("[");
            int j = 0;
            for (; j<this.cols-1; j++) {
                buf.append(this.data[i * this.cols + j]);
                buf.append(", ");
            }
            buf.append(this.data[i * this.cols + (j++)]);
            buf.append("]\n");
        }

        buf.deleteCharAt(buf.length()-1);
        buf.append("]");

        return buf.toString();
    }

    void reshape (int newRows,int newCols) {
        if(rows*cols != newRows*newCols)
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d",rows,cols,newRows,newCols));
        else {
            this.cols = newCols;
            this.rows = newRows;
        }
    }

    public int[] shape() {
        int[] shape = new int[2];
        shape[0] = rows;
        shape[1] = cols;

        return shape;
    }

    public Matrix add (Matrix m) {
        if (this.shape()[0] != m.shape()[0] || this.shape()[1] != m.shape()[1])
            throw new RuntimeException("Matrices differ in dimensions");

        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i=0; i<tempMatrix.length; i++) {
            tempMatrix[i] += m.data[i];
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    public Matrix sub (Matrix m) {
        if (this.shape()[0] != m.shape()[0] || this.shape()[1] != m.shape()[1])
            throw new RuntimeException("Matrices differ in dimensions");

        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i=0; i<tempMatrix.length; i++) {
            tempMatrix[i] -= m.data[i];
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    public Matrix mul (Matrix m) {

        if (this.shape()[0] != m.shape()[0] || this.shape()[1] != m.shape()[1])
            throw new RuntimeException("Matrices differ in dimensions");

        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i=0; i<tempMatrix.length; i++) {
            tempMatrix[i] *= m.data[i];
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    public Matrix div (Matrix m) {
        if (this.shape()[0] != m.shape()[0] || this.shape()[1] != m.shape()[1])
            throw new RuntimeException("Matrices differ in dimensions");

        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for(int i=0; i<tempMatrix.length; i++) {
            tempMatrix[i] /= m.data[i];
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    public Matrix add (double w) {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i=0; i<tempMatrix.length; i++) {
            tempMatrix[i] += w;
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    public Matrix sub (double w) {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i=0; i<tempMatrix.length; i++) {
            tempMatrix[i] -= w;
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    public Matrix mul (double w) {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for (int i=0; i<tempMatrix.length; i++) {
            tempMatrix[i] *= w;
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    public Matrix div (double w) {
        Matrix resultMatrix = new Matrix(this.rows, this.cols);
        double[] tempMatrix = this.data.clone();

        for(int i=0; i<tempMatrix.length; i++) {
            tempMatrix[i] /= w;
        }

        resultMatrix.data = tempMatrix;
        return resultMatrix;
    }

    public Matrix dot (Matrix other) {
        if (this.rows != other.cols || this.cols != other.rows)
            throw new RuntimeException("Matrices should have sizes: n x m and m x n");

        Matrix resultMatrix =  new Matrix(2,2);

        for (int i=0; i < this.rows; i++) {
            for (int j=0; j < other.cols; j++) {
                double sum = 0;
                for (int k=0; k < this.cols; k++) {
                    sum += this.get(i, k) * other.get(k, j);
                }
                resultMatrix.set(i, j, sum);
            }
        }
        return resultMatrix;
    }

    public double frobenius() {
        double sum = 0;

        for (int i=0; i<this.data.length; i++) {
            sum += data[i] * data[i];
        }

        return Math.sqrt(sum);
    }

    // KOLOKWIUM
    public Matrix sumRows() {
        Matrix resultMatrix =  new Matrix(1, this.rows);

        System.out.println(this.rows);
        System.out.println(this.cols);

        for (int i = 0; i < this.cols; i++) {
            double sum = 0;
            for ( int j = 0; j < this.rows; j++) {
                sum += this.data[j * this.cols + i];
            }
            resultMatrix.data[i] = sum;
        }
        return resultMatrix;
    }
}
