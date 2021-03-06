package PushToPhone;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class PushInfoToPhone {
    private FlowPane notepadLayout = new FlowPane(Orientation.VERTICAL);
    private Scene pushWriterScene = new Scene(notepadLayout, 600, 300);
    private TextArea inputArea = new TextArea();

    public Scene getPushWriterScene() {
        notepadLayoutSetup();
       // previousWindow();
        return pushWriterScene;
    }

    private void notepadLayoutSetup() {
        Text titleText = new Text("Send info straight to phoney");
        titleText.setFont(new Font(36));
        titleText.setTextAlignment(TextAlignment.CENTER);

        notepadLayout.getChildren().add(titleText);
        notepadLayout.getChildren().add(inputArea);
        notepadLayout.setAlignment(Pos.TOP_CENTER);
    }

/*    private void previousWindow(){
        inputArea.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.ESCAPE){
                App.previousPosition();
                App.getCurrentStage().setScene(App.getProgramSceneSequence()[App.getStagePosition()]);
            }
        });
    }*/
}
