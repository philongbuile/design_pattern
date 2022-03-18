package lect4_singleton.menu;

public class MenuBarFactory{
    MenuBar menuBar = new MenuBar();
    public MenuBar getInstance(){
        return menuBar;
    }
}
