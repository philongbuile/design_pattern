package lect11_state;



enum Key {
	Q, CAPS_LOCK,SHIFT,FN,F11,F12;
}
 
 
interface keyboardState{
    public void tap(KeyBoardContext ctx, Key key);
    // public void hold(KeyBoardContext ctx, Key key);
    // public void release(KeyBoardContext ctx, Key key);

    public void hold(KeyBoardContext keyBoardContext, Key key);

    public void release(KeyBoardContext keyBoardContext, Key key);
} 
class initState implements keyboardState{
    public void tap(KeyBoardContext ctx, Key key) {
        if(key.equals(Key.CAPS_LOCK)){
            ctx.setState(new capslockState());
            return;
        }
        System.out.println(key.toString().toLowerCase());
    }
    public void hold(KeyBoardContext ctx, Key key) {
        if(key==Key.SHIFT){
            ctx.setState(new initholdShiftState());
            return;
        }
        if(key==Key.FN){
            ctx.setState(new initholdFNState());
            return;
        }
    }
    public void release(KeyBoardContext ctx, Key key) {
        return;
    }
}
class capslockState implements keyboardState{
    public void tap(KeyBoardContext ctx, Key key) {
        if(key == Key.CAPS_LOCK){
            ctx.setState(new initState());
            return;
        }
        System.out.println(key.toString().toUpperCase());
    }
    public void hold(KeyBoardContext ctx, Key key) {
        if(key.equals(Key.SHIFT)){
            ctx.setState(new capslock_holdShiftState());
            return;
        }
        if(key.equals(Key.FN)){
            ctx.setState(new capslockTap_holdFNState());
            return;
        }
    }
    public void release(KeyBoardContext ctx, Key key){
        return;
    }
        
}
class initholdShiftState implements keyboardState{
    public void tap(KeyBoardContext ctx, Key key){
        if(key==Key.CAPS_LOCK){
            ctx.setState(new capslock_holdShiftState());
            return;
        }
        System.out.println(key.toString().toUpperCase());
    }
    public void hold(KeyBoardContext ctx, Key key){
        if(key==Key.FN){
            ctx.setState(new holdShiftFNState());
            return;
        }
    }
    public void release(KeyBoardContext ctx, Key key){
        if(key==Key.SHIFT){
            ctx.setState(new initState());
            return;
        }
    }

}
class capslock_holdShiftState implements keyboardState{
    public void tap(KeyBoardContext ctx, Key key){
        if(key==Key.CAPS_LOCK){
            //ctx.setState(new capslocktap_holdShiftState());
            ctx.setState(new initholdShiftState());
            return;
        }
        System.out.println(key.toString().toLowerCase());
    }
    public void hold(KeyBoardContext ctx, Key key){
        if(key==Key.FN){
            ctx.setState(new capslockTap_holdShift_holdFN_State());
            return;
        }
    }
    public void release(KeyBoardContext ctx,Key key){
        if(key==Key.SHIFT){
            ctx.setState(new capslockState());
            return;
        }
    }
}
class initholdFNState implements keyboardState{
    public void tap(KeyBoardContext ctx, Key key){
        if(key==Key.CAPS_LOCK){
            ctx.setState(new capslockTap_holdFNState());
        }

        if(key==Key.F11){
            System.out.println(" Volume decreased -- ");
        }
        else if(key==Key.F12){
            System.out.println(" Volume increased ++ ");
        }
        else{
            return;
        }
    }   
    public void hold(KeyBoardContext ctx, Key key){
        if(key==Key.SHIFT){
            ctx.setState(new holdShiftFNState());
            return;
        }
    } 
    public void release(KeyBoardContext ctx, Key key){
        if(key==Key.FN){
            ctx.setState(new initState());
            return;
        }
    }
}
class holdShiftFNState implements keyboardState{
    public void tap(KeyBoardContext ctx, Key key){
        if(key==Key.CAPS_LOCK){
            ctx.setState(new capslockTap_holdShift_holdFN_State());
            return;
        }
        if(key==Key.F11){
            System.out.println(" Brightness decreased -- ");
        }
        else if(key==Key.F12){
            System.out.println(" Brightness increased ++ ");
        }
        else{
            return;
        }
    }
    public void hold(KeyBoardContext ctx, Key key){
        return;
    }
    public void release(KeyBoardContext ctx, Key key){
        if(key==Key.SHIFT){
            ctx.setState(new initholdFNState());
            return;
        }
        else if(key==Key.FN){
            ctx.setState(new initholdShiftState());
            return;
        }
    }    
}
class capslockTap_holdFNState implements keyboardState{
    public void tap(KeyBoardContext ctx, Key key){
        if(key==Key.CAPS_LOCK){
            ctx.setState(new initholdFNState());
        }
        else if(key==Key.F11){
            System.out.println(" Brightness decreased -- ");
        }
        else if(key==Key.F12){
            System.out.println(" Brightness increased ++ ");
        }
        else{
            return;
        }
    }
    public void hold(KeyBoardContext ctx, Key key){
        if(key==Key.SHIFT){
            ctx.setState(new capslockTap_holdShift_holdFN_State());
            return;
        }
    }
    public void release(KeyBoardContext ctx, Key key){
        if(key==Key.FN){
            ctx.setState(new capslockState());
            return;
        }
    }
}
class capslockTap_holdShift_holdFN_State implements keyboardState{
    public void tap(KeyBoardContext ctx, Key key){
        if(key==Key.CAPS_LOCK){
            ctx.setState(new holdShiftFNState());
        }
        if(key==Key.F11){
            System.out.println(" Volume decreased -- ");
        }
        else if(key==Key.F12){
            System.out.println(" Volume increased ++ ");
        }
        else{
            return;
        }
    }
    public void hold(KeyBoardContext ctx, Key key){
        return;
    }    
    public void release(KeyBoardContext ctx, Key key){
        if(key==Key.SHIFT){
            ctx.setState(new capslockTap_holdFNState());
            return;
        }
        else if(key==Key.FN){
            ctx.setState(new capslock_holdShiftState());
            return;
        }
    }
}




