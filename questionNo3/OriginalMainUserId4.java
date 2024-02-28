import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 두 개의 정수를 입력 받음
       
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        
        // 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 연산을 수행
        int sum = num1 + num2;
        int subtract = num1 - num2;
        int multiply = num1 * num2;
        int divide = num1 / num2;
        int remainder = num1 % num2;
        
        // 결과 출력
        System.out.println(num1 + " + " + num2 + " = " + sum);
        System.out.println(num1 + " - " + num2 + " = " + subtract);
        System.out.println(num1 + " * " + num2 + " = " + multiply);
        System.out.println(num1 + " / " + num2 + " = " + divide);
        System.out.println(num1 + " % " + num2 + " = " + remainder);
    }
}
