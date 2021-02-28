package bank.app.service.impl;

import javax.management.relation.Role;
import bank.app.exception.UserException;
import bank.app.repository.RoleRepository;
import bank.app.service.RoleService;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public Role getByName(String roleName) {
        return repository.getByName(roleName).orElseThrow(
                () -> new UserException((String.format("Can't take role by name %s", roleName))));
    }
}
