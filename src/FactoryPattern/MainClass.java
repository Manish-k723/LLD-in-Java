package FactoryPattern;

public class MainClass {
    public static void main(String[] args) {
        Shape shape  = new Shape();
        Shape shape2  = new Shape();

        ShapeFactory circle = shape.getShapeFactory("Circle");
        circle.draw();
        System.out.println(shape.getCnt());
        System.out.println(shape.getCounter());
        ShapeFactory rectangle = shape2.getShapeFactory("Rectangle");
        rectangle.draw();
        System.out.println(shape2.getCnt());
        System.out.println(shape2.getCounter());


    }
}
