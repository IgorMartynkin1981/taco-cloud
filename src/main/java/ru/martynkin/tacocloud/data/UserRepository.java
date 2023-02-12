package ru.martynkin.tacocloud.data;
import org.springframework.data.repository.CrudRepository;
import ru.martynkin.tacocloud.User;


public interface UserRepository extends CrudRepository<User, Long> {

  User findByUsername(String username);
  
}
