package lect4_singleton;

import lect4_singleton.menu.MenuBar;
import lect4_singleton.menu.MenuBarFactory;

public class Client {
    public static void main(String[] args){
        MenuBarFactory men_Factory = new MenuBarFactory();
        MenuBar menuBar = men_Factory.getInstance();
        MenuBar menuBar1 = men_Factory.getInstance();
        System.out.println(menuBar==menuBar1);
    }
}
