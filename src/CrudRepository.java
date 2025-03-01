import java.util.List;

    // будет отвечать за CRUD, только будем менять реализацию
    public interface CrudRepository<T> { // create read update delete
        void  save(T element);
        List<T> findAll();
        T findByID(Long id);

        void update(T element);
        void  deleteByID(Long id);
    }