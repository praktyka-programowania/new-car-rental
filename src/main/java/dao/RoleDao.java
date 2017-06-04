package dao;


import model.Role;

public interface RoleDao
{

    Role get(int id);
    void add(Role role);
}
