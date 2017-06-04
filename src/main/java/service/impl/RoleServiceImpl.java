package service.impl;


import dao.RoleDao;
import model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.RoleService;

@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role get(int id)
    {
        return roleDao.get(id);
    }

    @Override
    public void add(Role role)
    {
        roleDao.add(role);
    }
}
