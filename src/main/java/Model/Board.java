package Model;

import javafx.scene.paint.Color;

public class Board {

    private Piece[][] board = new Piece[8][8];

    public Board() {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        for (int i = 0; i < board.length; i++) {
            board[1][i] = new Pawn(Color.BLACK);
            board[6][i] = new Pawn(Color.WHITE);
        }

        board[0][0] = new Rook(Color.BLACK);
        board[0][1] = new Knight(Color.BLACK);
        board[0][2] = new Bishop(Color.BLACK);
        board[0][3] = new Queen(Color.BLACK);
        board[0][4] = new King(Color.BLACK);
        board[0][5] = new Bishop(Color.BLACK);
        board[0][6] = new Knight(Color.BLACK);
        board[0][7] = new Rook(Color.BLACK);

        board[7][0] = new Rook(Color.WHITE);
        board[7][1] = new Knight(Color.WHITE);
        board[7][2] = new Bishop(Color.WHITE);
        board[7][3] = new Queen(Color.WHITE);
        board[7][4] = new King(Color.WHITE);
        board[7][5] = new Bishop(Color.WHITE);
        board[7][6] = new Knight(Color.WHITE);
        board[7][7] = new Rook(Color.WHITE);

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
