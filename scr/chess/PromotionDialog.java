package chess;

import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import pieces.*;

/**
 * Simple Dialog which opens when a pawn reaches y=7 or y=0 and promotes him
 * @author Stefan Hasler
 * @version 1.0
 */

public class PromotionDialog extends Dialog<Boolean> {

    /**
     * Constructor adding functionality to buttons
     * @param pawn pawn to Promote
     */

    public PromotionDialog(Pawn pawn) {
        setTitle("Promote Pawn " + pawn.getColor());
        //setResultConverter(f -> selectedFigure);
        HBox hbox = new HBox();
        Button q =  new Button("Queen");
        Button r = new Button("Rook");
        Button k = new Button("Knight");
        Button b = new Button("Bishop");
        b.setOnMouseClicked((mouseEvent)->{
            Bishop bp = new Bishop(new ImageView(new Image("imgs\\"+pawn.getColor().toString().charAt(0)+ "_Bishop.png")), pawn.getFieldLabel().getBoard().getLabels()[pawn.getFieldLabel().getX()][pawn.getFieldLabel().getY()], pawn.getColor(), "Bishop");
            bp.setFieldLabel(pawn.getFieldLabel());
            pawn.getFieldLabel().setPiece(bp);
            this.setResult(true);
        });
        k.setOnMouseClicked((mouseEvent)->{
            Knight bp = new Knight(new ImageView(new Image("imgs\\"+pawn.getColor().toString().charAt(0)+ "_Knight.png")), pawn.getFieldLabel().getBoard().getLabels()[pawn.getFieldLabel().getX()][pawn.getFieldLabel().getY()], pawn.getColor(), "Knight");
            bp.setFieldLabel(pawn.getFieldLabel());
            pawn.getFieldLabel().setPiece(bp);
            this.setResult(true);
        });
        r.setOnMouseClicked((mouseEvent)->{
            Rook bp = new Rook(new ImageView(new Image("imgs\\"+pawn.getColor().toString().charAt(0)+ "_Rook.png")), pawn.getFieldLabel().getBoard().getLabels()[pawn.getFieldLabel().getX()][pawn.getFieldLabel().getY()], pawn.getColor(), "Rook");
            bp.setFieldLabel(pawn.getFieldLabel());
            pawn.getFieldLabel().setPiece(bp);
            this.setResult(true);
        });
        q.setOnMouseClicked((mouseEvent)->{
            Queen bp = new Queen(new ImageView(new Image("imgs\\"+pawn.getColor().toString().charAt(0)+ "_Queen.png")), pawn.getFieldLabel().getBoard().getLabels()[pawn.getFieldLabel().getX()][pawn.getFieldLabel().getY()], pawn.getColor(), "Queen");
            bp.setFieldLabel(pawn.getFieldLabel());
            pawn.getFieldLabel().setPiece(bp);
            this.setResult(true);
        });
        hbox.getChildren().add(q);
        hbox.getChildren().add(r);
        hbox.getChildren().add(k);
        hbox.getChildren().add(b);
        getDialogPane().setContent(hbox);
    }

}