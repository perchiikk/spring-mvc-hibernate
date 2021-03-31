package hiber.controller;


import hiber.model.Car;
import hiber.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("cars")
public class HelloController {
    CarService carService;

    @Autowired
    public HelloController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String sayHello(Model model){
        model.addAttribute("cars", carService.getCars());
        return "hello";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("car", carService.getCarById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newCar(Model model){
        model.addAttribute("car", new Car());
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "new";
        carService.add(car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("car", carService.getCarById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("car") @Valid Car car, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        carService.update(car);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        carService.delete(id);
        return "redirect:/cars";
    }
}
