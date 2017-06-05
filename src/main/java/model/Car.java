package model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
    @Length(min = 3, max = 30, message = "Should be between 3 and 30 characters")
    private String company;

    @Column
    @Length(min = 3, max = 30, message = "Should be between 3 and 30 characters")
    private String model;

    @Column
    @Min(value = 1995, message = "Minimum value is 1995")
    @Max(value = 2017, message = "Maximum value is 2017")
    private int year;

    @Column
    @Min(value = 0, message = "Minimum value is 0")
    private double price;

    @Column
    private boolean enabled;

    @Transient
    private MultipartFile image;

    public MultipartFile getImage()
    {
        return image;
    }

    public void setImage(MultipartFile image)
    {
        this.image = image;
    }

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
        String str = company.trim();
        if (!str.isEmpty())
            this.company = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.company = "";
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        String str = model.trim();
        if (!str.isEmpty())
            this.model = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.model = "";
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

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
}
