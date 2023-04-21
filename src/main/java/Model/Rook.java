package Model;

import java.util.ArrayList;
import java.util.List;

import Controller.ChessFXController;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Rook extends Piece {

    public Rook(Color color, int x, int y) {
        super();
        this.color = color;
        this.x = x;
        this.y = y;

        double width = image.getRequestedWidth() / 6;
        double height = image.getRequestedHeight() / 2;
        double minX = width * 4;
        double minY;
        if (color == Color.WHITE) {
            minY = 0;
        }
        else {
            minY = height;
        }

        Rectangle2D viewport = new Rectangle2D(minX, minY, width, height);
        imageView.setViewport(viewport);
    }

    public List<int[]> getValidMoves() {
        List<int[]> validMoves = new ArrayList<int[]>();

        Piece piece;
        for (int i = x; i >= 0; i--) {
            piece = ChessFXController.getPiece(i, y);
            if (piece.getColor() == Color.WHITE) {
                break;
            }
            addValidMove(i, y, validMoves);
        }

        for (int i = x; i < 8; i++) {
            piece = ChessFXController.getPiece(i, y);
            if (piece.getColor() == Color.WHITE) {
                break;
            }
            addValidMove(i, y, validMoves);
        }

        for (int i = y; y >= 0; i++) {
            piece = ChessFXController.getPiece(x, i);
            if (piece.getColor() == Color.WHITE) {
                break;
            }
            addValidMove(x, i, validMoves);
        }

        for (int i = y; y < 8; i++) {
            piece = ChessFXController.getPiece(x, i);
            if (piece.getColor() == Color.WHITE) {
                break;
            }
            addValidMove(x, i, validMoves);
        }

        return validMoves;
    }

    public ImageView getImageView() {
        return imageView;
    }
    
    public String toString() {
        return "R";
    }
}
