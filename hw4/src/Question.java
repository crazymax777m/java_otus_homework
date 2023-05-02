public class Question {
    private final String question;
    private final String[] options;
    private final int answer;

    public Question(String question, String[] options, int answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getAnswer() {
        return answer;
    }
}
