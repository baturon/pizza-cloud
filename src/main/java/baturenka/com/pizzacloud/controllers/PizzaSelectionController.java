package baturenka.com.pizzacloud.controllers;

import baturenka.com.pizzacloud.Pizza;
import baturenka.com.pizzacloud.PizzaOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/selection")
@SessionAttributes("pizzaOrder")
public class PizzaSelectionController {
    @ModelAttribute
    public void addPizzaToModel(Model model) {
        List<Pizza> pizzaList = Arrays.asList(
                new Pizza(1,"Маргарита",450,15),
                new Pizza(2,"Четыре сыра",430,16),
                new Pizza(3,"Капричоза",470,19),
                new Pizza(4,"Гавайская",500,21)
        );
        model.addAttribute(pizzaList.stream()
                .collect(Collectors.toList()));

    }
    @ModelAttribute(name = "pizzaOrder")
    public PizzaOrder order() {
        return new PizzaOrder();
    }

    @ModelAttribute("pizza")
    public Pizza pizza() {
        return new Pizza();
    }

    @GetMapping
    public String showSelectionForm() {
        return "selection";
    }

    @PostMapping
    public String processPizza(Pizza pizza,
                               @ModelAttribute PizzaOrder pizzaOrder) {


        pizzaOrder.addPizza(pizza);
        log.info("Processing pizza: {}", pizza);
        return "redirect:/orders/current";
    }


}