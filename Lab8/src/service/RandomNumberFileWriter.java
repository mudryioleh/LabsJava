package service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumberFileWriter {

    private final Random random;

    public RandomNumberFileWriter() {
        this(new Random());
    }

    public RandomNumberFileWriter(Random random) {
        this.random = random;
    }

    public void writeRandomNumbers(File file, int b1, int b2, int count) throws IOException {
        if (b1 > b2) {
            throw new IllegalArgumentException("b1 має бути <= b2");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("кількість має бути > 0");
        }

        try (FileWriter writer = new FileWriter(file, false)) {
            for (int i = 0; i < count; i++) {
                int value = random.nextInt(b2 - b1 + 1) + b1;
                writer.write(Integer.toString(value));
                writer.write(System.lineSeparator());
            }
        }
    }
}
