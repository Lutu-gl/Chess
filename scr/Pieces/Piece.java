package Pieces;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import Chess.Color;

public abstract class Piece {

    ImageView img;
    Label l;
    boolean isAlive = true;
    Color color;
    String name;

    public Piece(ImageView img, Label l, Color color, String name){
        img.setFitHeight(80);
        img.setPreserveRatio(true);
        this.img = img;
        this.l = l;
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public Label getL() {
        return l;
    }

    public void setL(Label l) {
        this.l = l;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Piece{" +
                "img=" + img.getImage().getUrl() +
                ", l=" + l +
                ", isAlive=" + isAlive +
                ", color=" + color +
                ", name='" + name + '\'' +
                '}';
    }

}
