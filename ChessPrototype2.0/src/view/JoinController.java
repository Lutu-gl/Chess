package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class JoinController {
    @FXML
    public ImageView backgroundImage;
    public AnchorPane pane;
    public Label text;
    public Button connectButton;
    public TextField ipField;

    public void initialize() {
        int pic = (int) (Math.floor(Math.random()*5)) + 1;
        System.out.println(pic);
        Image image = new Image(Main.class.getResourceAsStream("/wallpaper"+pic+".jpg"));
        backgroundImage.setImage(image);
        backgroundImage.setFitHeight(800.0);
        backgroundImage.setFitWidth(image.getWidth());
        double width = (image.getWidth()*800)/image.getHeight()-1;
        pane.setPrefWidth(width);
        text.setLayoutX(width/3);
        connectButton.setLayoutX(width/3);
        ipField.setLayoutX(width/3);


        connectButton.setOnAction(e -> {
            if (!ipField.getText().matches("^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$")) // Sick regex to check if IP is valid
                return;
            System.out.println("Versuche zu verbinden!");
        });

    }
}