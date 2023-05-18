import java.io.*;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("C:\\Users\\Maxim\\Desktop\\otus_java_course\\hw7\\src\\input.txt");
            FileWriter writer = new FileWriter("C:\\Users\\Maxim\\Desktop\\otus_java_course\\hw7\\src\\output.txt");

            processFile(reader, writer);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }

    public static void processFile(FileReader reader, FileWriter writer) throws IOException {
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
        }
    }
}

