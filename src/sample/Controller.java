package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Controller {

    @FXML
    private PasswordField passwordField;

    public void submit() {
        checkPassword();
    }

    private void checkPassword() {
        int pWordCount = 0;
        try {
            String dir = System.getProperty("user.dir");
            File f = new File(dir + "/data.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            while ((readLine = b.readLine()) != null) {
                if (readLine.equals(passwordField.getText())) {
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Your password has been used and is not safe!");
                    alert.setTitle("Unsafe password");
                    alert.setHeaderText("Password is unsafe");
                    alert.show();
                    break;
                }
                pWordCount++;
            }
            if (readLine == null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Well done, your password is safe. for now...");
                alert.setTitle("Safe password");
                alert.setHeaderText("Password is safe");
                alert.show();
            }
            System.out.println(pWordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

