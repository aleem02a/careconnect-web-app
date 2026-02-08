import java.util.Random;
import java.lang.*;
import java.util.Scanner;

public class GuessingGame {

    GuessingGame()// constructor
    {
        int score = 0;
        String playAgain = "";
        function_1(score, playAgain);
    }// constr end -1
     //////////

    int function_1(int scor, String playAgain) {
        Scanner scanner = new Scanner(System.in);// scanner
        Random random = new Random();// random
        int scores = scor;
        do {// do-while start
            int attempts = 5;// vara
            int numberToGuess = random.nextInt(100) + 1;// varia
            System.out.println("Guess a number between 1 and 100. You have " + attempts + " attempts.");
            attem_numberguessing_function(attempts, numberToGuess, scores);
            System.out.println("Your score is: " + scores);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();
        } while (playAgain.equalsIgnoreCase("yes"));// do while condion end
        System.out.println("Thank you for playing. Your final score is: " + scores);
        scanner.close();
        return 0;
    } /// function 1 end
      /////////

    int attem_numberguessing_function(int attem, int numberguess, int score)// function 2 end here
    {
        int attempt = attem;
        int numberguss = numberguess;
        Scanner scanner = new Scanner(System.in);
        while (attempt-- > 0) {// while condition
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();// temporrary varible is guess
            if (guess == numberguss) {// if else if
                System.out.println("Congratulations! You guessed the number.");
                score++;
                break;
            } else if (guess < numberguss) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            } // end of if else if

            if (attempt > 0) {// if else
                System.out.println("You have " + attempt + " attempts left. Try again.");

            } else {
                System.out.println("You've used all your attempts. The number was " + numberguss);
            }
        } // while condion end
        return 0;
    }// function 2 end here
    /////// /////////

    public static void main(String[] args) {/// main function //
        GuessingGame GM = new GuessingGame();
    }
}