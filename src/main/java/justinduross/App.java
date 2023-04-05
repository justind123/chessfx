package justinduross;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import Controller.ChessFXController;
import Model.Piece;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) {
        //System.out.println("Working Directory = " + System.getProperty("user.dir"));
        ChessFXController controller = new ChessFXController();
        System.out.println(controller.printBoard());

        TilePane tilePane = new TilePane();
        tilePane.setPrefColumns(8);
        tilePane.setPrefRows(8);
        tilePane.setTileAlignment(Pos.CENTER);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Color color;
                if ( (i + j) % 2 == 0) {
                    color = Color.BEIGE;
                }
                else {
                    color = Color.SADDLEBROWN;
                }

                StackPane stackPane = new StackPane();
                stackPane.getChildren().add( new Rectangle(50, 50, color) );

                ImageView pieceImageView;
                Piece piece = controller.getPiece(i, j);
                if (piece != null) {
                    pieceImageView = controller.getPiece(i, j).getImageView();
                    stackPane.getChildren().add(pieceImageView);
                }
                
                tilePane.getChildren().addAll(stackPane);
            }
        }



        Scene scene = new Scene(tilePane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}