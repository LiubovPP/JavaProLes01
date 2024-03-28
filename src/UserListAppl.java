import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//написать программу которая позволяет пользователю ввечти список User и созраняет это список в List.
// программа должна проверять корректность данных на
//- имя пользователя не пустая строка
//- email не пустая строка содержащая @


//после решения задачи, модифицировать программу таким образом, чтоб пользователи сохранялись в текстовый файл:
//john;john@mail.com
//jack;jack@mail.com

// вариант с урока
public class UserListAppl {
    public static void main(String[] args) {

    List <User> users = new ArrayList<>();
    Scanner scanner= new Scanner(System.in);
        long counter=0;
        while (true) {
            System.out.print("Введите имя пользователя (или 'exit' для выхода): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Введите адрес электронной почты: ");
            String email = scanner.nextLine();

            // Проверка корректности введенных данных
            if (name.trim().isEmpty()) {
                System.out.println("Имя пользователя не может быть пустым. Попробуйте снова.");
                continue;
            }

            if (!email.contains("@") || email.trim().isEmpty()) {
                System.out.println("Некорректный адрес электронной почты. Попробуйте снова.");
                continue;
            }

            // Создание объекта User и добавление его в список
            User user = new User(++counter, name, email);
            users.add(user);
            System.out.println("Пользователь успешно добавлен!\n");
        }

        System.out.println("\nСписок пользователей:");
        for (User user : users) {
            System.out.println("Имя: " + user.getName() + ", Email: " + user.getEmail());
        }


        // Сохранение пользователей в файл
        saveUsersToFile(users);

        System.out.println("\nСписок пользователей сохранен в файле 'users.txt'.");
    }

    private static void saveUsersToFile(List<User> users) {
        try (FileWriter writer = new FileWriter("users.txt")) {
            for (User user : users) {
                writer.write(user.getName() + ";" + user.getEmail() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}