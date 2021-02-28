package bank.app.service;

import javax.management.relation.Role;

public interface RoleService {
    Role save(Role role);

    Role getByName(String roleName);
}
