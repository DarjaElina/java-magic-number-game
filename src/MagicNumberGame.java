import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MagicNumberGame {
    static void playGame(Scanner scanner) {
        System.out.println("Welcome to Magic Number! 🪄🔮");
        System.out.println("Here are the game rules:");
        System.out.println("⭐ You need to guess a number between 1 and 100");
        System.out.println("⭐️ Computer will give you hints");
        System.out.println("⭐️ You have 10 tries");
        System.out.println("Shall we start? (yes/no): ");
        String answer = scanner.nextLine().trim();
        if (!answer.equalsIgnoreCase("yes")) {
            System.out.println("Goodbye! 🧙");
            System.exit(0);
        }
        while (true) {
            int amountOfGuesses = 0;
            Random randomGenerator = new Random();
            int magicNumber = randomGenerator.nextInt(100);
            System.out.println("Enter your magic number: ");

            while (true) {
                amountOfGuesses++;
                try {
                    int guess = scanner.nextInt();
                    if (guess == magicNumber) {
                        String endOfLine = amountOfGuesses == 1 ? " guess" : " guesses!";
                        System.out.println("🎉 You got it in " + amountOfGuesses + endOfLine);
                        scanner.nextLine();
                        break;
                    }
                    if (amountOfGuesses > 10) {
                        System.out.println("❌ You've used all your tries! The number was: " + magicNumber);
                        scanner.nextLine();
                        break;
                    } else {
                        if (guess < magicNumber) {
                            System.out.println("Hint: 📉 Too low!");
                            if (magicNumber - guess <= 5) {
                                System.out.println("Hint: 🔥 Very close!");
                            }
                            if (magicNumber - guess >= 30) {
                                System.out.println("Hint: ❄️ Way off...");
                            }
                        }
                        if (guess > magicNumber) {
                            System.out.println("Hint: 📈 Too high!");
                            if (guess - magicNumber <= 5) {
                                System.out.println("Hint: 🔥 Very close!");
                            }
                            if (guess - magicNumber >= 30) {
                                System.out.println("Hint: ❄️ Way off...");
                            }
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("❌ That wasn't a valid number.");
                    scanner.nextLine();
                    System.out.println("Would you like to try again? (yes/no): ");
                    String tryAgain = scanner.nextLine().trim();
                    if (!tryAgain.equalsIgnoreCase("yes")) {
                        break;
                    }
                }
            }
            System.out.println("Would you like to play again? (yes/no): ");
            String playAgain = scanner.nextLine().trim();
            if (!playAgain.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing! Goodbye! 🧙");
                break;
            }
        }
        scanner.close();
    }
}
