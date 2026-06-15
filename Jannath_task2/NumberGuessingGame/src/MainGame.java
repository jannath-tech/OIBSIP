import java.util.Scanner;

public class MainGame {

    static Scanner sc = new Scanner(System.in);
    static int MAX_ATTEMPTS = 5;
    static int TOTAL_ROUNDS = 3;

    public static void main(String[] args) {

        printBanner();

        boolean playing = true;

        while (playing) {

            ScoreCheck scoreCheck = new ScoreCheck();
            GuessGame game = new GuessGame(MAX_ATTEMPTS);

            for (int round = 1; round <= TOTAL_ROUNDS; round++) {

                System.out.println("\n----------------------------------------");
                System.out.println("  ROUND " + round + " of " + TOTAL_ROUNDS + "  |  Score: " + scoreCheck.getTotalScore() + " pts");
                System.out.println("----------------------------------------");
                System.out.println("  Guess a number between 1 and 100.");
                System.out.println("  You have " + MAX_ATTEMPTS + " attempts.");
                System.out.println();

                game.newRound();

                boolean roundDone = false;

                while (!roundDone) {

                    System.out.print("  Your guess [" + game.getLo() + " to " + game.getHi() + "]: ");

                    String line = sc.nextLine().trim();

                    int guess;
                    try {
                        guess = Integer.parseInt(line);
                    } catch (NumberFormatException e) {
                        System.out.println("  Please guess a number!");
                        continue;
                    }

                    if (guess < 1 || guess > 100) {
                        System.out.println("  Number must be between 1 and 100!");
                        continue;
                    }

                    String result = game.makeGuess(guess);

                    if (result.equals("CORRECT")) {
                        int pts = game.calcPoints();
                        System.out.println("\n  voilaa! You got it in " + game.getAttempts() + " attempt(s)!");
                        System.out.println("  Points earned this round: +" + pts + " pts");
                        scoreCheck.recordWin(pts, game.getAttempts());
                        roundDone = true;

                    } else if (result.startsWith("GAMEOVER")) {
                        String secret = result.split(":")[1];
                        System.out.println("\n  No more attempts! The number was " + secret + ".");
                        System.out.println("  Uhoh! No points. Try next round!");
                        scoreCheck.recordLoss();
                        roundDone = true;

                    } else if (result.startsWith("LOW")) {
                        String left = result.split(":")[1];
                        System.out.println("  Too LOW! Go higher. (" + left + " attempts left)");

                    } else if (result.startsWith("HIGH")) {
                        String left = result.split(":")[1];
                        System.out.println("  Too HIGH! Go lower. (" + left + " attempts left)");
                    }
                }
            }

            System.out.println("\n  All " + TOTAL_ROUNDS + " rounds finished!");
            scoreCheck.display();

            System.out.print("\n  Play again? Type yes or no: ");
            String again = sc.nextLine().trim().toLowerCase();

            if (again.equals("yes") || again.equals("y")) {
                playing = true;
            } else {
                System.out.println("\n  Kudos! Final score: " + scoreCheck.getTotalScore() + " pts. Bye!");
                playing = false;
            }
        }
    }

    static void printBanner() {
        System.out.println("==========================================");
        System.out.println("        NUMBER GUESSING GAME             ");
        System.out.println("   Guess a number between 1 and 100   ");
        System.out.println("==========================================");
        System.out.println("  - " + MAX_ATTEMPTS + " attempts per round");
        System.out.println("  - " + TOTAL_ROUNDS + " rounds total");
        System.out.println("  - Fewer guesses = more points");
        System.out.println("==========================================");
        System.out.println();
    }
}
