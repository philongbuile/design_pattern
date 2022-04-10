package lect10_observer.game_example;

import java.util.ArrayList;
import java.util.List;

interface Character{
    public void addObservers(Observer observer);
    public void notifyAllObservers();
}
abstract class Observer{
    public abstract void update();
}
class Champion implements Character{
    private List<Observer> observers = new ArrayList<Observer>();
    protected String name;
    protected int health;
    protected int mana;
    public Champion(String name, int health, int mana){
        this.name = name;
        this.health = health;
        this.mana = mana;
    }
    public void addObservers(Observer observer){
       observers.add(observer); 
    }
    public void notifyAllObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
    public void normalAttack(Champion other_champion, int damage){
        System.out.println("Champion " + this.name + " attacks " + other_champion.name);
        other_champion.health -= damage;
        other_champion.notifyAllObservers();
    }
    public void finalAbility(Champion other_champion){
        System.out.println("Champion " + this.name + " uses final ability on " + other_champion.name);
        other_champion.health = other_champion.health/2;
        other_champion.notifyAllObservers();
    }
    public void healthBuff(Champion other_champion,int health){
        System.out.println("Champion " + this.name + " health buffs " + other_champion.name);
        other_champion.health += health;
        other_champion.notifyAllObservers();
    }


}
class NameObserver extends Observer{
    private Champion champion;
    public NameObserver(Champion champion){
        this.champion = champion;
        champion.addObservers(this);
    }
    public void update(){
        System.out.println("Name: " + champion.name);
    }
}
class HealthObserver extends Observer{
    private Champion champion;
    public HealthObserver(Champion champion){
        this.champion = champion;
        champion.addObservers(this);
    }
    public void update(){
        System.out.println("Health: " + champion.health);
        if(champion.health< 275){
            System.out.println("Champion " + champion.name + " is in danger");
        }
    }
}

class User{
    public static void main(String[] args){
        Champion ahri = new Champion("Ahri",550,300);
        NameObserver nameObserver = new NameObserver(ahri);
        HealthObserver healthObserver = new HealthObserver(ahri);
        Champion azir = new Champion("Azir",525,330);
        NameObserver nameObserver2 = new NameObserver(azir);
        HealthObserver healthObserver2 = new HealthObserver(azir);
        
        ahri.notifyAllObservers();
        azir.notifyAllObservers();
        ahri.normalAttack(azir,5);
        Champion sorakar = new Champion("Soraka",500,300);
        NameObserver nameObserver3 = new NameObserver(sorakar);
        HealthObserver healthObserver3 = new HealthObserver(sorakar);
        sorakar.healthBuff(azir, 15);
        azir.finalAbility(ahri);
        azir.normalAttack(ahri,20);

    }
}