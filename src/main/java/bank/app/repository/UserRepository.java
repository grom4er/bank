package bank.app.repository;

import bank.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.id = ?1")
    User getOne(Long id);

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.phoneNumber = ?1")
    User getByPhoneNumber(String phoneNumber);
}
