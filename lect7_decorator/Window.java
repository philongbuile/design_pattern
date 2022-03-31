package lect7_decorator;

public interface Window{
    public void draw();
}
class simpleWindow implements Window{
    public void draw(){
        System.out.print("simple window");
    }
}
abstract class Decorator implements Window{
    protected Window window;
    public Decorator(Window window){
        this.window = window;
    }
    public void draw(){
        window.draw();
    }
}
class vertical_borderWindow extends Decorator{
    public vertical_borderWindow(Window window){
        super(window);
    }
    @Override
    public void draw(){
        super.draw();
        System.out.print(", with vertical border");
    }
}
class horizontal_borderWindow extends Decorator{
    public horizontal_borderWindow(Window window){
        super(window);
    }
    @Override
    public void draw(){
        super.draw();
        System.out.print(", with horizontal border");
    }
}

class Client{
    public static void main(String[] args){
        Window window = new horizontal_borderWindow(new vertical_borderWindow(new simpleWindow()));
        window.draw();

    }
}
