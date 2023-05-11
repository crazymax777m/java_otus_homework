public class Main {
    public static void main(String[] args) {
        Question[] questions = {
                new Question("What is the capital of France?", new String[]{"London", "Paris", "Berlin", "Madrid"}, 2),
                new Question("What is the largest planet in the solar system?", new String[]{"Jupiter", "Saturn", "Mars", "Earth"}, 1),
                new Question("What is the highest mountain in the world?", new String[]{"K2", "Everest", "Makalu", "Cho Oyu"}, 2)
        };

        Test test = new Test(questions);
        test.run();

        int score = test.getScore();
        int totalQuestions = questions.length;
        System.out.println("Your score is " + score + "/" + totalQuestions);
    }
}
