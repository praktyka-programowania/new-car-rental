package model;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role
{
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private Authority role;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Role()
    {
    }

    public Role(Authority role, Client client)
    {
        this.role = role;
        this.client = client;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Authority getRole()
    {
        return role;
    }

    public void setRole(Authority role)
    {
        this.role = role;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }
}
