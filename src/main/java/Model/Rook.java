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

        return validMoves;
    }

    public ImageView getImageView() {
        return imageView;
    }
    
    public String toString() {
        return "R";
    }
}
