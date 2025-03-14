package FactoryPattern;

public class Circle implements ShapeFactory {

    @Override
    public void draw(){
        System.out.println("Drawing Circle");
    }
}
