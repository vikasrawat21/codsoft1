import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        int matches = 0;
        int totalAttempts = 0;
        int matcheswon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            matches++;
            int randomNumber = (int) (Math.random() * (max - min + 1) + min);
            int attempts = 0;

            System.out.println("\nRound " + matches);
            System.out.println("Guess a number between " + min + " and " + max + ".");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess Number: ");
                int guess = 0;

                try {
                    guess = scanner.nextInt();
                    if (guess < min || guess > max) {
                        System.out.println("Please enter a number between " + min + " and " + max + ".");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("That's not a valid number! Please try again.");
                    scanner.next(); // clear the invalid input
                    continue;
                }

                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    totalAttempts += attempts;
                    matcheswon++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low. Please try again.");
                } else {
                    System.out.println("Too high. Please try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + randomNumber + ".");
                totalAttempts += maxAttempts;
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nGame over!");
        System.out.println("Rounds played: " + matches);
        System.out.println("Rounds won: " + matcheswon);
        System.out.println("Total attempts: " + totalAttempts);
        if (matches > 0) {
            System.out.println("Average attempts per round: " + (double) totalAttempts / matches);
        }
        scanner.close(); // Corrected line
    }
}
