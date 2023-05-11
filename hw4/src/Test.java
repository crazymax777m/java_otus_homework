import java.util.Scanner;

public class Test {
    private final Question[] questions;
    private int score;

    public Test(Question[] questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i].getQuestion());
            String[] options = questions[i].getOptions();
            for (int j = 0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }
            System.out.print("Enter your answer: ");
            int answer = scanner.nextInt();
            if (answer == questions[i].getAnswer()) {
                score++;
            }
            System.out.println();
        }
    }

    public int getScore() {
        return score;
    }
}