class KeyBoardContext{
    keyboardState state;
    public void setState(keyboardState state){
        this.state = state;
    }
    public void tap(Key key){
        this.state.tap(this, key);
    }
    public void hold(Key key){
        // if(key.toString().equals("SHIFT")){
        //     if(this.state instanceof initState){
        //         this.state = new initholdShiftState();
        //     }
        //     else if(this.state instanceof capslockState){
        //         this.state = new capslock_holdShiftState();
        //     }
        //     else if(this.state instanceof initholdFNState){
        //         this.state = new holdShiftFNState();
        //     }
        //     else if(this.state instanceof capslockTap_holdFNState){
        //         this.state = new capslockTap_holdShift_holdFN_State();
        //     }
        // }
        // else if(key == Key.FN){
        //     if(this.state instanceof initState){
        //         this.state = new initholdFNState();
        //     }
        //     else if(this.state instanceof initholdShiftState){
        //         this.state = new holdShiftFNState();
        //     }
        //     else if(this.state instanceof capslockState){
        //         this.state = new capslockTap_holdFNState();
        //     }
        //     else if(this.state instanceof capslock_holdShiftState){
        //         this.state = new capslockTap_holdShift_holdFN_State();
        //     }
        // }
        this.state.hold(this, key);
    }
    public void release(Key key){
        // if(key == Key.SHIFT){
        //     if(this.state instanceof initholdShiftState){
        //         this.state = new initState();
        //     }
        //     else if(this.state instanceof capslock_holdShiftState){
        //         this.state = new capslockState();
        //     }
        //     else if(this.state instanceof holdShiftFNState){
        //         this.state = new initholdFNState();
        //     }
        //     else if(this.state instanceof capslockTap_holdShift_holdFN_State){
        //         this.state = new capslockTap_holdFNState();
        //     }
            
        // }
        // else if(key==Key.FN){
        //     if(this.state instanceof initholdFNState){
        //         this.state = new initState();
        //     }
        //     else if(this.state instanceof holdShiftFNState){
        //         this.state = new initholdShiftState();
        //     }
        //     else if(this.state instanceof capslockTap_holdFNState){
        //         this.state = new capslockState();
        //     }
        //     else if(this.state instanceof capslockTap_holdShift_holdFN_State){
        //         this.state = new capslock_holdShiftState();
        //     }
        // }
        this.state.release(this, key);
        
    }
}

 
 
 class Client {
	public static void main(String args[]) {
		System.out.println("Keyboard");
		System.out.println("===============");
		
		KeyBoardContext ctx = new KeyBoardContext();
        ctx.setState(new initState());
        // ctx.tap(Key.Q);
        // ctx.tap(Key.Q);
        // ctx.tap(Key.CL);
        // ctx.hold(Key.SHIFT);
        // ctx.tap(Key.CL);
        // ctx.tap(Key.Q);
        // ctx.release(Key.SHIFT);
        // ctx.tap(Key.Q);
        // ctx.hold(Key.SHIFT);
        // ctx.tap(Key.Q);
        //
            // ctx.hold(Key.FN);
            // ctx.hold(Key.SHIFT);
            // ctx.tap(Key.CAPS_LOCK);
            // ctx.tap(Key.F11);
            // ctx.tap(Key.F12);
            // ctx.release(Key.SHIFT);
            // ctx.tap(Key.F12);
            // ctx.tap(Key.CAPS_LOCK);
            // ctx.hold(Key.SHIFT);
            // ctx.tap(Key.F11);
        // 
        ctx.hold(Key.FN);
        ctx.hold(Key.SHIFT);
        ctx.tap(Key.F11);


       
	}
}
