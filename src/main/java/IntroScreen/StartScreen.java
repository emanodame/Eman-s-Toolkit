package IntroScreen;

import GradeCalculator.Initialinput;
import Notepad.Writer;
import ProgramUtil.SceneManager;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartScreen {

    private static StartScreen startScreenInstance;
    private static FlowPane textLayout = new FlowPane(Orientation.VERTICAL);
    private static Scene scene = new Scene(textLayout, 600, 300);

    static {
        textSetup();
        inputSetup();
    }

    public static StartScreen getInstance() {
        return startScreenInstance == null ? startScreenInstance = new StartScreen() : startScreenInstance;
    }

    public Scene getScene() {
        return scene;
    }

    private static void saveCurrentScene() {
        SceneManager.saveScene(scene);
    }

    private static void textSetup() {
        final Text titleText = new Text("Eman's Toolkit");
        titleText.setFont(new Font(40));

        final Text subTitle = new Text("Type in what you want me to do! :)");
        subTitle.setFont(new Font(20));

        textLayout.getChildren().add(titleText);
        textLayout.getChildren().add(subTitle);

        textLayout.setAlignment(Pos.TOP_CENTER);
    }

    private static void inputSetup() {
        final TextField inputField = new TextField();
        textLayout.getChildren().add(inputField);

        textLayout.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                new ProgramSelector().toolExecutor(inputField.getText());
            }
        });
    }

    private static class ProgramSelector {

        private void toolExecutor(final String optionText) {

            switch (optionText.toLowerCase()) {

                case "calc" :
                    new Initialinput().foundationMaker();
                    break;

                case "txt" :
                    final Writer writerProgram = new Writer();
                    SceneManager.loadScene(writerProgram.getNotepadScene());
                    saveCurrentScene();
                    break;

                case "psh" :
                    //  App.getCurrentStage().setScene(new PushInfoToPhone().getPushWriterScene());
                    //App.setProgramSceneSequence(new PushInfoToPhone().getPushWriterScene());
                    break;

                case "rss":
                    // App.getCurrentStage().setScene(new RSSReader().getRssReaderScene());
            }
        }

    }

}
