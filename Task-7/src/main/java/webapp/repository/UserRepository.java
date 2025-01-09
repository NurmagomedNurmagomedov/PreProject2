package webapp.repository;

import jakarta.data.repository.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import webapp.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll(int count) {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                .getResultList()
                .stream()
                .limit(count)
                .collect(Collectors.toList());
    }

    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    public User update(User user) {
        return entityManager.merge(user);
    }

    public void delete(User user) {
        entityManager.remove(user);
    }
}
