package controllers;


import model.Car;
import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.ClientService;
import service.OrderService;

@Controller
public class OrderController
{

    @Autowired
    private ClientService clientService;

    @Autowired
    private CarService carService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
    public String makeOrder(@RequestParam int id, @AuthenticationPrincipal User user, Model model)
    {
        Client client = clientService.getByUsername(user.getUsername());
        Car car = carService.get(id);

        model.addAttribute(car);
        return "redirect:/";
    }
}
