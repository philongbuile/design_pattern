package lect10_observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface ILineSource{
    public void addObserver(LineObserver observer);
    public void setLine();
    public void notifyAllObservers();
}
abstract class  LineObserver{
    abstract public void update();
}
class SubjectLineSource implements ILineSource{
    private List<LineObserver> observers = new ArrayList<LineObserver>();
    protected String line="none";
    protected int index = 0;
    public void addObserver(LineObserver observer){
        observers.add(observer);
    }
    public void setLine(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){

            this.index++;
            line = scanner.nextLine();
            notifyAllObservers();
        }
        scanner.close();
    }
    public void notifyAllObservers(){
        for(LineObserver observer : observers){
            observer.update();
        }
    }
}
class ObserverLineDisplay extends LineObserver{
    private SubjectLineSource subject;
    public ObserverLineDisplay(SubjectLineSource subject){
        this.subject = subject;
        subject.addObserver(this);
    }
    @Override
    public void update(){
        System.out.println(Integer.toString(subject.index)+ "-  Line: " + subject.line);
    }
}
class ObserverLineCharCount extends LineObserver{
    private SubjectLineSource subject;
    public ObserverLineCharCount(SubjectLineSource subject){
        this.subject = subject;
        subject.addObserver(this);
    }
    @Override
    public void update(){
        System.out.println(Integer.toString(subject.index)+ "-  Number of characters: " + subject.line.length());
    }
}
class ObserverUppercaseLineDisplay extends LineObserver{
    private SubjectLineSource subject;
    public ObserverUppercaseLineDisplay(SubjectLineSource subject){
        this.subject = subject;
        subject.addObserver(this);
    }
    @Override
    public void update(){
        System.out.println(Integer.toString(subject.index)+ "-  Uppercase line: " + subject.line.toUpperCase());
    }
}
// abstract class LineDisplayObserver{
//     public abstract void update();
// }
// class LineDisplayObserverInstnace extends LineDisplayObserver{
//     private LineObserver subject;
//     public LineDisplayObserverInstnace(LineObserver subject){
//         this.subject = subject;
//     }
//     @Override
//     public void update(){
//         System.out.print("Index: " + subject.index);
//     }
// }



class Client{
    public static void main(String[] args){
        SubjectLineSource subject = new SubjectLineSource();
        new ObserverLineDisplay(subject);
        new ObserverLineCharCount(subject);
        new ObserverUppercaseLineDisplay(subject);
        subject.setLine();
    }
}