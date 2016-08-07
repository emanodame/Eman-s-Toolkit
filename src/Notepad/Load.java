package Notepad;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Load {

    public static String loadTextFromFile() throws IOException {
        return Files.lines(Paths.get(Writer.getFileName()))
                .collect(Collectors.joining("\n"));
    }
}
