package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cars")
public class Car
{
    @Id
    @GeneratedValue
    @Column(name = "car_id")
    private Integer id;

    @Column
    private String company;

    @Column
    private String model;

    @Column
    private int year;

    @Column
    private boolean enabled;

    @Column
    private Date returningDate;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setEnabled(boolean enabled)
    {
        this.enabled = enabled;
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
