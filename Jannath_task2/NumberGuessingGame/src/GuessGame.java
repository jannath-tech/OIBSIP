import java.util.Random;

public class GuessGame {

    private int secretNumber;
    private int attempts;
    private int maxAttempts;
    private int lo, hi;
    private boolean won;

    public GuessGame(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        newRound();
    }

    public void newRound() {
        Random random = new Random();
        secretNumber = random.nextInt(100) + 1;
        attempts = 0;
        lo = 1;
        hi = 100;
        won = false;
    }

    public String makeGuess(int guess) {
        attempts++;
        int left = maxAttempts - attempts;

        if (guess == secretNumber) {
            won = true;
            return "CORRECT";
        } else if (attempts >= maxAttempts) {
            return "GAMEOVER:" + secretNumber;
        } else if (guess < secretNumber) {
            lo = guess + 1;
            return "LOW:" + left;
        } else {
            hi = guess - 1;
            return "HIGH:" + left;
        }
    }

    public int calcPoints() {
        return Math.max(10, (maxAttempts - attempts + 1) * 10);
    }

    public int getAttempts()    { return attempts; }
    public int getMaxAttempts() { return maxAttempts; }
    public int getLo()          { return lo; }
    public int getHi()          { return hi; }
    public boolean isWon()      { return won; }
}
