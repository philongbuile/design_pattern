package lect11_;

import lect11_.Toptop.Key;

class Toptop{
    public static enum Key{q,CL};
    boolean isUpper = false;
    boolean isCL = false;

    public void tap(Key key){
        if(key == Key.CL ){
            this.CLtapped();
            return;
        }
        
        if(isUpper == false || isCL == true){
            System.out.println(Key.q.toString().toUpperCase());
        }
        else
            System.out.println(Key.q);
        this.isTapped();
    }
    public void CLtapped(){
        System.out.println("Capslock has been tapped");
        this.isCL = !this.isCL;
    }
    public void isTapped(){
        this.isUpper = !this.isUpper;
    }
}

class LmaoClient{
    public static void main(String[] args){
        Toptop toptop = new Toptop();
        toptop.tap(Key.q);
        toptop.tap(Key.q);
        toptop.tap(Key.q);
        toptop.tap(Key.q);
        toptop.tap(Key.CL);
        toptop.tap(Key.q);
        toptop.tap(Key.q);
        toptop.tap(Key.q);
        toptop.tap(Key.q);
        toptop.tap(Key.CL);
        toptop.tap(Key.q);
        toptop.tap(Key.q);
        toptop.tap(Key.q);
        toptop.tap(Key.q);

    }
}
