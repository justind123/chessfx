package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import Controller.ChessFXController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public abstract class Piece {

    //protected static Image image = new Image("./src/main/pieces.png");
    protected Image image;
    protected ImageView imageView;
    protected Color color;
    protected int x;
    protected int y;

    protected Piece() {
        try {
            image = new Image( new FileInputStream("src/main/pieces.png"), 300, 100, true, true );
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        imageView = new ImageView(image);
    }

    public Color getColor() {
        return color;
    }

    protected void addValidMove(int x, int y, List<int[]> validMoves) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return;
        }

        Piece piece = ChessFXController.getPiece(x, y);
        if (piece == null) {
            validMoves.add( new int[] {x, y} );
        }
    }

    public abstract ImageView getImageView();

    public abstract List<int[]> getValidMoves();
    
}
