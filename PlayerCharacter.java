package FarmingGame;
import java.util.Scanner;

public class PlayerCharacter {
    private String name;
    private int age;
    private int height;
    private String gender;
    public Scanner scanner = new Scanner(System.in);

    //method to customize the character
    public void customizeCharacter() {
        System.out.print("Enter character name: ");
        name = ErrorHandling.validateStringInput();

        System.out.print("Enter character age: ");
        age = ErrorHandling.validateIntegerInput();

        System.out.print("Enter character height(cm): ");
        height = ErrorHandling.validateIntegerInput();

        System.out.print("Enter character gender (F/M): ");
        gender = ErrorHandling.validateStringInput();
    }

    //method to display the customized character
    public void displayCharacter() {
        System.out.print("\nGood! This is your character's profile.\n\n");

        for (int i = 0; i < 25; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < 25; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.println("Character Profile: \n");
        if(gender.equals("F")){
            System.out.println("    /O\\");
            System.out.println("    /|\\");
            System.out.println("    / \\");
            System.out.println("   |   |");
            System.out.println();
        } else if (gender.equals("M")){
            // Print head
            System.out.println("     O");
            System.out.println("    /|\\");
            System.out.println("    /|\\");
            System.out.println("   |   |");
            System.out.println();
        }

        System.out.println("Name: " + name + "\n" +
                            "Age: " + age + " years old" + "\n" +
                            "Height: " + height + " cm" + "\n" +
                            "Gender: " + gender + "\n");

        for (int i = 0; i < 25; i++) {
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < 25; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //method to display the character house
    public void characterHouse(){
        System.out.println("   /\\");
        System.out.println("  /  \\");
        System.out.println(" /    \\");
        System.out.println("/______\\");
        System.out.println("|      |");
        System.out.println("|      |");
        System.out.println("|______|");
    }
}
