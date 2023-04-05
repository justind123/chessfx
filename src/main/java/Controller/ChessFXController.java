package Controller;

import Model.Board;
import Model.Piece;

public class ChessFXController {

    private Board board;

    public ChessFXController() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        board = new Board();
    }

    public Piece getPiece(int x, int y) {
        return board.getPiece(x, y);
    }

    public String printBoard() {
        return board.toString();
    }
    
}
