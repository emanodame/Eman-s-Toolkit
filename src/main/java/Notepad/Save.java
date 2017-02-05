package Notepad;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.List;

public class Save {
    private TextArea textArea;
    private List<Character> leftOverChar;
    //private File file = new File(Writer.getFileName());

    public Save(TextArea textArea) throws IOException {
        this.textArea = textArea;
       // fileChecker(file);
        //skipToNewChanges();
        //writerOperation();
    }

/*    private void fileChecker(File file) {
        if (file.exists()) {
            return;
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private char[] fileToArray() throws IOException {

        return Files.lines(Paths.
                get(Writer.getFileName()))
                .collect(Collectors.joining("\n")).toCharArray();
    }

    private void skipToNewChanges() throws IOException {


        Stream<Character> cStream = IntStream
                .range(0, notepadText.length)
                .mapToObj(i -> notepadText[i]);

        leftOverChar = cStream
                .skip(savedText.length)
                .collect(Collectors.toList());
    }

    private void writerOperation() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

            leftOverChar.stream()
                    .forEach(newChar -> {
                        try {
                            writer.append(newChar);
                        } catch (IOException e) {
                            System.out.println(e.getCause());
                        }
                    });
        }
    }*/

    public static void main(String[] args) {

        char[] savedText = new char[2];//whatever is in the file
        char[] notepadText = new char[4]; //whatever is in the textarea


        savedText[0] = '1';
        notepadText[0] = '1';

        savedText[1] = '1';
        notepadText[1] = '1';

        notepadText[2] = '9';
        notepadText[3] = 'k';


        int leftOvers = savedText.length;

        for (int i = leftOvers; i < notepadText.length; i++) {
            System.out.print(notepadText[i]);

        }

    }
}
