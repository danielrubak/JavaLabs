public class Main {
    public static void main(String[] args) {
        buildAndPrint();
        buildAndEvaluate();
        defineCircle();
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

    static void buildAndEvaluate() {
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(new Power(x, 3))
                .add(-2, new Power(x, 2))
                .add(-1, x)
                .add(2);

        double THRESHOLD = .0001;
        System.out.println("\nRoots of the function f(x) = " + exp.toString());
        int i = 1;
        for (double v = -5; v < 5; v += 0.1) {
            x.setValue(v);
            if ( Math.abs(exp.evaluate() - 0.000000) < THRESHOLD ) {
                System.out.println(i + ". " + v);
                i++;
            }
            //System.out.printf(Locale.US, "f(%f)=%f\n", v, exp.evaluate());
        }
    }

    static void defineCircle(){
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Node circle = new Sum()
                .add(new Power(x,2))
                .add(new Power(y,2))
                .add(8,x)
                .add(4,y)
                .add(16);
        System.out.println("\nCircle equation: " + circle.toString());

        int i = 0;
        String[] pointsInsideCircle = new String[100];
        System.out.println("Points inside circle: ");
        while ( i < 100 ) {
            double xv = 100*(Math.random()-.5);
            double yv = 100*(Math.random()-.5);
            x.setValue(xv);
            y.setValue(yv);
            double fv = circle.evaluate();
            if ( fv < 0 ) {
                pointsInsideCircle[i] = "(" + xv + ", " + yv + ")";
                i++;
            }
        }

        for (String point : pointsInsideCircle) {
            System.out.println(point);
        }

        /*double xv = 100*(Math.random()-.5);
        double yv = 100*(Math.random()-.5);
        x.setValue(xv);
        y.setValue(yv);
        double fv = circle.evaluate();
        System.out.print(String.format("Punkt (%f, %f) leży %s koła %s",xv,yv,(fv<0?"wewnątrz":"na zewnątrz"),circle.toString()));*/
    }
}
