package lab5;

import java.util.ArrayList;
import java.util.List;

public class Prod extends Node {
    List<Node> args = new ArrayList<>();

    Prod(){}

    Prod(Node n1){
        args.add(n1);
    }

    Prod(double c){
        this(new Constant(c));
    }

    Prod(Node n1, Node n2){
        args.add(n1);
        args.add(n2);
    }

    Prod(double c, Node n){
        this(new Constant(c), n);
    }

    Prod mul(Node n){
        args.add(n);
        return this;
    }

    Prod mul(double c){
        args.add(new Constant(c));
        return this;
    }

    @Override
    double evaluate() {
        double result = 1;
        for (Node node : args) {
            result *= node.evaluate();
        }
        return sign*result;
    }

    int getArgumentsCount() { return args.size(); }

    public String toString() {
        StringBuilder b =  new StringBuilder();

        if (sign<0) b.append("-(");
        for ( int i = 0; i < args.size(); i++) {
            if ( args.get(i).getSign() < 0 ) b.append("(");
            if ( i > 0 ) b.append("*");
            b.append(args.get(i).toString());
            if ( args.get(i).getSign() < 0 ) b.append(")");
        }

        if(sign<0)b.append(")");

        return b.toString();
    }
}
