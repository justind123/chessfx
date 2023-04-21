package Model;

import javafx.scene.paint.Color;

public class Board {

    private Piece[][] board = new Piece[8][8];
    private Color currTurn = Color.WHITE;

    public Board() {
        for (int i = 0; i < board.length; i++) {
            board[1][i] = new Pawn(Color.BLACK, 1, i);
            board[6][i] = new Pawn(Color.WHITE, 6, i);
        }

        board[0][0] = new Rook(Color.BLACK, 0, 0);
        board[0][1] = new Knight(Color.BLACK, 0, 1);
        board[0][2] = new Bishop(Color.BLACK, 0, 2);
        board[0][3] = new Queen(Color.BLACK, 0, 3);
        board[0][4] = new King(Color.BLACK, 0, 4);
        board[0][5] = new Bishop(Color.BLACK, 0, 5);
        board[0][6] = new Knight(Color.BLACK, 0, 6);
        board[0][7] = new Rook(Color.BLACK, 0, 7);

        board[7][0] = new Rook(Color.WHITE, 7, 0);
        board[7][1] = new Knight(Color.WHITE, 7, 1);
        board[7][2] = new Bishop(Color.WHITE, 7, 2);
        board[7][3] = new Queen(Color.WHITE, 7, 3);
        board[7][4] = new King(Color.WHITE, 7, 4);
        board[7][5] = new Bishop(Color.WHITE, 7, 5);
        board[7][6] = new Knight(Color.WHITE, 7, 6);
        board[7][7] = new Rook(Color.WHITE, 7, 7);

    }

    public Piece getPiece(int x, int y) {
        return board[x][y];
    }

    public String toString() {
        String retval = "";
        for (int i = 0; i < board.length; i++) {
            retval += "\n";
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    retval += ".";
                }
                else {
                    retval += board[i][j].toString();
                }
            }
        }

        return retval;
    }
    
}
