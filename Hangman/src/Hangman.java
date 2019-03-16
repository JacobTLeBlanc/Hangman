// Imports
import java.util.*;

// Create Class
public class Hangman {

    // Create main method
    public static void main(String[] args) {

        boolean playing = true;

        while (playing) {

            // Initialize start game
            boolean gameOn = true;

            // Initialize lives
            int lives = 5;

            // Pick word
            String word = pickWord();
            String newHid = "";
            String hidden = "";
            for (int i = 0; i < word.length(); i++) {
                hidden += "-";
            }

            // Create Scanner object
            Scanner input = new Scanner(System.in);

            while (gameOn) {

                // Take input and show stats
                System.out.println("Word: " + hidden);
                System.out.println("Lives: " + lives);
                System.out.println("Next letter: ");
                char nextChar = input.next().charAt(0);

                // Search for new char
                newHid = searchWord(nextChar, hidden, word);

                // Lose a life if new character not found
                if (newHid.equals(hidden)) {
                    lives--;
                }

                hidden = newHid;

                // Check if outta lives
                if (lives == 0) {
                    System.out.println("Out of lives");
                    gameOn = false;
                }

                // Check if word is finished
                if (hidden.equals(word)) {
                    System.out.println("Winner!");
                    gameOn = false;
                }
            }

            System.out.print("Play again? (Y/n) : ");
            char again = input.next().charAt(0);
            if (again == 'n') {
                playing = false;
            }

        }
    }

    // pickWord method
    public static String pickWord() {

        String[] arr = {"cat", "bird", "sealion", "lion", "fox", "elephant", "gerbal", "snake", "horse", "dog"};

        Random rand = new Random();
        int i = rand.nextInt(10);

        return arr[i];
    }

    // searchWord method
    public static String searchWord(char nextChar, String hidWord, String fullWord) {

        for (int i = 0; i < fullWord.length(); i++) {

            if (fullWord.charAt(i) == nextChar) {

                hidWord = hidWord.substring(0,i)+fullWord.charAt(i)+hidWord.substring(i + 1);
            }
        }

        return hidWord;
    }
}
