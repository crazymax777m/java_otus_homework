import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        String[] questions = {"В каком году была основана Москва?",
                "Кто является создателем языка программирования Java?",
                "Сколько планет в Солнечной системе?"};

        String[][] options = {{"1147", "1220", "1453", "1789", "1917"},
                {"Билл Гейтс", "Джеймс Гослинг", "Линус Торвальдс", "Марк Цукерберг", "Илон Маск"},
                {"7", "8", "9", "10", "11"}};

        int[] answers = {0, 1, 1};

        int scoreRight = 0;
        int scoreWrong = 0;
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Вопрос " + (i + 1) + ": " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println((j + 1) + ". " + options[i][j]);
            }
            int userAnswer = input.nextInt();
            if (userAnswer - 1 == answers[i]) {
                scoreRight++;
            } else {
               scoreWrong++;
            }
        }

        System.out.println("Ваш результат:\n" + "Количество правильных ответов: " + scoreRight + "\nКоличество неправильных ответов: " + scoreWrong);
    }
}

