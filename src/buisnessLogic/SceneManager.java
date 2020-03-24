package buisnessLogic;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneManager {
    private Stage stage;
    private FXMLLoader loader;
    private HashMap<String, Parent> sceneList;
    private String currentScene;
    private String currentTitle;
    private String previousScene;
    private String previousTitle;

    //Setting size of window
    private Rectangle2D primScreenBounds;
    private double stagesizex;
    private double stagesizey;

    public void getPreviousScene() throws IOException {
        switchScene(previousScene, previousTitle);
    }

    public Parent getCurrentScene() throws IOException {
        return sceneList.get(currentScene);
    }

    public void setSize(double x, double y) {
        stagesizex = x;
        stagesizey = y;
    }

    public double getSizeX() {
        return this.stagesizex;
    }

    public double getSizeY() {
        return this.stagesizey;
    }

    public SceneManager(Stage stage) {
        this(stage, Screen.getPrimary().getVisualBounds().getWidth() / 2, Screen.getPrimary().getVisualBounds().getHeight() / 1.5);
    }

    public SceneManager(Stage stage, double stagesizex, double stagesizey) {
        this.stage = stage;
        loader = new FXMLLoader();
        sceneList = new HashMap<>();
        this.stagesizex = stagesizex;
        this.stagesizey = stagesizey;
    }

    public void switchScene(String sceneName, String title) throws IOException {
        previousScene = currentScene;
        previousTitle = currentTitle;

        if(!sceneList.containsKey(sceneName)) {
            sceneList.put(sceneName, FXMLLoader.load(getClass().getResource(sceneName)));
        }

        currentScene = sceneName;
        currentTitle = title;
        stage.setTitle(title);
        stage.setScene(new Scene(sceneList.get(sceneName), stagesizex, stagesizey));
        stage.show();
    }
}