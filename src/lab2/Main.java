package lab2;

public class Main {
    public static void main(String[] args) {
        //Matrix m1 = new Matrix(new double[][]{{1,2,3,4},{5,6},{7,8},{9}});
        //System.out.printf("Basic matrix:\n%s\n", m1.toString());

        //Matrix matrixToReshape = new Matrix (new double[][] {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}});
        //matrixToReshape.reshape(4, 3);
        //System.out.printf("Reshaped matrix:\n%s", matrixToReshape.toString());
        //System.out.println();

        //int[] matrixShape = m1.shape();
        //System.out.printf("Number of rows: %d", matrixShape[0]);
        //System.out.println();
        //System.out.printf("Number of rows: %d", matrixShape[1]);

        Matrix m = new Matrix(new double[][]{{1,2,3},{4,5,6},{7,8,9}});
        Matrix col = m.sumRows();
        System.out.printf("Matrix check:\n%s\n", col.toString());
    }
}
