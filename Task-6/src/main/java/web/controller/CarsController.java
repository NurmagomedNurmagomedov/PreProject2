package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/cars")
public class CarsController {

    private List<Car> cars;

    {
        cars = new ArrayList<Car>();
        cars.add(new Car("Chevrolet", "Red", "6.0", "Manual"));
        cars.add(new Car("Mercedes", "Black", "2.0", "Auto"));
        cars.add(new Car("Fiat", "Blue", "1.5", "Auto"));
        cars.add(new Car("Volkswagen", "White", "2.0", "Auto"));
        cars.add(new Car("Suzuki", "Red", "1.0", "Auto"));
        cars.add(new Car("Bugatti", "White", "8.0", "Auto"));
        cars.add(new Car("Ferrari", "Yellow", "6.0", "Manual"));
    }

    @GetMapping

    public String cars(Model model, @RequestParam(value = "count", required = false, defaultValue = "0") int cnt) {
        if (cnt == 0 || cnt > 5) cnt = cars.size();
        model.addAttribute("cars", cars.stream().limit(cnt));
        return "cars/index";
    }


}
