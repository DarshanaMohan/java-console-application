import java.util.Scanner;
public class Calculator {
     static double add(double a, double b) {
        double c = a + b;
        return c;
    }

    static double add(double a, double b, double c) {
        double d = a + b + c;
        return d;
    }

    static double sub(double a, double b, double c) {
        double d = a - b - c;
        return d;
    }
    static double sub(double a, double b) {
        double c = a - b;
        return c;
    }

    static double mul(double a, double b) {
        double c = a * b;
        System.out.println("result" + c);
        return c;
    }

    static double mul(double a, double b, double c) {
        double d = a * b * c;
        return d;
    }

    static double div(double a, double b) {
        double c = a / b;
        return c;
    }

    static double div(double a, double b, double c) {
        double d = a / b / c;
        return d;
    }
    static double power(double a, double b) {
        double c = Math.pow(a,b);
        return c;
    }

    static double power(double a, double b, double c) {
        double d = Math.pow(Math.pow(a,b),c);
        return d;
    }
}
