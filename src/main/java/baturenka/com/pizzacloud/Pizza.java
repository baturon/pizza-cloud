package baturenka.com.pizzacloud;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Pizza {

    private int id;
    private String name;
    private int weight;
    private int price;

    public Pizza(int id, String name, int weight, int price) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Pizza() {

    }

    @Override
    public String toString() {
        return "пицца " + "\"" + name + "\"" + ", " + weight + " гр., " + price + " руб. ";
    }
}
