public class Main {
    public static void main(String[] args) {
        System.out.println("Create matrix object using Matrix(double[][] d):");
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3, 4}, {5, 6}, {7, 8}, {9}});
        System.out.println(m1.toString());

        System.out.println("\nConverting matrix data from double [] to double [][]:");
        double [][] d1 = m1.asArray();
        for (int i = 0; i < d1.length; i++) {
            for (int j = 0; j < d1.length; j++) {
                System.out.print(d1[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("\nGet value from [1][1]: " + m1.get(1,1));
        m1.set(1,1, 10);
        System.out.println("Get value from [1][1] after setting it to 10: " + m1.get(1,1));

        Matrix matrixToReshape = new Matrix (new double[][] {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}});
        System.out.println("\nMatrix to reshape:\n" + matrixToReshape.toString());
        matrixToReshape.reshape(4, 3);
        System.out.println("\nReshaped matrix (from 3x4 to 4x3):\n" + matrixToReshape.toString());

        System.out.println("\nNumber of rows: " + matrixToReshape.shape()[0]);
        System.out.println("Number of columns: " + matrixToReshape.shape()[1]);

        Matrix matrix1 = new Matrix(new double[][]{{4, 8}, {3, 7}});
        Matrix matrix2 = new Matrix(new double[][]{{1, 0}, {5, 2}});

        System.out.println("\nMatrix adding:");
        System.out.println(matrix1.add(matrix2).toString());
        System.out.println(matrix1.add(2).toString());
        System.out.println("\nMatrix subtraction:");
        System.out.println(matrix1.sub(matrix2).toString());
        System.out.println(matrix1.sub(2).toString());
        System.out.println("\nMatrix multiplication:");
        System.out.println(matrix1.mul(matrix2).toString());
        System.out.println(matrix1.mul(2).toString());
        System.out.println("\nMatrix dividing:");
        System.out.println(matrix1.div(matrix2).toString());
        System.out.println(matrix1.div(2).toString());
        System.out.println("\nStandard matrix multiplication:");
        System.out.println(matrix1.dot(matrix2).toString());

        System.out.println("\nFrobenius norm: " + matrix1.frobenius());

        System.out.println("\nCreate unit matrix using eye(n):");
        Matrix eyeMatrix = Matrix.eye(4);
        System.out.println(eyeMatrix.toString());

        System.out.println("\nCreate matrix fileld with random values:");
        Matrix randomMatrix = Matrix.random(3,3);
        System.out.println(randomMatrix.toString());

        Matrix m = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix col = m.sumRows();
        System.out.printf("\nTEST -> matrix check:\n%s\n", col.toString());
    }
}
