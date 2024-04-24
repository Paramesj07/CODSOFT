import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int totalAttempts = 0;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " + upperBound + ".");

        System.out.print("How many rounds do you want to play? ");
        int rounds = scanner.nextInt();

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round + ":");
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = playRound(scanner, targetNumber);
            totalAttempts += attempts;
        }

        System.out.println("\nGame Over! Total attempts: " + totalAttempts);
        scanner.close();
    }

    public static int playRound(Scanner scanner, int targetNumber) {
        int attempts = 0;

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == targetNumber) {
                System.out.println("Congratulations! You've guessed the number " + targetNumber + " correctly in " + attempts + " attempts!");
                break;
            } else if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        return attempts;
    }
}