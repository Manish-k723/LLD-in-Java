package DecoratorDesignPattern.Toppings;

import DecoratorDesignPattern.Pizza.BasePizza;

public class Mushroom extends ToppingDecorator{
    BasePizza pizza;

    public Mushroom(BasePizza pizza){
        this.pizza = pizza;
    }

    public int cost(){
        return this.pizza.cost() + 40;
    }
}
