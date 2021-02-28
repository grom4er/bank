package bank.app.repository;

import javax.management.relation.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r FROM Role WHERE r.roleName = ?1")
    Optional<Role> getByName(String name);
}

