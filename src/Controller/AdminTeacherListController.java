package Controller;

import Business.Main;
import Business.MemberRepository;
import Business.TableManager;
import Business.TeacherRepository;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminTeacherListController implements Initializable {

    public GridPane gridPane;
    public Button back;
    public Button guardian;
    public Button update;
    public Button delete;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            TableManager tableManager = new TableManager();
            //pass the Column names and column properties to the createTable method
            String[] colNavn = new String[]{"ID", "Fornavn", "Efternavn", "Adresse", "Telefon Nummer", "E-mail"};
            //the column Properties (colProp) are the names of the class attributes you want to read
            String[] colProp = new String[]{"id", "firstName", "lastName", "address", "phoneNumber", "email"};
            //the column name and property arrays must run in the same order
            MemberRepository teacherRepository = new TeacherRepository("administrator", "admin_pass");
            //initialize the table
            TableView table = tableManager.createTable(colNavn, colProp, teacherRepository.getAllMembers());
            //add table to fxml
            gridPane.add(table, 0, 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        Main.sceneManager.getPreviousScene();
    }

    public void readTeacherShift(ActionEvent actionEvent) {
    }

    public void updateTeacherList(ActionEvent actionEvent) {
    }

    public void deleteFromTeacherList(ActionEvent actionEvent) {
    }
}
