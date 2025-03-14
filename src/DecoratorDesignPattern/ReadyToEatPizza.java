package DecoratorDesignPattern;

import DecoratorDesignPattern.Pizza.BasePizza;
import DecoratorDesignPattern.Pizza.VegDelight;
import DecoratorDesignPattern.Toppings.ExtraCheese;
import DecoratorDesignPattern.Toppings.Mushroom;

public class ReadyToEatPizza {

    public static void main(String[] args) {
        BasePizza pizza = new Mushroom(new ExtraCheese(new VegDelight()));
        System.out.println(pizza.cost());
    }
}
