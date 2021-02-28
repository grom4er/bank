package bank.app.service;


import bank.app.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String roleName);
}
