package lect11_state.musicplayer;
interface State{
    public void clickLock(Player playerctx);
    public void clickPlay(Player playerctx);
    public void clickNext(Player playerctx);
    public void clickPrevious(Player playerctx);
}
class ReadyState implements State{
    public void clickLock(Player playerctx){
        System.out.println("Locking phone...");
        playerctx.setState(new LockedState());
    }
    public void clickPlay(Player playerctx){
        playerctx.setState(new PlayingState());
        System.out.println("Starting to play...");
    }
    public void clickNext(Player playerctx){
        System.out.println("Next song");
    }
    public void clickPrevious(Player playerctx){
        System.out.println("Previous song");
    }
}
class LockedState implements State{
    public void clickLock(Player playerctx){
        System.out.println("Already locked");
    }
    public void clickPlay(Player playerctx){
        unlock(playerctx);
    }
    public void clickNext(Player playerctx){
        unlock(playerctx);
    }
    public void clickPrevious(Player playerctx){
        unlock(playerctx);
    }
    private void unlock(Player playerctx){
        System.out.println("Unlocking phone...");
        playerctx.setState(new ReadyState());
    }
}
class PlayingState implements State{
    public void clickLock(Player playerctx){
        System.out.println("Locking phone...");
        playerctx.setState(new LockedState());
    }
    public void clickPlay(Player playerctx){
        System.out.println("Pausing song...");
    }
    public void clickNext(Player playerctx){
        System.out.println("Next song");
    }
    public void clickPrevious(Player playerctx){
        System.out.println("Previous song");
    }
}

class Player{
    State state = new LockedState();
    public void setState(State state){
        this.state = state;
    }
    public void clickLock(){
        this.state.clickLock(this);
    }
    public void clickPlay(){
        this.state.clickPlay(this);
    }
    public void clickNext(){
        this.state.clickNext(this);
    }
    public void clickPrevious(){
        this.state.clickPrevious(this);
    }
}
class MPClient{
    public static void main(String[] args){
        Player player = new Player();
        player.clickNext();
        player.clickPlay();
        player.clickNext();
        player.clickPlay();
        player.clickPrevious();
        player.clickLock();
    }   
}
