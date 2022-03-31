package prototype;

/* Factory should be in singleton */

import java.util.HashMap;

public class Factory {
    //Singleton implementation
    private static Factory f = null;
    private final HashMap<String, Shape> stock;
    private Factory()
    {
        stock = new HashMap<>();
        stock.put("Rectangle", new Rectangle());
        stock.put("Circle", new Circle());
        stock.put("Square", new Square());
    }

    public static Factory getFactory()
    {
        if(f == null)
        {
            synchronized (Factory.class)
            {
                if(f == null)
                {
                    f = new Factory();
                }
            }
        }
        return f;
    }

    public Shape getInstance(String option) throws CloneNotSupportedException {
        Shape s =  stock.get(option);
        return (Shape) s.clone();
    }
}
