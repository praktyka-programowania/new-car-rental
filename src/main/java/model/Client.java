package model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.jboss.logging.annotations.LoggingClass;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "clients")
public class Client
{
    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private Integer id;

    @Column(name = "first_name")
    @Length(min = 3, max = 30, message = "Should be between 3 and 30 characters")
    private String firstName;

    @Column(name = "last_name")
    @Length(min = 3, max = 30, message = "Should be between 3 and 30 characters")
    private String lastName;

    @Column
    @Min(value = 0 ,message = "Minimum value is 0")
    private int age;

    @Column
    @Length(min = 3, max = 30, message = "Should be between 3 and 30 characters")
    @Email
    private String email;

    @Column
    @Length(min = 3, max = 30, message = "Should be between 3 and 30 characters")
    private String username;

    @Column
    @Length(min = 3, max = 50, message = "Should be between 3 and 50 characters")
    private String password;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;


    public Client()
    {
    }

    public Client(String firstName, String lastName, int age, String email, String username, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        String str = firstName.trim();
        if (!str.isEmpty())
            this.firstName = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.firstName = "";
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        String str = lastName.trim();
        if (!str.isEmpty())
            this.lastName = str.substring(0,1).toUpperCase() + str.substring(1);
        else
            this.lastName = "";
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Car getCar()
    {
        return car;
    }

    public void setCar(Car car)
    {
        this.car = car;
    }
}
