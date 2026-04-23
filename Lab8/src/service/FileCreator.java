package service;
import java.io.File;
import java.io.IOException;

public class FileCreator {

    public void ensureFileExists(File file) throws IOException {
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            if (!parent.mkdirs()) {
                throw new IOException("Не вдалося створити директорію: " + parent.getPath());
            }
        }

        if (!file.exists()) {
            boolean created = file.createNewFile();
            if (!created) {
                throw new IOException("Не вдалося створити файл: " + file.getPath());
            }
        }
    }
}
