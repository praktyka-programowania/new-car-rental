package dao.impl;


import dao.ClientDao;
import model.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao
{
    @Autowired
    private SessionFactory session;

    public Client get(int id)
    {
        return (Client)session.getCurrentSession().get(Client.class, id);
    }

    @Override
    public Client getByUsername(String username)
    {
        return (Client) session.getCurrentSession().createQuery("from model.Client where username = ?")
                .setParameter(0, username)
                .uniqueResult();
    }

    @Override
    public Client getByEmail(String email)
    {
        return (Client) session.getCurrentSession().createQuery("from model.Client where email = ?")
                .setParameter(0, email)
                .uniqueResult();
    }

    public List<Client> getAll()
    {
        return session.getCurrentSession().createQuery("from model.Client").list();
    }

    public void add(Client client)
    {
        session.getCurrentSession().saveOrUpdate(client);
    }
}
