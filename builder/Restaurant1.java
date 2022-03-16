package lect3_builder.product;

import java.util.Vector;
class Item{
    private String name;
    private float price;
    public Item(String name, int price){
        this.name = name;
        this.price= price;
    }
    public String getName(){
        return this.name;
    }
    public float getPrice(){
        return this.price;
    }
    public void changePrice(float discount){
        this.price=(float) (discount*this.price);
    }
}

class Restaurant1 {
    private Vector<Item> list_of_items = new Vector<Item>();
    private float SumOfPrice=0;


    public Restaurant1(){};
    public void addItem(Item item){
        list_of_items.add(item);
    }
    public String getItemName(int index){
        return list_of_items.get(index).getName();
    }
     
    
    public float getPrice(){
        for(int i = 0 ; i < list_of_items.size() ; i++)
        {
            this.SumOfPrice += list_of_items.get(i).getPrice();

        }
        return this.SumOfPrice;
    }
    

}
interface MealBuilder{

    MealBuilder mainCourse(Item item_name);
    MealBuilder beverage(Item item_name);
    Restaurant1 build();
    String toString();
}
class OneCourseMealBuilder implements MealBuilder{
    private Restaurant1 meal= new Restaurant1();
    
    public MealBuilder mainCourse(Item item){
        meal.addItem(item);
        return this;
    }

    public MealBuilder beverage(Item item){
        meal.addItem(item);
        return this;
    }
    public Restaurant1 build(){
        return this.meal;
    }
}
class NoSalt_OneCourseMealBuilder implements MealBuilder{
    private Restaurant1 meal=new Restaurant1();
    public MealBuilder mainCourse(Item item){
        item.changePrice((float) 0.9);
        meal.addItem(item);
        return this;
    }
    public MealBuilder beverage(Item item){
        meal.addItem(item);
        return this;
    }
    public Restaurant1 build(){
        return this.meal;
    }
}

class Client {
    public static void main(String[] args){
        Item mc1 = new Item("Chicken Burger",20);
        Item mc2 = new Item("Vegan Burger",15);
        Item b1 = new Item("coke",5);
        Item b2 = new Item("apple juicer",5);




        Restaurant1 meal1 = new OneCourseMealBuilder().mainCourse(mc1).beverage(b2).build();
        Restaurant1 meal2 = new NoSalt_OneCourseMealBuilder().mainCourse(mc2).beverage(b1).build();

        System.out.println("One course meal order: "+meal1.getPrice());
        System.out.println("No salt one course meal order: "+meal2.getPrice());

    }
}



