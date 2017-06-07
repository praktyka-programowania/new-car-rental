package controllers;


import model.Car;
import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CarService;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.util.List;
import java.util.Properties;

@Controller
public class HomePageController
{
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage()
    {
        return "home";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about()
    {
        return "about";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactSend(Model model)
    {
        model.addAttribute(new Contact());
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contactAchieve(@Valid Contact contact, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute(contact);
            return "contact";
        }

        // Recipient's email ID needs to be mentioned.
        String to = "novitskiyandrew@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = contact.getEmail();

        // Assuming you are sending email from localhost
        String host = "localhost";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try
        {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(contact.getFirstName() + " " + contact.getLastName() + " contact");

            // Now set the actual message
            message.setText(contact.getMessage());

            // Send message
            Transport.send(message);
        }
        catch (Exception mex)
        {
            mex.printStackTrace();
        }


        model.addAttribute("message", "Your message was successfully sent");
        return "redirection";
    }



    @RequestMapping("/error")
    public String errorPage()
    {
        return "redirect:/";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchForm(Model model)
    {
        model.addAttribute("list", carService.getSortedList());
        model.addAttribute("car", new Car());
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@Valid Car car, BindingResult result, Model model)
    {
        List<Car> list = carService.search(car);
        if (list.isEmpty())
        {
            model.addAttribute("message", "There is no cars that match your expectations :(");
            return "redirection";
        }

        model.addAttribute("list", list);
        return "carList";
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public String deniedAccess(Model model)
    {
        model.addAttribute("message", "Access denied :(");
        return "redirection";
    }
}
