package lect5_prototype_objectcloning;

import java.util.HashMap;

class Shape implements Cloneable {
    protected String type="none";
    public void getType() {
        System.out.println("This is "+this.type);
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
class Circle extends Shape{
    public Circle(){
        this.type = "Circle";
    }
}
class Square extends Shape{
    public Square(){
        this.type = "Square";
    }
}
class Rectangle extends Shape{
    public Rectangle(){
        this.type = "Rectangle";
    }
}
class ShapeFactory{
    private final HashMap<String, Shape> stock;
    private static ShapeFactory factory_instance=null;
    private ShapeFactory(){
        stock = new HashMap<>();
        stock.put("Circle", new Circle());
        stock.put("Square", new Square());
        stock.put("Rectangle", new Rectangle());
    }
    public static ShapeFactory getInstance(){
        if(factory_instance==null)
        {
            synchronized(ShapeFactory.class){
                if(factory_instance==null){
                    factory_instance = new ShapeFactory();
                }
            }
        }
        return factory_instance;
    }
    public Shape getShape(String type) throws CloneNotSupportedException{
        Shape new_shape = stock.get(type);
        return (Shape) new_shape.clone();
    }

}
class CLient{
    public static void main(String[] args){
        //Shape s = new Square();
        //Shape s = new Circle();
        //Shape s = new Rectangle();
        Shape s;
        ShapeFactory factory = ShapeFactory.getInstance();
        try{
            s = factory.getShape("Circle");
            s.getType();

            s=factory.getShape("Rectangle");
            s.getType();

            s = factory.getShape("Square");
            s.getType();
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }


    }
}

