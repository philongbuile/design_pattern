package prototype;

public class Client {
    public static void main(String[] args){
        Shape s;
        Factory f = Factory.getFactory();
        try {
            s = f.getInstance("Rectangle");
            s.showType();

            s = f.getInstance("Circle");
            s.showType();

            s = f.getInstance("Square");
            s.showType();
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }
}
