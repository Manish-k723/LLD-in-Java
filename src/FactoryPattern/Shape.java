package FactoryPattern;

public class Shape {
    public int counter = 0;
    public static int cnt = 0;
    ShapeFactory getShapeFactory(String shapeType){
        counter++;
        cnt++;
        switch (shapeType){
            case "Circle":
                return new Circle();
            case "Rectangle":
                return new Rectangle();
            case "Square":
                return new Square();
            default:
                return null;
        }
    }
    public int getCounter() {
        return counter;
    }
    public int getCnt() {
        return cnt;
    }
}
