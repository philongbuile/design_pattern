package lect11_;



enum Key {
	Q, CL,SHIFT;
}
 
 
interface KeyBoardState{
    public void tap(KeyBoardContext ctx, Key key);
} 
class initState implements KeyBoardState{
    public void tap(KeyBoardContext ctx, Key key) {
        if(key.equals(Key.CL)){
            ctx.setState(new capslockState());
            return;
        }
        System.out.println(key.toString().toLowerCase());
    }
}
class capslockState implements KeyBoardState{
    public void tap(KeyBoardContext ctx, Key key) {
        if(key == Key.CL){
            ctx.setState(new initState());
            return;
        }
        System.out.println(key.toString().toUpperCase());
    }
        
}
class initholdShiftState implements KeyBoardState{
    public void tap(KeyBoardContext ctx, Key key){
        System.out.println(key.toString().toUpperCase());
    }

}
class capslockholdShiftState implements KeyBoardState{
    public void tap(KeyBoardContext ctx, Key key){
        if(key==Key.CL){
            //ctx.setState(new capslocktap_holdShiftState());
            ctx.setState(new initholdShiftState());
            return;
        }
        System.out.println(key.toString().toLowerCase());
    }
}
// class capslocktap_holdShiftState implements KeyBoardState{
//     public void tap(KeyBoardContext ctx, Key key){
//         System.out.println(key.toString().toUpperCase());
//     }
// }


class KeyBoardContext{
    KeyBoardState state;
    public void setState(KeyBoardState state){
        this.state = state;
    }
    public void tap(Key key){
        this.state.tap(this, key);
    }
    public void hold(Key key){
        if(key.toString().equals("SHIFT")){
            if(this.state instanceof initState){
                this.state = new initholdShiftState();
            }
            else if(this.state instanceof capslockState){
                this.state = new capslockholdShiftState();
            }
        }
    }
    public void release(Key key){
        if(key.toString().equals("SHIFT")){
            if(this.state instanceof initholdShiftState){
                this.state = new initState();
            }
            else if(this.state instanceof capslockholdShiftState){
                this.state = new capslockState();
            }
        }
    }
}

 
 
 class Client {
	public static void main(String args[]) {
		System.out.println("Keyboard");
		System.out.println("===============");
		
		KeyBoardContext ctx = new KeyBoardContext();
        ctx.setState(new initState());
        ctx.tap(Key.Q);
        ctx.tap(Key.Q);
        ctx.tap(Key.CL);
        ctx.hold(Key.SHIFT);
        ctx.tap(Key.CL);
        ctx.tap(Key.Q);
        ctx.release(Key.SHIFT);
        ctx.tap(Key.Q);
        ctx.hold(Key.SHIFT);
        ctx.tap(Key.Q);
       
	}
}
