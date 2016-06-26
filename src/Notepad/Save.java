package Notepad;

import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Save {
    private TextArea textArea;
    private File file = new File(Writer.getFileName());

    public Save(TextArea textArea) {
        this.textArea = textArea;
    }

    public void saveToFile(){
        writerOperation();
    }

    private void writerOperation(){
        ObservableList<CharSequence> paragraph = textArea.getParagraphs();
        Iterator<CharSequence> it = paragraph.iterator();

        try( BufferedWriter bf = new BufferedWriter(new FileWriter(file,true))){

            while(it.hasNext()){
                CharSequence seq = it.next();
                bf.append(seq);
                bf.newLine();
            }

            bf.flush();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
