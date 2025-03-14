package TicTacToeLLD;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        System.out.println("Welcome to Tic-Tac-Toe Game!");
        System.out.println("Result is: " + game.startGame());
    }
}