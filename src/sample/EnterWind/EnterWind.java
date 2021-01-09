package sample.EnterWind;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EnterWind {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Image1;

    @FXML
    void initialize() {
        Image1.setOnMouseClicked(event ->{
            Image1.getScene().getWindow().hide();
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Autorization/Autorization.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root= loader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });


    }
}
