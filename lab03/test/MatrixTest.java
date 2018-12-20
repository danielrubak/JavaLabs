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
    }

    @org.junit.Test
    public void add() {
    }

    @org.junit.Test
    public void sub() {
    }

    @org.junit.Test
    public void mul() {
    }

    @org.junit.Test
    public void div() {
    }

    @org.junit.Test
    public void add1() {
    }

    @org.junit.Test
    public void sub1() {
    }

    @org.junit.Test
    public void mul1() {
    }

    @org.junit.Test
    public void div1() {
    }

    @org.junit.Test
    public void dot() {
    }

    @org.junit.Test
    public void frobenius() {
    }
}