package bank.app.service.impl;

import bank.app.exceptions.UserException;
import bank.app.model.User;
import bank.app.repository.UserRepository;
import bank.app.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        return repository.getUserById(id)
                .orElseThrow(() -> new UserException("Can't find user by id " + id));
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User getByPhoneNumber(String phoneNumber) {
        return repository.getByPhoneNumber(phoneNumber).orElseThrow(() -> new UserException(
                        "Can't take user by phone number " + phoneNumber));
    }
}
