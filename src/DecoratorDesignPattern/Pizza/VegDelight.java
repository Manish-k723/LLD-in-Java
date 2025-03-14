package DecoratorDesignPattern.Pizza;

public class VegDelight extends BasePizza {
    private final int COST = 200;
    @Override
    public int cost() {
        return COST;
    }
}
