package PhoneBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBookProgram {
    public static void run() {
        System.out.println("---- PhoneBook ----");

        HashMap<String, String> phoneBook = new HashMap<>();

        phoneBook.put("Іваненко", "+380501112233");
        phoneBook.put("Петренко", "+380671234567");
        phoneBook.put("Шевченко", "+380931111111");
        phoneBook.put("Коваленко", "+380661234111");
        phoneBook.put("Бондар", "+380981234999");
        phoneBook.put("Мельник", "+380631112244");
        phoneBook.put("Ткаченко", "+380991234567");
        phoneBook.put("Мороз", "+380731234000");
        phoneBook.put("Поліщук", "+380681234321");
        phoneBook.put("Савченко", "+380951234888");

        System.out.println("Вміст книги:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        Scanner scanner = new Scanner(System.in);

        String lastName = readNonEmptyLine(scanner, "Введіть прізвище для пошуку: ");

        if (phoneBook.containsKey(lastName)) {
            String phone = phoneBook.get(lastName);
            System.out.println("Номер для \"" + lastName + "\": " + phone);
        } else {
            System.out.println("У книзі відсутній такий абонент");
        }

        String phoneToCheck = readPhoneNumber(scanner, "Введіть номер, щоб перевірити чи він є в книзі: ");
        System.out.println("containsValue(" + phoneToCheck + ") = " + phoneBook.containsValue(phoneToCheck));

        String keyToRemove = phoneBook.keySet().iterator().next();
        String removedValue = phoneBook.remove(keyToRemove);
        System.out.println("Видалено запис: " + keyToRemove + " -> " + removedValue);

        System.out.println("Кількість записів у книзі: " + phoneBook.size());

        System.out.println("containsKey(\"" + keyToRemove + "\") = " + phoneBook.containsKey(keyToRemove));
    }

    private static String readNonEmptyLine(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Помилка: введіть непорожнє значення.");
        }
    }

    private static String readPhoneNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Помилка: номер не може бути порожнім.");
                continue;
            }

            if (input.matches("\\+?\\d{10,15}")) {
                return input;
            }

            System.out.println("Помилка: введіть номер лише цифрами (можна з '+'), без букв.");
        }
    }
}
