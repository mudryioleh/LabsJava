package service;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileContentReader {

    public String readAll(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (FileReader reader = new FileReader(file)) {
            char[] buffer = new char[1024];
            int read;
            while ((read = reader.read(buffer)) != -1) {
                content.append(buffer, 0, read);
            }
        }
        return content.toString();
    }
}
