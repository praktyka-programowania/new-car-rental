package model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @NotBlank
    @Length(min = 3, max = 30)
    private String company;

    @Column
    @Length(min = 3, max = 30)
    private String model;

    @Column
    @Min(1995)
    @Max(2017)
    private int year;

    @Column
    @Min(0)
    private double price;

    @Column
    private boolean enabled;

    @Column(name = "returning_date")
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

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
