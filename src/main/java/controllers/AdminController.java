package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CarService;
import service.ClientService;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private CarService carService;

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String adminPage(Model model)
    {
        model.addAttribute("list", carService.getAllAdmin());
        return "admin";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCar(Model model)
    {
        return "add";
    }
}
