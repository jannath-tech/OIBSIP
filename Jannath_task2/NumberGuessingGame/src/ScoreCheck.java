public class ScoreCheck {

    private int totalScore;
    private int wins;
    private int totalRounds;
    private int bestAttempts;

    public ScoreCheck() {
        totalScore = 0;
        wins = 0;
        totalRounds = 0;
        bestAttempts = 999;
    }

    public void recordWin(int points, int attempts) {
        totalScore += points;
        wins++;
        totalRounds++;
        if (attempts < bestAttempts) {
            bestAttempts = attempts;
        }
    }

    public void recordLoss() {
        totalRounds++;
    }

    public void display() {
        System.out.println("\n========== SCOREBOARD ==========");
        System.out.println("  Total Score   : " + totalScore + " pts");
        System.out.println("  Rounds Played : " + totalRounds);
        System.out.println("  Wins          : " + wins + " / " + totalRounds);
        if (bestAttempts == 999) {
            System.out.println("  Best Round    : N/A");
        } else {
            System.out.println("  Best Round    : " + bestAttempts + " attempts");
        }
        System.out.println("================================");
    }

    public int getTotalScore()  { return totalScore; }
    public int getWins()        { return wins; }
    public int getTotalRounds() { return totalRounds; }
}
