package model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Contact
{

    @NotBlank
    @Length(min = 3, max = 30, message = "Should be between 3 and 30 characters")
    private String firstName;


    @NotBlank
    @Length(min = 3, max = 30, message = "Should be between 3 and 30 characters")
    private String lastName;


    @NotBlank
    @Length(min = 3, max = 30, message = "Should be between 3 and 30 characters")
    @Email
    private String email;


    @NotBlank
    @Length(min = 5, message = "Should contain at least 5 characters")
    private String message;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
