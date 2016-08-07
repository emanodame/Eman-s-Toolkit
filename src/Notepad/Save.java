package Notepad;

import javafx.scene.control.TextArea;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Save {
    private TextArea textArea;
    private List<Character> leftOverChar;
    private File file = new File(Writer.getFileName());

    public Save(TextArea textArea) throws IOException {
        this.textArea = textArea;
        skipToNewChanges();
        writerOperation();
    }

    private char[] fileToArray() throws IOException {

        return Files.lines(Paths.
                get(Writer.getFileName()))
                .collect(Collectors.joining("\n")).toCharArray();
    }

    private void skipToNewChanges() throws IOException{
        char[] noteTextArray = fileToArray();
        char[] textAreaArray = textArea.getText().toCharArray();

        Stream<Character> cStream = IntStream.range(0,textAreaArray.length)
                .mapToObj(i -> textAreaArray[i]);

        leftOverChar = cStream.skip(noteTextArray.length)
                .collect(Collectors.toList());
    }

    private void writerOperation() throws IOException  {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            leftOverChar.stream()
                    .forEach(newChar -> {
                        try{
                            writer.append(newChar);
                        }catch(IOException e){
                            System.out.println(e.getCause());
                        }
                    });
        }
    }
}
