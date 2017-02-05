package Notepad;

import ProgramUtil.SceneManager;
import ProgramUtil.SceneNavigator;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Writer implements SceneNavigator {

    private final String fileName = "Notes.txt";
    private final static FlowPane notepadLayout = new FlowPane(Orientation.VERTICAL);
    private final static Scene notepadScene = new Scene(notepadLayout, 600, 300);
    private final static TextArea inputArea = new TextArea("Write here ;p");

    static {
        notepadLayoutSetup();
        previousWindow();
    }

    public Writer() {
    }

    public Scene getNotepadScene() {
        return notepadScene;
    }

    private static void notepadLayoutSetup() {
        Text titleText = new Text("Eman's Notepad :)");
        titleText.setFont(new Font(36));
        titleText.setTextAlignment(TextAlignment.CENTER);

        notepadLayout.getChildren().add(titleText);
        notepadLayout.getChildren().add(inputArea);
        notepadLayout.setAlignment(Pos.TOP_CENTER);
    }

    private static void previousWindow() {
        notepadScene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode().equals(KeyCode.ESCAPE)) {
                SceneManager.previousScene();
                key.consume();
            }
        });
    }

    private class WriterFunctionality {

        private void loadTextToScreen() {
            inputArea.setText(loadTextFromFile());
        }

        private void notepadSaveText() {
            inputArea.setOnKeyPressed((event) -> {
                if (event.isControlDown() && event.getCode() == KeyCode.S) {
                    try {
                        new Save(inputArea);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        private String loadTextFromFile() {
            try {
                return Files.lines(Paths.get("Notes.txt"))
                        .collect(Collectors.joining("\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }

}

