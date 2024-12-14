import java.util.Scanner;
class Calculator
{
    void process()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n1.addtion\n 2.subtraction\n 3.multiplication\n 4.division");
        System.out.println("enter your choice:");
        int choice=sc.nextInt();
        if(choice>4)
        {
            System.out.println("invalid choice");
            return;
        }
        System.out.println("enter the number of operands:");
        int numcount=sc.nextInt();
        double[]numbers=new double[numcount];
        System.out.println("enter"+numcount+"numbers");
        for(int i=0 ; i<numcount ; i++)
        {
            numbers[i]=sc.nextDouble();
        }
        double result=numbers[0];
        switch(choice)
        {
            case 1:
                for(int i=1;i<numcount;i++)
                {
                    result += numbers[i];
                }
                System.out.println("the result of addition is:"+result);
                break;

            case 2:
                for(int i=1;i<numcount;i++)
                {
                    result -= numbers[i];
                }
                System.out.println("the result of subtraction is:"+result);
                break;

            case 3:
                for(int i=1;i<numcount;i++)
                {
                    result *= numbers[i];
                }
                System.out.println("the result of multiplication is:"+result);
                break;

            case 4:
                for(int i=1;i<numcount;i++)
                {
                    result /= numbers[i];
                }
                System.out.println("the result of division is:"+result);
                break;

            default:
                System.out.println("invalid choice");
        }
        sc.close();
    }
}