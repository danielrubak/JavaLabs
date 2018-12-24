import static org.junit.Assert.*;

public class MatrixTest {

    private Matrix generate2X2Matrix() {
        double[][] array = new double[2][2];

        array[0][0] = 2;
        array[0][1] = 4;
        array[1][0] = 6;
        array[1][1] = 8;

        return new Matrix(array);
    }

    private Matrix generate2X3Matrix() {
        double[][] array2X3 = new double[2][3];

        array2X3[0][0] = 1;
        array2X3[0][1] = 2;
        array2X3[0][2] = 3;
        array2X3[1][0] = 4;
        array2X3[1][1] = 5;
        array2X3[1][2] = 6;

        return new Matrix(array2X3);
    }

    @org.junit.Test
    public void asArray() {
        Matrix matrixForTest = generate2X2Matrix();

        double matrixAsArray[][] = matrixForTest.asArray();
        assertEquals(matrixAsArray[0][0], 2, .2);
        assertEquals(matrixAsArray[0][1], 4, .2);
        assertEquals(matrixAsArray[1][0], 6, .2);
        assertEquals(matrixAsArray[1][1], 8, .2);
    }

    @org.junit.Test
    public void get() {
        Matrix matrixForTest = generate2X2Matrix();

        assertEquals(2, matrixForTest.get(0, 0), .2);
        assertEquals(4, matrixForTest.get(0, 1), .2);
        assertEquals(6, matrixForTest.get(1, 0), .2);
        assertEquals(8, matrixForTest.get(1, 1), .2);
    }

    @org.junit.Test
    public void set() {
        Matrix matrixForTest = new Matrix(2, 2);
        matrixForTest.set(0, 0, 1);
        matrixForTest.set(0, 1, 2);
        matrixForTest.set(1, 0, 3);
        matrixForTest.set(1, 1, 4);

        assertEquals(1, matrixForTest.get(0, 0), .2);
        assertEquals(2, matrixForTest.get(0, 1), .2);
        assertEquals(3, matrixForTest.get(1, 0), .2);
        assertEquals(4, matrixForTest.get(1, 1), .2);
    }

    @org.junit.Test
    public void testToString() {
        Matrix matrixForTest = generate2X2Matrix();
        String expectedString = "[[2.0, 4.0]\n[6.0, 8.0]]";

        assertEquals(expectedString, matrixForTest.toString());
    }

    @org.junit.Test
    public void reshape() {
        Matrix matrixForTest = generate2X3Matrix();
        matrixForTest.reshape(3, 2);

        assertEquals(1, matrixForTest.get(0, 0), .2);
        assertEquals(2, matrixForTest.get(0, 1), .2);
        assertEquals(3, matrixForTest.get(1, 0), .2);
        assertEquals(4, matrixForTest.get(1, 1), .2);
        assertEquals(5, matrixForTest.get(2, 0), .2);
        assertEquals(6, matrixForTest.get(2, 1), .2);
    }

    @org.junit.Test
    public void shape() {
        Matrix matrixForTest = generate2X3Matrix();
        assertEquals(2, matrixForTest.shape()[0], .2);
        assertEquals(3, matrixForTest.shape()[1], .2);
    }

    @org.junit.Test
    public void add() {
        Matrix matrixForTest = generate2X2Matrix();
        Matrix result = matrixForTest.add(Matrix.eye(2));
        assertEquals(result.get(0, 0), 3, .2);
        assertEquals(result.get(0, 1), 4, .2);
        assertEquals(result.get(1, 0), 6, .2);
        assertEquals(result.get(1, 1), 9, .2);
    }

    @org.junit.Test
    public void add1() {
        Matrix matrixForTest = generate2X2Matrix();
        Matrix result = matrixForTest.add(1);
        assertEquals(result.get(0, 0), 3, .2);
        assertEquals(result.get(0, 1), 5, .2);
        assertEquals(result.get(1, 0), 7, .2);
        assertEquals(result.get(1, 1), 9, .2);
    }

