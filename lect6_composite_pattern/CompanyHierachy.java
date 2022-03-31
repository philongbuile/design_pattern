package lect6_composite_pattern;

import java.util.ArrayList;

class Employee{
    String name;
    ArrayList<Employee> subordinates = new ArrayList<Employee>();
    public Employee(String name){
        this.name = name;
    }
    public void addEmployee(Employee e){
        subordinates.add(e);
    }
    public void removeEmployee(Employee e){
        subordinates.remove(e);
    }
    public void showHierarchy(){
        System.out.println(this.name);
        for(Employee e : subordinates){
            e.showHierarchy();
        }
    }
}
class Client{
    public static void main(String[] args){
        Employee CEO = new Employee("John");
        Employee headSales = new Employee("Robert");
        Employee headMarketing = new Employee("Michel");
        Employee clerk1 = new Employee("Laura");
        Employee clerk2 = new Employee("Bob");
        Employee clerk3 = new Employee("Carol");
        Employee salesExecutive1 = new Employee("Richard");
        Employee salesExecutive2 = new Employee("Rob");
        Employee subSaleExecutive1 = new Employee("Michael");
        CEO.addEmployee(headSales);
        CEO.addEmployee(headMarketing);
        headSales.addEmployee(salesExecutive1);
        headSales.addEmployee(salesExecutive2);
        salesExecutive1.addEmployee(subSaleExecutive1);
        headMarketing.addEmployee(clerk1);
        headMarketing.addEmployee(clerk2);
        headMarketing.addEmployee(clerk3);
        CEO.showHierarchy();
    }
}
