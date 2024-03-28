import java.util.ArrayList;
import java.util.List;

public class ListCrudRepositoryImpl implements CrudRepository {
    List <User> users = new ArrayList<>();
    @Override
    public void save(Object element) {
        if (element instanceof User) {
            User user = (User) element;
            users.add(user);
            System.out.println("Пользователь успешно сохранен!");
        } else {
            System.err.println("Ошибка: переданный элемент не является пользователем");
        }
    }

    @Override
    public List findAll() {
        System.out.println("\nСписок пользователей:");
        for (User user : users) {
            System.out.println("Имя: " + user.getName() + ", Email: " + user.getEmail());
        }
        return null;
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
