package controllers;


import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController
{
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAll(Model model)
    {
        List<Car> list = carService.getAll();
        if (list.isEmpty())
        {
            model.addAttribute("message", "There is no available car for you :(");
            return "redirection";
        }

        model.addAttribute("list", list);
        return "carList";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable int id, Model model)
    {
        Car car = carService.get(id);
        if (car == null)
        {
            model.addAttribute("message", "There is no available car for you :(");
            return "redirection";
        }

        model.addAttribute("car", car);
        return "carView";
    }

}
