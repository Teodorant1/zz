package sample;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



public abstract class Controller extends vidya implements ButtonActions  {
    @FXML
    TextField screenusername;
    public void setUsername1(KeyEvent keyEvent) { setUserName(screenusername.getText());
    }

    @FXML
    PasswordField screenpassword;
    public void setPassword1(KeyEvent keyEvent) { setPassword(screenpassword.getText());
    }

    public void shizzlesticks1(MouseEvent mouseEvent)  {

if (screenusername.getText() != "1" && screenpassword.getText() != "1")
    try {
        Stage stage = new Stage();
        {
            start(stage);

        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally { System.exit(0);

    }
    }




}
