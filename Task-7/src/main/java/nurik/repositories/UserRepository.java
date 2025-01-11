package nurik.repositories;

import nurik.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import nurik.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
