package controllers;


import model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CarService;

import javax.validation.Valid;
import java.util.List;

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
    public String contact()
    {
        return "contact";
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
