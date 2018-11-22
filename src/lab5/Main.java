package lab5;

public class Main {
    public static void main(String[] args) {
        buildAndPrint();
    }

    static void buildAndPrint() {
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(2.1,new Power(x,3))
                .add(new Power(x,2))
                .add(-2,x)
                .add(7);
        System.out.println(exp.toString());

    }
}
