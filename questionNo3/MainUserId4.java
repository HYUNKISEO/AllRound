import java.util.Scanner;

public class MainUserId4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
       
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        
        
        int sum = num1 + num2;
        int subtract = num1 - num2;
        int multiply = num1 * num2;
        int divide = num1 / num2;
        int remainder = num1 % num2;
        
        
        System.out.println(num1 + " + " + num2 + " = " + sum);
        System.out.println(num1 + " - " + num2 + " = " + subtract);
        System.out.println(num1 + " * " + num2 + " = " + multiply);
        System.out.println(num1 + " / " + num2 + " = " + divide);
        System.out.println(num1 + " % " + num2 + " = " + remainder);
    }
}
