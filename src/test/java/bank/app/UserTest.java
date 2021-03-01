package bank.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import bank.app.model.User;
import bank.app.repository.UserRepository;
import bank.app.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
public class UserTest {
    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserTest(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void saveTest() {
        User user = new User();
        user.setPhoneNumber("+380");
        user.setName("User");
        userService.save(user);
        User getUserFromDB = userService.getByPhoneNumber("+380");
        assertEquals(getUserFromDB.getId(), 1L);
        assertEquals(getUserFromDB.getName(),"User");
        assertEquals(getUserFromDB.getPhoneNumber(), "+380");
    }
}
