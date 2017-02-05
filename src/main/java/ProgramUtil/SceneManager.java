package ProgramUtil;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Stack;

public class SceneManager {
    private static Stage masterStage;
    private final static Stack<Scene> sceneTracker = new Stack<>();

    public static void uploadStage(final Stage stage) {
        masterStage = stage;
    }

    public static void loadScene(final Scene scene) {
        masterStage.setScene(scene);
    }

    public static void saveScene(final Scene scene) {
        sceneTracker.push(scene);
    }

    public static void previousScene() {
        masterStage.setScene(sceneTracker.pop());
        System.out.println(sceneTracker);
    }

}
