import IntroScreen.StartScreen;
import ProgramUtil.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void init() {
    }

    @Override
    public void start(final Stage stage) {
        SceneManager.uploadStage(stage);
        StartScreen startScreen = StartScreen.getInstance();

        stage.setTitle("ROBOT V1.1");
        stage.setScene(startScreen.getScene());
        stage.show();
    }
}
