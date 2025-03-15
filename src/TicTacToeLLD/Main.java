package TicTacToeLLD;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        try{
            System.out.println(game.startGame());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}