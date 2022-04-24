package lect12_.second_visitor_implement;

import java.util.ArrayList;

abstract class ComputerPart {
    public int level=0;
    public int id=0;
    public abstract void accept(ComputerVisitor visitor);
}
class Mouse extends ComputerPart {
    public void accept(ComputerVisitor visitor){
        visitor.visit(this);
    }
}
class Keyboard extends ComputerPart {
    public void accept(ComputerVisitor visitor){
        visitor.visit(this);
    }
}
class Monitor extends ComputerPart {
    public void accept(ComputerVisitor visitor){
        visitor.visit(this);
    }
}
class Computer extends ComputerPart{
    public ArrayList<ComputerPart> list_of_parts = new ArrayList<ComputerPart>();
    public void accept(ComputerVisitor visitor){
        visitor.visit(this);
    }
    public void addParts(ComputerPart part){
        list_of_parts.add(part);
    }
    
}
class MouseBT extends ComputerPart{
    public void accept(ComputerVisitor visitor){
        visitor.visit(this);
    }
}

//Visitor
interface ComputerVisitor{
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);
    public void visit(Computer computer);
    public void visit(MouseBT mousebt);
}
class AssignComputerVisitor implements ComputerVisitor{
    int base_id=0;
    int base_level=0;
    public void visit(Mouse mouse){
        mouse.id=base_id++;
    }

    @Override
    public void visit(Keyboard keyboard) {
        // TODO Auto-generated method stub
        keyboard.id=base_id++;
    }

    @Override
    public void visit(Monitor monitor) {
        // TODO Auto-generated method stub
        monitor.id=base_id++;
    }

    @Override
    public void visit(Computer computer) {
        // TODO Auto-generated method stub
        computer.id=base_id++;
        for(ComputerPart part: computer.list_of_parts){
            part.level=base_level+1;
        }
        this.base_level++;
        this.base_id=0;
        for(ComputerPart part: computer.list_of_parts){
            part.accept(this);
        }

        
        
        
        
    }

    @Override
    public void visit(MouseBT mousebt) {
        // TODO Auto-generated method stub
        
    }
    
}
class DisplayComputerVisitor implements ComputerVisitor{
    
    public void printLevel(ComputerPart part){
        for(int i = 0 ; i<part.level;i++){
            System.out.print("----");
        }
    }
    public void visit(Mouse mouse){
        printLevel(mouse);
        System.out.println("Mouse: "+mouse.level+"."+mouse.id);
    }
    public void visit(Keyboard keyboard){
        printLevel(keyboard);
        System.out.println("Keyboard: "+keyboard.level+"."+keyboard.id);
    }
    public void visit(Monitor monitor){
        printLevel(monitor);
        System.out.println("Monitor: "+monitor.level+"."+monitor.id);
    }
    public void visit(Computer computer){
        printLevel(computer);
        System.out.println("Computer: "+computer.level+"."+computer.id);
        for(ComputerPart part:computer.list_of_parts){
            part.accept(this);
        }
    }
    @Override
    public void visit(MouseBT mousebt) {
        // TODO Auto-generated method stub
        printLevel(mousebt);
        System.out.println("Bluetooth mouse: "+mousebt.level+"."+mousebt.id);
    }
}
class ReplaceMouseVisitor implements ComputerVisitor{
    private boolean flag = false;
    public void visit(){}
    @Override
    public void visit(Mouse mouse) {
        // TODO Auto-generated method stub
        this.flag=true;
        
    }
    @Override
    public void visit(Keyboard keyboard) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void visit(Monitor monitor) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void visit(Computer computer) {
        // TODO Auto-generated method stub
        for(int i = 0; i <computer.list_of_parts.size();i++){
            computer.list_of_parts.get(i).accept(this);
            if(this.flag == true){
                computer.list_of_parts.set(i,new MouseBT());
                this.flag = false;
            }
        }
        
    }
    @Override
    public void visit(MouseBT mousebt) {
        // TODO Auto-generated method stub
        
    }

}

//client
class Client{
    public static void main(String[] args){
        Computer computer = new Computer();
        Keyboard keyboard = new Keyboard();
        Monitor monitor = new Monitor();
        Mouse mouse = new Mouse();
        
        computer.addParts(mouse);
        computer.addParts(monitor);
        computer.addParts(keyboard);

        Computer computer2 = new Computer();
        Keyboard keyboard2 = new Keyboard();
        Monitor monitor2 = new Monitor();
        Mouse mouse2 = new Mouse();
        Computer computer3 = new Computer();
        Keyboard keyboard3 = new Keyboard();
        Monitor monitor3 = new Monitor();
        computer3.addParts(keyboard3);
        computer3.addParts(monitor3);

        computer2.addParts(computer3);
        computer2.addParts(keyboard2);
        computer2.addParts(mouse2);
        computer2.addParts(monitor2);

         

        computer.addParts(computer2);
        
        

        DisplayComputerVisitor display_visitor = new DisplayComputerVisitor();
        AssignComputerVisitor assign_visitor = new AssignComputerVisitor();
        ReplaceMouseVisitor replace_mouse_visitor = new ReplaceMouseVisitor();

        
        // replace_mouse_visitor.visit(computer);
        // assign_visitor.visit(computer);
        // display_visitor.visit(computer);
        computer.accept(replace_mouse_visitor);
        computer.accept(assign_visitor);
        computer.accept(display_visitor);



       



        
    }
}

