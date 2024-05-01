package FarmingGame;
import java.util.Random;
import java.util.Scanner;

public class Questions {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private GameObjects gameObjects = new GameObjects();

    public void randomQuestions() {
        String[] questions = {"What is the capital of France?", "Who wrote 'To Kill a Mockingbird'?",
            "What is the chemical symbol for water?", "What year did World War II end?",
            "How many continents are there?", "What is the tallest mammal?",
            "What is the largest planet in our solar system?", "What is the square root of 144?",
            "What is the chemical symbol for gold?", "What is the powerhouse of the cell?",
            "Who painted the Mona Lisa?", "Who is known as the father of modern physics?",
            "What is the symbol for the element oxygen?", "What is the largest ocean on Earth?",
            "What is the freezing point of water in degrees Celsius?", "What is the main ingredient in guacamole?",
            "Who wrote 'Hamlet'?", "What is the capital of Japan?", "What is the largest bone in the human body?",
            "What is the boiling point of water in degrees Celsius?"};

        String[] answers = {"Paris", "Harper Lee", "H2O", "1945", "7", "Giraffe", "Jupiter", "12", "Au", "Mitochondria",
            "Leonardo da Vinci", "Albert Einstein", "O", "Pacific", "0", "Avocado", "William Shakespeare", "Tokyo",
            "Femur", "100"};

        boolean[] asked = new boolean[questions.length];

        for (int questionsAsked = 0; questionsAsked < questions.length; ) {
            int index = random.nextInt(questions.length);

            if (!asked[index]) {
                System.out.println("Question " + (questionsAsked + 1) + ": " + questions[index]);
                System.out.print("Your answer: ");
                String userAnswer = scanner.nextLine();

                if (userAnswer.equalsIgnoreCase(answers[index])) {
                    System.out.println("You have successfuly fed the animals.!\nIn addition you'll receive additional 5 seedlings!");
                    gameObjects.incrementSeedlings(5);
                    break;
                } else {
                    System.out.println("Incorrect. Try again.");
                }

                asked[index] = true;
            }
        }
    }
}
