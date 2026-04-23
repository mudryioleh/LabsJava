import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import service.FileContentReader;
import service.FileCreator;
import service.RandomNumberFileWriter;

public class App {

    private static final int DEFAULT_COUNT = 10;

    public static void main(String[] args) {
        String fileName;
        int b1;
        int b2;
        int count = DEFAULT_COUNT;

        if (args.length == 1) {
            fileName = args[0];
            readOnly(fileName);
            return;
        }

        if (args.length == 0) {
            InputData inputData = readInputFromConsole();
            fileName = inputData.fileName;
            b1 = inputData.b1;
            b2 = inputData.b2;
        } else if (args.length == 3) {
            fileName = args[0];

            try {
                b1 = Integer.parseInt(args[1]);
                b2 = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Помилка: b1 та b2 мають бути цілими числами.");
                printUsageAndExit();
                return;
            }
        } else {
            printUsageAndExit();
            return;
        }

        if (count <= 0) {
            System.err.println("Помилка: кількість чисел має бути > 0.");
            System.exit(1);
        }

        if (b1 > b2) {
            System.err.println("Помилка: b1 має бути <= b2.");
            System.exit(1);
        }

        File file = new File(fileName);
        try {
            FileCreator fileCreator = new FileCreator();
            RandomNumberFileWriter randomNumberFileWriter = new RandomNumberFileWriter();
            FileContentReader fileContentReader = new FileContentReader();

            fileCreator.ensureFileExists(file);
            randomNumberFileWriter.writeRandomNumbers(file, b1, b2, count);

            System.out.println("Записано " + count + " випадкових чисел у файл: " + file.getPath());
            System.out.println("Вміст файлу:");
            System.out.print(fileContentReader.readAll(file));
        } catch (IOException e) {
            System.err.println("Помилка вводу/виводу: " + e.getMessage());
            System.exit(1);
        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void readOnly(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.err.println("Файл не знайдено: " + file.getPath());
            System.exit(1);
        }

        try {
            FileContentReader fileContentReader = new FileContentReader();
            System.out.println("Вміст файлу:");
            System.out.print(fileContentReader.readAll(file));
        } catch (IOException e) {
            System.err.println("Помилка вводу/виводу: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void printUsageAndExit() {
        System.out.println("Використання:");
        System.out.println("  java -cp bin App <ім'я_файлу.txt>          (лише читання)");
        System.out.println("  java -cp bin App <ім'я_файлу.txt> <b1> <b2>");
        System.out.println("  або просто: java -cp bin App  (далі введення з консолі)");
        System.out.println("Приклад:");
        System.out.println("  java -cp bin App numbers.txt 5 20");
        System.out.println("Примітка: програма генерує " + DEFAULT_COUNT + " чисел.");
        System.exit(1);
    }

    private static InputData readInputFromConsole() {
        try (Scanner scanner = new Scanner(System.in)) {
            String fileName;
            while (true) {
                System.out.print("Введіть ім'я файлу (наприклад, numbers.txt): ");
                fileName = scanner.nextLine().trim();
                if (!fileName.isEmpty()) {
                    break;
                }
                System.out.println("Ім'я файлу не може бути порожнім.");
            }

            int b1 = readInt(scanner, "Введіть b1: ");
            int b2 = readInt(scanner, "Введіть b2: ");
            return new InputData(fileName, b1, b2);
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Будь ласка, введіть ціле число.");
            }
        }
    }

    private static final class InputData {
        final String fileName;
        final int b1;
        final int b2;

        InputData(String fileName, int b1, int b2) {
            this.fileName = fileName;
            this.b1 = b1;
            this.b2 = b2;
        }
    }
}
