package TicTacToeLLD;

import TicTacToeLLD.Model.*;
import javafx.util.Pair;

import java.util.*;

public class TicTacToeGame {
    Scanner scanner = new Scanner(System.in);
    Deque<Player> playerList;
    Board board;

    TicTacToeGame(){
        initializeGame();
    }

    public void initializeGame(){
        playerList = new LinkedList<>();
        System.out.println("Player1, pls Enter the symbol with which you want to play: ");
        PlayingPiece player1Choice = PieceTypeMapping.fromSymbol(scanner.next());
//        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Manish ", player1Choice);

        System.out.println("Player2, pls Enter the symbol with which you want to play: ");
        PlayingPiece player2Choice = PieceTypeMapping.fromSymbol(scanner.next());
//        PlayingPieceO noughtPiece = new PlayingPieceO();
        Player player2 = new Player("Prenka ", player2Choice);

        if(Objects.isNull(player1Choice) || Objects.isNull(player2Choice)){
            System.out.println("You have not entered a valid symbol!");
            System.out.println("Please enter a valid symbol with which you want to play: " + PieceTypeMapping.getPlayingPieces());
            return;
        }

        playerList.add(player1);
        playerList.add(player2);

        board = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        System.out.println("Welcome to Tic-Tac-Toe Game!");
        while(noWinner){
            Player currentPlayer = playerList.removeFirst();
            board.printBoard();

            List<Pair<Integer, Integer>> freeSpaces = board.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            System.out.println("Player:  " + currentPlayer.name + ", Enter row, column");
            String s = scanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.parseInt(values[0]);
            int column = Integer.parseInt(values[1]);

            boolean pieceAddedSuccessfully = board.placePiece(row, column, currentPlayer.getPlayingPiece());
            if(!pieceAddedSuccessfully){
                System.out.println("Position already chosen");
                playerList.addFirst(currentPlayer);
                continue;
            }

            playerList.addLast(currentPlayer);
            boolean winner = isThereWinner(row, column, currentPlayer.playingPiece.pieceType);
            if(winner){
                board.printBoard();
                return currentPlayer.getName() + " won!";
            }
        }
        return "Game Tie";
    }

    public boolean isThereWinner(int row, int column, PieceType piece) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for (int i = 0; i < board.size; i++) {
            if (board.board[row][i] == null || board.board[row][i].pieceType != piece) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0; i < board.size; i++) {
            if (board.board[i][column] == null || board.board[i][column].pieceType != piece) {
                columnMatch = false;
                break;
            }
        }

        for (int i = 0, j = 0; i < board.size; i++, j++) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != piece) {
                diagonalMatch = false;
                break;
            }
        }

        for (int i = 0, j = board.size - 1; i < board.size; i++, j--) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != piece) {
                antiDiagonalMatch = false;
                break;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
