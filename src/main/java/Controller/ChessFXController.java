package Controller;

import Model.Board;
import Model.Piece;

public class ChessFXController {

    private static Board board = new Board();

    public ChessFXController() {
        board = new Board();
    }

    public static Piece getPiece(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return null;
        }
        return board.getPiece(x, y);
    }

    public static String printBoard() {
        return board.toString();
    }
    
}
