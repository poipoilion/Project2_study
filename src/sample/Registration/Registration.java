package sample.Registration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.DB.DBHandler;

public class Registration {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Butt_reg;

    @FXML
    private TextField Text_firstname;

    @FXML
    private TextField Text_secondname;

    @FXML
    private TextField Text_password;

    @FXML
    private TextField Text_login;

    @FXML
    private RadioButton rad_man;

    @FXML
    private RadioButton rad_wom;

    @FXML
    private Spinner spinner_age;

    @FXML
    private Text Text_Err;

    @FXML
    void initialize() {

        Butt_reg.setOnAction(event -> {
        String firstname= Text_firstname.getText().trim();
        String secondname= Text_secondname.getText().trim();
        String login= Text_login.getText().trim();
        String password= Text_password.getText().trim();
        String gender;
        if (rad_wom.isSelected()== true){
            gender = "Woman";
        }
        else {
            gender = "Man";
        }
        int age = (int) spinner_age.getValue();


        if ((firstname == "") || (secondname == "") || (login == "") || (password == "")){
            Text_Err.setVisible(true);
        }
        else {
            // переход на окно авторизации
            Butt_reg.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/Autorization/Autorization.fxml"));
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
            DBHandler in = new DBHandler();
            in.Insert(firstname,secondname,login,password,gender,Integer.toString(age));
        }

        });


        //Настраиваем радиобаттоны
        ToggleGroup group = new ToggleGroup();
        rad_man.setToggleGroup(group);
        rad_man.setSelected(true);
        rad_wom.setToggleGroup(group);

        //Настраиваем спиннер
        SpinnerValueFactory<Integer> gg = new SpinnerValueFactory.IntegerSpinnerValueFactory(18,99,20);
        spinner_age.setValueFactory(gg);





    }

}
