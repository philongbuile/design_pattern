package lect6_composite_pattern;

import java.util.ArrayList;


interface Tournament {
    public void showWinner();
    public Player getWinner();
    public void showMatchScore();
}
class Player{
    private String name;
    public Player(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
class Game implements Tournament {
    private Player player1;
    private Player player2;
    private int score1;
    private int score2;
    public Game(Player player1, Player player2, int score1, int score2){
        this.player1 = player1;
        this.player2 = player2;
        this.score1 = score1;
        this.score2 = score2;
    }
    public Player getWinner(){
        if(score1 > score2){
            return player1;
        }
        else
            return player2;
        
    }
    public void showWinner(){
        System.out.print(" Winner vong loai truc tiep: ");
        if(score1 > score2){
            System.out.println(player1.getName() + " thang");
        }
        else{
            System.out.println(player2.getName() + " thang");
        }
    }
    public void showMatchScore(){
        System.out.print(" Ket qua vong loai truc tiep: ");
        System.out.println("\t" + player1.getName() + "\t" + score1+ ":" + score2 + "\t" + player2.getName() );
    }
}
abstract class Decorator implements Tournament{
    protected Tournament tournament1;
    protected Tournament tournament2;
    protected Player player1;
    protected Player player2;
    protected int score1;
    protected int score2;
    public Decorator(Tournament tournament1, Tournament tournament2, int score1, int score2){
        this.tournament1 = tournament1;
        this.tournament2 = tournament2;
        this.score1 = score1;
        this.score2 = score2;

        this.player1 = tournament1.getWinner();
        this.player2 = tournament2.getWinner();
    }
    public void showWinner(){
        tournament1.showWinner();
        tournament2.showWinner();
    }
    public void showMatchScore(){
        tournament1.showMatchScore();
        tournament2.showMatchScore();
    }
}
class TuKet extends Decorator{

    public TuKet(Tournament tournament1, Tournament tournament2, int score1, int score2){
        super(tournament1,tournament2,score1,score2);
    }
    @Override
    public void showMatchScore(){
        super.showMatchScore();
        super.showWinner();
        System.out.println("-\t  Ket qua vong tu ket: ");
        System.out.println("\t" + player1.getName() + "\t" + score1+ ":" + score2 + "\t" + player2.getName() );
        
        
    }
    @Override
    public Player getWinner(){
        if(score1 > score2){
            return player1;
        }
        else
            return player2;
    }
    @Override
    public void showWinner(){
        Player winner = getWinner();
        System.out.println("-\tNguoi chien thang tu ket: "+ winner.getName());
        
    }
}
 
class Viewer{
    public static void main(String[] args){
        
        Player player1 = new Player("Nguyen Van A");
        Player player2 = new Player("Nguyen Van B");
        Player player3 = new Player("Nguyen Van C");
        Player player4 = new Player("Nguyen Van D");
        Player player5 = new Player("Nguyen Van E");
        Player player6 = new Player("Nguyen Van F");
        Player player7 = new Player("Nguyen Van G");
        Player player8 = new Player("Nguyen Van H");

        TuKet tuket1 = new TuKet(new Game(player1,player2,3,2),new Game(player3,player4,2,3),7,9);
        TuKet tuket2 = new TuKet(new Game(player5,player6,4,1),new Game(player7,player8,1,4),10,8);
        tuket1.showMatchScore();
        tuket1.showWinner();

    }
}