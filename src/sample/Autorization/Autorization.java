package sample.Autorization;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import sample.DB.Test;

public class Autorization {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Butt_log;

    @FXML
    private TextField Text_passw;

    @FXML
    private TextField Text_log;

    @FXML
    private Button Butt_reg;

    @FXML
    private Text Text_Err;


    @FXML
    void initialize() {
        Butt_log.setOnAction(event -> {
            Test n= new Test();
            n.main();
            /*
            String loginText= Text_log.getText().trim();
            String passwordText= Text_passw.getText().trim();
            if ((loginText == "") || (passwordText == "")){
                Text_Err.setVisible(true);
            }
            else {
                // открываем EnterWind
                Butt_log.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/EnterWind/EnterWind.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("ERROR: " + e);
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                ////
                Text_Err.setVisible(false);


            } */

        });
        Butt_reg.setOnAction(event -> {
            Butt_reg.getScene().getWindow().hide();
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Registration/Registration.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("ERROR: "+ e);
            }
            Parent root= loader.getRoot();
            Stage stage= new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });


    }
}