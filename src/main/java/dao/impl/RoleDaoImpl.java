package dao.impl;


import dao.RoleDao;
import model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao
{
    @Autowired
    private SessionFactory session;

    @Override
    public Role get(int id)
    {
        return (Role) session.getCurrentSession().createQuery("from model.Role where client_id = ?")
                .setParameter(0, id)
                .uniqueResult();
    }

    @Override
    public void add(Role role)
    {
        session.getCurrentSession().save(role);
    }
}
