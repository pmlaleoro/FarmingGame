package FarmingGame;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ErrorHandling {
    static Scanner scanner = new Scanner(System.in);
    static int provinceChoice;

    // Method to validate string input
    public static String validateStringInput() {
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches("^[a-zA-Z\\s]+$")) {
                System.out.println("Invalid input. Please enter only alphabetic characters and spaces.");
            } else {
                return input;
            }
        }
    }

    //Method to validate gender input
    public static String validateGenderInput(){
        while (true) {
            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "f":
                case "female":
                    return "Female";
                case "m":
                case "male":
                    return "Male";
                default:
                    System.out.println("Invalid input. Please enter 'F' for female or 'M' for male.");
            }
        }
    }

    //Method to validate integer input without minimum and maximum value
    public static int validateIntegerInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }

    //Method to validate integer input with maximum and minimum value
    public static int validateIntegerInputValue(int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); // consume newline character

                if (input < min || input > max) {
                    System.out.println("Invalid input. Please enter an integer within the valid range.");
                    continue;
                }

                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // consume invalid input
            }
        }
    }

    //Method to validate the
    public static int validateIntegerInputLogTree(int num){
        x:
        while(true){
            try{
                int input = scanner.nextInt();
                scanner.nextLine();

                if (input != num){
                    System.out.println("Invalid input. Please enter [8] only.");
                    continue x;
                }

                return input;

            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }
}
