package TicTacToeLLD;

import TicTacToeLLD.Model.*;
import javafx.util.Pair;

import java.util.*;

public class TicTacToeGame {
    Deque<Player> playerList;
    Board board;

    TicTacToeGame(){
        initializeGame();
    }

    public void initializeGame(){
        playerList = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Manish", crossPiece);

        PlayingPieceO noughtPiece = new PlayingPieceO();
        Player player2 = new Player("Prenka", noughtPiece);

        playerList.add(player1);
        playerList.add(player2);

        board = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){

            Player currentPlayer = playerList.removeFirst();
            board.printBoard();

            List<Pair<Integer, Integer>> freeSpaces = board.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            System.out.println("Player:  " + currentPlayer.name + ", Enter row, column");
            Scanner scanner = new Scanner(System.in);
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
                return currentPlayer.getName();
            }
        }
        return "Tie";
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