    @org.junit.Test
    public void sub() {
        Matrix matrixForTest = generate2X2Matrix();
        Matrix result = matrixForTest.sub(Matrix.eye(2));
        assertEquals(result.get(0, 0), 1, .2);
        assertEquals(result.get(0, 1), 4, .2);
        assertEquals(result.get(1, 0), 6, .2);
        assertEquals(result.get(1, 1), 7, .2);
    }

    @org.junit.Test
    public void sub1() {
        Matrix matrixForTest = generate2X2Matrix();
        Matrix result = matrixForTest.sub(1);
        assertEquals(result.get(0, 0), 1, .2);
        assertEquals(result.get(0, 1), 3, .2);
        assertEquals(result.get(1, 0), 5, .2);
        assertEquals(result.get(1, 1), 7, .2);
    }

    @org.junit.Test
    public void mul() {
        Matrix matrixForTest = generate2X2Matrix();
        Matrix result = matrixForTest.mul(Matrix.eye(2));
        assertEquals(result.get(0, 0), 2, .2);
        assertEquals(result.get(0, 1), 0, .2);
        assertEquals(result.get(1, 0), 0, .2);
        assertEquals(result.get(1, 1), 8, .2);
    }

    @org.junit.Test
    public void mul1() {
        Matrix matrixForTest = generate2X2Matrix();
        Matrix result = matrixForTest.mul(2);
        assertEquals(result.get(0, 0), 4, .2);
        assertEquals(result.get(0, 1), 8, .2);
        assertEquals(result.get(1, 0), 12, .2);
        assertEquals(result.get(1, 1), 16, .2);
    }

    @org.junit.Test
    public void div() {
        Matrix matrixForTest = generate2X2Matrix();
        Matrix result = matrixForTest.div(Matrix.eye(2));
        assertEquals(result.get(0, 0), 2, .2);
        assertEquals(result.get(0, 1), 0, .2);
        assertEquals(result.get(1, 0), 0, .2);
        assertEquals(result.get(1, 1), 8, .2);
    }

    @org.junit.Test
    public void div1() {
        Matrix matrixForTest = generate2X2Matrix();
        Matrix result = matrixForTest.div(2);
        assertEquals(result.get(0, 0), 1, .2);
        assertEquals(result.get(0, 1), 2, .2);
        assertEquals(result.get(1, 0), 3, .2);
        assertEquals(result.get(1, 1), 4, .2);
    }

    @org.junit.Test
    public void dot() {
        Matrix matrixForTest1 = generate2X3Matrix();
        Matrix matrixForTest2 = generate2X3Matrix();
        matrixForTest2.reshape(3,2);
        Matrix result = matrixForTest1.dot(matrixForTest2);
        assertEquals(result.get(0, 0), 22, .2);
        assertEquals(result.get(0, 1), 28, .2);
        assertEquals(result.get(1, 0), 49, .2);
        assertEquals(result.get(1, 1), 64, .2);
    }

    @org.junit.Test
    public void frobenius() {
        Matrix matrixForTest = generate2X2Matrix();
        assertEquals(10.95, matrixForTest.frobenius(), .1);
    }

    @org.junit.Test
    public void zeros() {
        Matrix matrixForTest = Matrix.zeros(2, 2);
        assertEquals(0, matrixForTest.get(0, 0), .2);
        assertEquals(0, matrixForTest.get(0, 1), .2);
        assertEquals(0, matrixForTest.get(1, 0), .2);
        assertEquals(0, matrixForTest.get(1, 1), .2);
    }

    @org.junit.Test
    public void eye() {
        Matrix matrixForTest = Matrix.eye(2);
        assertEquals(1, matrixForTest.get(0, 0), .2);
        assertEquals(0, matrixForTest.get(0, 1), .2);
        assertEquals(0, matrixForTest.get(1, 0), .2);
        assertEquals(1, matrixForTest.get(1, 1), .2);
    }
}