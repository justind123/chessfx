package justinduross;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
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
    private ChessFXController controller;
    private GridPane gridPane;

    @Override
    public void start(Stage stage) {
        controller = new ChessFXController();
        System.out.println(controller.printBoard());

        gridPane = new GridPane();
        //gridPane.setColumnSpan(8);
        //gridPane.setPrefRows(8);
        //gridPane.setTileAlignment(Pos.CENTER);

        gridPane = drawBoardAndPieces(gridPane);

        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }

    private GridPane drawBoardAndPieces(GridPane GridPane) {
        ClickHandler click = new ClickHandler();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Color color;
                if ( (i + j) % 2 == 0) {
                    color = Color.BEIGE;
                }
                else {
                    color = Color.SADDLEBROWN;
                }

                Rectangle rect = new Rectangle(50, 50, color);
                rect.setStyle("-fx-stroke: black; -fx-stroke-width: 1px; -fx-stroke-type: outside;");

                StackPane stackPane = new StackPane();
                stackPane.addEventHandler(MouseEvent.MOUSE_CLICKED, click);
                stackPane.getChildren().add(rect);

                ImageView pieceImageView;
                Piece piece = controller.getPiece(i, j);
                if (piece != null) {
                    pieceImageView = controller.getPiece(i, j).getImageView();
                    stackPane.getChildren().add(pieceImageView);
                }
                
                gridPane.add(stackPane, j, i);
            }
        }

        return gridPane;
    }

    private class ClickHandler implements EventHandler<MouseEvent> {

        private StackPane prevStackPane;

        @Override
        public void handle(MouseEvent m) {
            System.out.println(m);

            if (!isValidClick(m)) {
                return;
            }

            StackPane stackPane = (StackPane) m.getSource();

            if (prevStackPane != null) {
                prevStackPane.getChildren().remove(1);
            }

            prevStackPane = stackPane;
            
            Rectangle newRect = new Rectangle(50, 50, Color.RED);
            stackPane.getChildren().add(1, newRect);

            addValidMoveHighlights();
        }

        private boolean isValidClick(MouseEvent m) {
            if ( !(m.getSource() instanceof StackPane) ) {
                return false;
            }

            StackPane stackPane = (StackPane) m.getSource();
            if (stackPane.getChildren().size() < 2) {
                return false;
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    StackPane currStackPane = (StackPane) gridPane.getChildren().get(8*i + j);
                    if (currStackPane.equals(stackPane)) {
                        
                        Color clickedColor = controller.getPiece(i, j).getColor();

                        if (clickedColor == Color.WHITE) {
                            return true;
                        }

                        return false;
                    }
                }
            }

            return false;
        }

        private void addValidMoveHighlights() {

        }
        
    }

    public static void main(String[] args) {
        launch();
    }

}