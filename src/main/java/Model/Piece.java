package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Piece {

    //protected static Image image = new Image("./src/main/pieces.png");
    protected Image image;
    protected ImageView imageView;

    protected Piece() {
        try {
            image = new Image( new FileInputStream("src/main/pieces.png"), 300, 100, true, true );
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        imageView = new ImageView(image);
    }

    public abstract ImageView getImageView();
    
}
