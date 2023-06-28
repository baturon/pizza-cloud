package baturenka.com.pizzacloud;


import java.util.List;
import java.util.ArrayList;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data

public class PizzaOrder {
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;
    @NotBlank(message = "Street is required")
    private String deliveryStreet;
    @NotBlank(message = "City is required")
    private String deliveryCity;
    @NotBlank(message = "Telephone number is required")
    private String deliveryTelNumber;
    @NotBlank(message = "email is required")
    private String deliveryEmail;

    private List<Pizza> pizzas = new ArrayList<>();


    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }
}