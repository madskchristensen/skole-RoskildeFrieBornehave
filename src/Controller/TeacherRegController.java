package Controller;

import Business.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class TeacherRegController {
    public Button buttonShifts;
    public Button buttonChild;
    public Button buttonParent;
    public Button buttonTeacherLogOut;

    public void handleShiftPlan(ActionEvent actionEvent) {
    }

    public void handleChildren(ActionEvent actionEvent) {
    }

    public void handleGuardians(ActionEvent actionEvent) {
    }

    public void handleLogout(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.switchScene("Login.fxml", "Login");
    }
}
