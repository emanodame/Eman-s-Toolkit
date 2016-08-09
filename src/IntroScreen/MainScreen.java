package IntroScreen;

import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainScreen extends Application {
    private static Stage currentStage;
    private static FlowPane textLayout = new FlowPane(Orientation.VERTICAL);
    private static Scene textScene = new Scene(textLayout,600,300);
    private static Scene[] programSceneSequence = new Scene[1];
    private static int stagePosition = -1;

    public static Stage getCurrentStage(){
        return currentStage;
    }

    public static void previousPosition(){
        stagePosition -= 1;
    }

    public static int getStagePosition(){
        return stagePosition;
    }

    public static Scene[] getProgramSceneSequence(){
        return programSceneSequence;
    }

    public static void setProgramSceneSequence(Scene programScene) {
        if(stagePosition == programSceneSequence.length-1){
            Scene[] temp = new Scene[programSceneSequence.length*2];

            for(int i = 0; i < programSceneSequence.length; i++){
                temp[i] = programSceneSequence[i];
            }
            programSceneSequence = temp;
        }
        programSceneSequence[++stagePosition] = programScene;
    }

    private void textSetup(){
        Text titleText = new Text("Java 8 Practise");
        titleText.setFont(new Font(40));

        Text subTitle = new Text("Type in what you want me to do! :)");
        subTitle.setFont(new Font(20));

        textLayout.getChildren().add(titleText);
        textLayout.getChildren().add(subTitle);

        textLayout.setAlignment(Pos.TOP_CENTER);
    }

    private void inputSetup() {
        TextField inputField = new TextField();
        textLayout.getChildren().add(inputField);

        textLayout.setOnKeyPressed((event) -> {
            if (event.getCode() == KeyCode.ENTER) {
                new ProgramSelector(inputField.getText()).toolExecutor();
            }
        });
    }


    @Override
    public void start(Stage primaryStage){
        currentStage = primaryStage;

        textSetup();
        inputSetup();

        currentStage.setTitle("ROBOT V1!");
        currentStage.setScene(textScene);
        currentStage.show();

        setProgramSceneSequence(primaryStage.getScene());

    }
}
