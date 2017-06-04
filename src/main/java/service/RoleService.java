package service;

import model.Role;

public interface RoleService
{
    Role get(int id);
    void add(Role role);
}
