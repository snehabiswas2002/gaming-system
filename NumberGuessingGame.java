import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have to guess a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("You have " + maxAttempts + " attempts per round.");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Your guess is out of the valid range.");
                } else if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + targetNumber);
                    hasGuessedCorrectly = true;
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }

                attempts++;
            }

            if (!hasGuessedCorrectly) {
                System.out.println("You've run out of attempts. The correct number was: " + targetNumber);
            }

            rounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            playAgain = playAgainChoice.equals("yes");
        }

        System.out.println("Game over! You played " + rounds + " round(s) and won " + score + " round(s).");
    }
}
