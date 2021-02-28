package bank.app.repository;

import bank.app.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.id = ?1")
    Optional<User> getUserById(Long id);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.phoneNumber = ?1")
    Optional<User> getByPhoneNumber(String phoneNumber);
}
