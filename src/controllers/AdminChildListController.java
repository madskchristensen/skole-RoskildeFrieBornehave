package controllers;

import buisnessLogic.SceneManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminChildListController {

    public javafx.scene.control.TableColumn ID;
    public javafx.scene.control.TableColumn firstName;
    public javafx.scene.control.TableColumn lastName;
    public javafx.scene.control.TableColumn classroom;
    public Button back;
    public Button guardian;
    public Button create;
    public Button update;
    public Button delete;

    public void readGuardian(ActionEvent actionEvent) throws IOException {
            SceneManager sceneManager = new SceneManager(new Stage());
            sceneManager.setSize(250,200);
            sceneManager.switchScene("PopUp.fxml", "Værger");
        }


    public void goBack(ActionEvent actionEvent) {
    }

    public void addToChildList(ActionEvent actionEvent) {
    }

    public void updateChildList(ActionEvent actionEvent) {
    }

    public void deleteFromChildList(ActionEvent actionEvent) {
    }


   /*public void initialize() {
        TableColumn id = new TableColumn("ID");
        TableColumn firstName = new TableColumn("firstName");
        TableColumn lastName = new TableColumn("lastName");
        TableColumn classroom = new TableColumn("class");
    }
*/


}