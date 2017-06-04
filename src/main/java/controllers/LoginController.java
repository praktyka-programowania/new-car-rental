package controllers;


import model.Authority;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ClientService;
import service.RoleService;

import model.Role;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController
{

    @Autowired
    private ClientService clientService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(required = false, name = "error") String error, Model model, HttpServletRequest request)
    {
        if (error != null)
        {
            model.addAttribute("message", "Invalid credencials");
            return "login";
        }
        if (request.getRemoteUser() == null)
            return "login";
        else
            return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request)
    {
        if (request.getRemoteUser() != null)
            return "redirect:/j_spring_security_logout";
        else
            return "redirect:/";
    }

    @RequestMapping(value = "/singup", method = RequestMethod.GET)
    public String singup(HttpServletRequest request, Model model)
    {
        if (request.getRemoteUser() != null)
            return "redirect:/";

        model.addAttribute(new Client());
        return "singup";
    }

    @RequestMapping(value = "/singup", method = RequestMethod.POST)
    public String singup(@Valid Client client, BindingResult result, @RequestParam String pass, Model model)
    {
        if (result.hasErrors())
        {
            client.setEmail("");
            client.setUsername("");
            client.setPassword("");
            model.addAttribute(client);
            return "singup";
        }

        if (!client.getPassword().equals(pass))
        {
            client.setEmail("");
            client.setUsername("");
            client.setPassword("");
            result.rejectValue("password", "error.object","Different passwords provided");
            model.addAttribute(client);
            return "singup";
        }

        Client c = clientService.getByEmail(client.getEmail());
        if (c != null)
        {
            client.setEmail("");
            client.setUsername("");
            client.setPassword("");
            result.rejectValue("email", "error.object","Email already exists");
            model.addAttribute(client);
            return "singup";
        }


        c = clientService.getByUsername(client.getUsername());
        if (c != null)
        {
            client.setEmail("");
            client.setUsername("");
            client.setPassword("");
            result.rejectValue("username", "error.object","Username already exists");
            model.addAttribute(client);
            return "singup";
        }

        client.setPassword(encoder.encode(client.getPassword()));
        clientService.add(client);
        Role role = new Role(Authority.ROLE_USER, client);
        roleService.add(role);
        model.addAttribute("message", "You are successfully singed up :)");
        return "redirection";
    }
}
