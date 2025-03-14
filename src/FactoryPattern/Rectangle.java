package FactoryPattern;

public class Rectangle implements ShapeFactory{
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
