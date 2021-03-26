package pieces;

import chess.Chessboard;
import chess.FieldLabel;
import gameLogic.Move;
import javafx.scene.image.ImageView;
import gameLogic.Color;

import java.util.ArrayList;

/**
 * Describes a Knight and its movements
 */

public class Knight extends Piece {
    public Knight(ImageView img, FieldLabel l, Color color, String name) {
        super(img, l, color, name);
    }

    @Override
    public ArrayList<Move> calculateValidMoves(Chessboard board) {
        FieldLabel[][] labels = this.fieldLabel.getBoard().getLabels();
        int x = this.fieldLabel.getX();
        int y = this.fieldLabel.getY();
        validMoves.removeAll(validMoves);
        FieldLabel fieldLabel1;
        try
        {
            fieldLabel1 = labels[x+1][y-2];
            addIfValid(fieldLabel1);
        } catch (ArrayIndexOutOfBoundsException ignored){}
        try
        {
            fieldLabel1 = labels[x+2][y-1];
            addIfValid(fieldLabel1);
        } catch (ArrayIndexOutOfBoundsException ignored){}

        try
        {
            fieldLabel1 = labels[x+2][y+1];
            addIfValid(fieldLabel1);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try
        {
            fieldLabel1 = labels[x+1][y+2];
            addIfValid(fieldLabel1);
        }catch (ArrayIndexOutOfBoundsException ignored){}

        try
        {
            fieldLabel1 = labels[x-1][y+2];
            addIfValid(fieldLabel1);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try
        {
            fieldLabel1 = labels[x-2][y+1];
            addIfValid(fieldLabel1);
        }catch (ArrayIndexOutOfBoundsException ignored){}

        try
        {
            fieldLabel1 = labels[x-2][y-1];
            addIfValid(fieldLabel1);
        }catch (ArrayIndexOutOfBoundsException ignored){}
        try
        {
            fieldLabel1 = labels[x-1][y-2];
            addIfValid(fieldLabel1);
        }catch (ArrayIndexOutOfBoundsException ignored){}

        return validMoves;
    }

    @Override
    public ArrayList<FieldLabel> calculateAttackingSquares() {
        FieldLabel[][] labels = this.fieldLabel.getBoard().getLabels();
        int x = this.fieldLabel.getX();
        int y = this.fieldLabel.getY();
        try { attackingSquares.add(labels[x+1][y-2]); } catch (ArrayIndexOutOfBoundsException ignored){}
        try { attackingSquares.add(labels[x+2][y-1]); } catch (ArrayIndexOutOfBoundsException ignored){}
        try { attackingSquares.add(labels[x+2][y+1]); } catch (ArrayIndexOutOfBoundsException ignored){}
        try { attackingSquares.add(labels[x+1][y+2]); } catch (ArrayIndexOutOfBoundsException ignored){}
        try { attackingSquares.add(labels[x-1][y+2]); } catch (ArrayIndexOutOfBoundsException ignored){}
        try { attackingSquares.add(labels[x-2][y+1]); } catch (ArrayIndexOutOfBoundsException ignored){}
        try { attackingSquares.add(labels[x-2][y-1]); } catch (ArrayIndexOutOfBoundsException ignored){}
        try { attackingSquares.add(labels[x-1][y-2]); } catch (ArrayIndexOutOfBoundsException ignored){}

        return attackingSquares;
    }

    /**
     * A Method called after getting the Fieldlabel to determine if the Field can be accessed by the Knight
     * @param fieldLabel1 the Label the Knight could theoretically move to
     */
    private void addIfValid(FieldLabel fieldLabel1){
        if((fieldLabel1.hasPiece() && fieldLabel1.getPiece().getColor() != this.color)|| !fieldLabel1.hasPiece())
            validMoves.add(new Move(this.fieldLabel, fieldLabel1));
    }
}
//<>