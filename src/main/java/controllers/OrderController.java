package controllers;


import model.Car;
import model.Client;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;
import service.ClientService;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/order")
public class OrderController
{

    @Autowired
    private ClientService clientService;

    @Autowired
    private CarService carService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String makeOrder(@PathVariable int id, HttpServletRequest request, @RequestParam String calendar, Model model) throws ParseException
    {
        Client client = clientService.getByUsername(request.getRemoteUser());
        Car car = carService.get(id);
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(calendar);

        long difference = (date.getTime() - new Date().getTime()) / (60 * 60 * 1000);

        model.addAttribute(car);
        model.addAttribute(client);
        model.addAttribute("date", new SimpleDateFormat("dd/MM/yyyy").format(date));
        model.addAttribute("price", Math.round((car.getPrice() / 30 / 24 * difference) * 100) / 100.0d);


        return "confirm";
    }


    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String makeOrder(@RequestParam(name = "client_id") int clientId, @RequestParam(name = "car_id") int carId, @RequestParam(name = "date") String date, @RequestParam(name = "price") double price, Model model) throws ParseException
    {
        Client client = clientService.get(clientId);
        Car car = carService.get(carId);
        Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        Order order = new Order(client, car, new Date(), dt, price);

        orderService.add(order);


        car.setEnabled(false);
        carService.update(car);


        client.setCar(car);
        clientService.add(client);

        model.addAttribute("message", "Thank you for making a purchase!");
        return "redirection";
    }

}
