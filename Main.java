import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Integer> boxPositions = scatterBoxes(random);
        System.out.println("Welcome Martians! Guess where your cargo is hidden.");
        while (true) {
            boolean allFound = false;
            for (int attempt = 1; attempt <= 5; attempt++) {
                System.out.println("\nAttempt " + attempt + " of 5:");
                ArrayList<Integer> guesses = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    System.out.print("Enter guess for box " + (i + 1) + " (1-7): ");
                    guesses.add(scanner.nextInt());
                }

                int correct = 0;
                for (int i = 0; i < 3; i++) {
                    if (guesses.get(i).equals(boxPositions.get(i))) {
                        correct++;
                    }
                }
                System.out.println("You guessed " + correct + " boxes correctly!");
                if (correct == 3) {
                    System.out.println("Congratulations! All cargo found!");
                    allFound = true;
                    break;
                }
            }
            if (allFound) break;
            System.out.println("\nThe boxes have moved to new locations!");
            boxPositions = scatterBoxes(random);
        }