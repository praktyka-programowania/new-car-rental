package controllers;


import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ClientController
{

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public String clientCart(HttpServletRequest request, Model model)
    {
        List<Order> list = orderService.getForUser(request.getRemoteUser());
        model.addAttribute("list", list);
        return "clientCart";
    }
}
