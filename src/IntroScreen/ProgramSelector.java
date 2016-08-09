package IntroScreen;
import GradeCalculator.Initialinput;
import Notepad.Writer;
import PushToPhone.PushInfoToPhone;

public class ProgramSelector  {
    private String optionText;

    public ProgramSelector(String optionText) {
        this.optionText = optionText;
    }

    public void toolExecutor() {
        switch (optionText){
            case "calc":
                new Initialinput().foundationMaker();
                break;

            case "txt":
                  /*  if(new PasswordValidation().verify()){
                        MainScreen.getCurrentStage().setScene(new Writer().getNotepadScene());
                    }*/
                MainScreen.getCurrentStage().setScene(new Writer().getNotepadScene());
                MainScreen.setProgramSceneSequence(new Writer().getNotepadScene());
                break;

            case "psh":
                MainScreen.getCurrentStage().setScene(new PushInfoToPhone().getPushWriterScene());
                MainScreen.setProgramSceneSequence(new PushInfoToPhone().getPushWriterScene());
                break;
        }
    }
}
