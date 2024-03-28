import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCrudRepositoryImpl implements CrudRepository{
    private List <User> users = new ArrayList<>();
    @Override
    public void save(Object element) {
        if (element instanceof User) {
            User user = (User) element;
            users.add(user);
            saveToFile();
            System.out.println("Пользователь успешно сохранен!");
        } else {
            System.err.println("Ошибка: переданный элемент не является пользователем");
        }
    }

    @Override
    public List<User> findAll() {
        // Возвращаем список пользователей
        return users;
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter("users.txt")) {
            for (User user : users) {
                writer.write(user.getName() + ";" + user.getEmail() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    @Override
    public Object findByID(Long id) {
        return null;
    }

    @Override
    public void update(Object element) {

    }

    @Override
    public void deleteByID(Long id) {

    }
}
