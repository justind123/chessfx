package Model;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Queen extends Piece {

    private Color color;

    public Queen(Color color) {
        super();
        this.color = color;

        double width = image.getRequestedWidth() / 6;
        double height = image.getRequestedHeight() / 2;
        double minX = width * 1;
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

    public ImageView getImageView() {
        return imageView;
    }

    public String toString() {
        return "Q";
    }
    
}
