import java.io.*;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("hw7/src/input.txt");
            FileWriter writer = new FileWriter("hw7/src/output.txt");

            processFile(reader, writer);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (CustomException e) {
            System.out.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void processFile(FileReader reader, FileWriter writer) throws IOException, CustomException {
        try (BufferedReader bufferedReader = new BufferedReader(reader);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при обработке файла: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println("Неизвестная ошибка: " + e.getMessage());
            throw new CustomException("Произошла ошибка при обработке файла.", e);
        }
    }
}

class CustomException extends Exception {
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}
