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
import java.util.ArrayList;
import java.util.List;

import Controller.ChessFXController;
import Model.Piece;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    //private ChessFXController controller;
    private GridPane gridPane;
    private List<StackPane> currSquareHighlights = new ArrayList<StackPane>();
    private Color currTurn;

    @Override
    public void start(Stage stage) {
        //controller = new ChessFXController();
        System.out.println(ChessFXController.printBoard());

        gridPane = new GridPane();
        //gridPane.setColumnSpan(8);
        //gridPane.setPrefRows(8);
        //gridPane.setTileAlignment(Pos.CENTER);

        gridPane = drawBoardAndPieces(gridPane);
        currTurn = Color.WHITE;

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
                Piece piece = ChessFXController.getPiece(i, j);
                if (piece != null) {
                    pieceImageView = ChessFXController.getPiece(i, j).getImageView();
                    stackPane.getChildren().add(pieceImageView);
                }
                
                gridPane.add(stackPane, j, i);
            }
        }

        return gridPane;
    }

    private class ClickHandler implements EventHandler<MouseEvent> {

        private int x;
        private int y;

        @Override
        public void handle(MouseEvent m) {
            if (currTurn != Color.WHITE) {
                return;
            }
            System.out.println(m);

            if (!isValidClick(m)) {
                return;
            }
            

            StackPane stackPane = (StackPane) m.getSource();

            if (currSquareHighlights.size() > 0) {
                for (StackPane pane : currSquareHighlights) {
                    pane.getChildren().remove(1);
                }
                currSquareHighlights.removeAll(currSquareHighlights);
            }
            
            Rectangle newRect = new Rectangle(50, 50, Color.RED);
            stackPane.getChildren().add(1, newRect);
            currSquareHighlights.add(stackPane);

            addValidMoveHighlights(stackPane);
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
                        
                        Color clickedColor = ChessFXController.getPiece(i, j).getColor();

                        if (clickedColor == Color.WHITE) {
                            x = i;
                            y = j;
                            return true;
                        }

                        return false;
                    }
                }
            }

            return false;
        }

        private void addValidMoveHighlights(StackPane stackPane) {
            Piece piece = ChessFXController.getPiece(x, y);
            List<int[]> getValidMoves = piece.getValidMoves();

            List<Node> squares = gridPane.getChildren();

            for (int[] move : getValidMoves) {
                StackPane validMoveSquare = (StackPane)squares.get(move[0] * 8 + move[1]);
                validMoveSquare.getChildren().add(1, new Rectangle(50, 50, Color.RED));
                currSquareHighlights.add(validMoveSquare);
            }
            
        }
        
    }

    public static void main(String[] args) {
        launch();
    }

}