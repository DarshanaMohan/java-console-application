import java.util.Scanner;

public class Operation {

    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while(true){
    System.out.println("Enter your choice:\n1.Addition\n2.Subtraction\n3.Mutiplication\n4.Division\n5.Power\n6.Exit");
    int choice = s.nextInt();
    if(choice==0 || choice>6)
    {
        System.out.println("Enter Number between 1 and 6");
        continue;
    }
        if (choice==6){
            System.out.println("Exitting");
            break;
        }
    System.out.println("Enter Either 2 or 3 number");
    int input = s.nextInt();
if(input<2 || input>3){
    System.out.println("enter either 1 or 2");
    continue;
}
    if (input == 2) {
        System.out.println("enter  number 1:");
        double num1 = s.nextDouble();
        System.out.println("enter  number 2:");
        double num2 = s.nextDouble();
        if (choice == 1)
            System.out.println(Calculator.add(num1, num2));
        if (choice == 2)
            System.out.println(Calculator.sub(num1, num2));
        if (choice == 3)
            System.out.println(Calculator.mul(num1, num2));
        if (choice == 4)
            System.out.println(Calculator.div(num1, num2));
        if (choice == 5)
            System.out.println(Calculator.power(num1, num2));
    }
        if (input == 3) {
            System.out.println("enter  number 1:");
            double num1 = s.nextDouble();
            System.out.println("enter  number 2:");
            double num2 = s.nextDouble();
            System.out.println("enter  number 3:");
            double n = s.nextDouble();
            if (choice == 1)
                System.out.println(Calculator.add(num1, num2, n));
            if (choice == 2)
                System.out.println(Calculator.sub(num1, num2, n));
            if (choice == 3)
                System.out.println(Calculator.mul(num1, num2, n));
            if (choice == 4)
                System.out.println(Calculator.div(num1, num2, n));
            if (choice == 5)
                System.out.println(Calculator.power(num1, num2, n));
                }
            }

        }
        }


