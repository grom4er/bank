package bank.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bank.app.model.Role;
import bank.app.repository.RoleRepository;
import bank.app.service.RoleService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class RoleTest {
    private final RoleService roleService;
    private final RoleRepository roleRepository;

    @Autowired
    RoleTest(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;
    }

    @AfterEach
    void tearDown() {
        roleRepository.deleteAll();
    }

    @Test
    public void saveTest() {
        Role roleAdmin = new Role();
        roleAdmin.setRoleName(Role.Roles.ADMIN);
        Role actualRole = roleService.save(roleAdmin);
        Role expectedRole = new Role();
        expectedRole.setId(1L);
        expectedRole.setRoleName(Role.Roles.ADMIN);
        assertEquals(expectedRole, actualRole);
    }

    @Test
    public void getByNameTest() {
        Role roleAdmin = new Role();
        roleAdmin.setRoleName(Role.Roles.ADMIN);
        Role expectedRole = roleService.save(roleAdmin);
        Role actualRole = roleService.getByName("ADMIN");
        assertEquals(expectedRole, actualRole);
    }
}
