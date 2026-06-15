public class Questions {
    String question;
    String[] options;
    int correctAnswer;

    public Questions(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}
