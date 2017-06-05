package model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Column
    private Date date;

    @Column(name = "returning_date")
    private Date returningDate;

    public Order()
    {
    }

    public Order(Client client, Car car, Date date, Date returningDate)
    {
        this.client = client;
        this.car = car;
        this.date = date;
        this.returningDate = returningDate;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public Car getCar()
    {
        return car;
    }

    public void setCar(Car car)
    {
        this.car = car;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public Date getReturningDate()
    {
        return returningDate;
    }

    public void setReturningDate(Date returningDate)
    {
        this.returningDate = returningDate;
    }
}
