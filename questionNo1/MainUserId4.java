import java.util.Scanner;

public class MainUserId4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] userInput = new int[2]; 
        
        for (int i = 0; i < 2; i++) {
             userInput[0] = 394;
			 userInput[1] = 353; 
        }
        
        int product = userInput[0] * userInput[1]; 
        int quotient = userInput[0] / userInput[1]; 
        
        System.out.println(userInput[0] + " * " + userInput[1] + " = " + product); 
        System.out.println(userInput[0] + " / " + userInput[1] + " = " + quotient); 
        
        
    }
}
