package controllers;

import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CarService;
import service.ClientService;
import service.OrderService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private CarService carService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String adminPage(Model model)
    {
        model.addAttribute("list", carService.getAllAdmin());
        return "admin";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCar(Model model)
    {
        model.addAttribute(new Car());
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCar(@Valid Car car, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute(car);
            return "add";
        }
        car.setEnabled(true);

        carService.add(car);

        return "redirect:/admin/";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updateCar(@PathVariable int id,  Model model)
    {
        Car car = carService.get(id);
        if (car == null)
            return "redirect:/admin/";

        model.addAttribute(car);
        return "add";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateCar(@PathVariable int id, @Valid Car car, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute(car);
            return "add";
        }

        Car c = carService.get(id);

        c.setCompany(car.getCompany());
        c.setModel(car.getModel());
        c.setYear(car.getYear());
        c.setPrice(car.getPrice());
        c.setEnabled(true);
        carService.update(c);
        return "redirect:/admin/";
    }



    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCar(@PathVariable int id)
    {
        Car car = carService.get(id);
        carService.delete(car);
        return "redirect:/admin/";
    }


    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String clients(Model model)
    {
        model.addAttribute("list", clientService.getAll());
        return "clientList";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(Model model)
    {
        model.addAttribute("list", orderService.getAll());
        return "orderList";
    }

    @RequestMapping(value = "/enable/{id}", method = RequestMethod.GET)
    public String orders(@PathVariable int id)
    {
        Car car = carService.get(id);


        car.setEnabled(true);
        carService.update(car);

        return "redirect:/admin/";
    }
}
