package prototype;

public abstract class Shape implements Cloneable {
    String type;
    public void showType()
    {
        System.out.printf("This is a %s%n", type);
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
