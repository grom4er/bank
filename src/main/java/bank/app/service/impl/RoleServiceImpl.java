package bank.app.service.impl;

import bank.app.exceptions.NoSuchEntityException;
import bank.app.model.Role;
import bank.app.repository.RoleRepository;
import bank.app.service.RoleService;
import org.springframework.stereotype.Service;

@Service
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
        return repository.getByRoleName(Role.Roles.valueOf(roleName))
               .orElseThrow(() -> new NoSuchEntityException((
                       String.format("Can't take role by name %s", roleName))));
    }
}
