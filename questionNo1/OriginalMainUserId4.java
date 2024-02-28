import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] userInput = new int[2]; 
        
        for (int i = 0; i < 2; i++) {
            userInput[i] = scanner.nextInt(); 
        }
        
        int product = userInput[0] * userInput[1]; 
        int quotient = userInput[0] / userInput[1]; 
        
        System.out.println(userInput[0] + " * " + userInput[1] + " = " + product); 
        System.out.println(userInput[0] + " / " + userInput[1] + " = " + quotient); // 변수명 변경
        
        scanner.close();
    }
}
