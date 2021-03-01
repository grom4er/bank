package bank.app.service;

import bank.app.model.User;
import java.util.List;

public interface UserService {
    User save(User user);

    void delete(Long id);

    User update(User user);

    User getByPhoneNumber(String phoneNumber);
}
