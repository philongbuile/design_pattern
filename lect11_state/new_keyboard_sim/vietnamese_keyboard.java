package lect11_state.vnm_keyboard;

import java.util.ArrayList;

enum VNKey {
    A,S,F,X,J
}

interface VN_KB_State{
    public void press(VN_KB_Context keyboard, VNKey key);
}
class initState implements VN_KB_State{
    public void press(VN_KB_Context keyboard,VNKey key){
        
        ArrayList<VNKey> tappedHistory = keyboard.tappedHistory;
        if(tappedHistory.isEmpty() || tappedHistory.get(0)!=VNKey.A ){
            System.out.println(key.toString());
            keyboard.addTappedHistory(key);
        } else
        {
            keyboard.setState(new AtappedState());
            keyboard.press(key);
        }
        
        
    }
}
class AtappedState implements VN_KB_State{
    public void press(VN_KB_Context keyboard, VNKey key){
        ArrayList<VNKey> tappedHistory = keyboard.tappedHistory;
        if(key!=VNKey.A){
            System.out.println("A' ");
            keyboard.addTappedHistory(key);
        } 
    }
}
class VN_KB_Context{
    private VN_KB_State state;
    public ArrayList<VNKey> tappedHistory = new ArrayList<VNKey>();
    public void setState(VN_KB_State state){
        this.state = state;
    }
    public void press(VNKey key){
        
        this.state.press(this, key);
    }
    public void addTappedHistory(VNKey key){
        this.tappedHistory.add(key); 
    }
    public void clearTappedHistory(VNKey key){
        this.tappedHistory.clear();
    }
    public void printHistory(){
        for(VNKey key : tappedHistory){
            System.out.println(key.toString());
        }
    }
}
class VNKB_client{
    public static void main(String[] args) {
        VN_KB_Context keyboard= new VN_KB_Context();
        keyboard.setState(new initState());
        keyboard.press(VNKey.A);
        keyboard.press(VNKey.S);

    }
}