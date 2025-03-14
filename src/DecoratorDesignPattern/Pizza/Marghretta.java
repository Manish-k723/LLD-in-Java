package DecoratorDesignPattern.Pizza;

public class Marghretta extends BasePizza {
    private final int COST = 100;

    public int cost(){
        return COST;
    }
}
