package main.java1.net.thoughtmachine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vika on 21/05/2016.
 */
public class FileReader {

    public List<String> fileReader(String inputFilePath) {
        ArrayList<String> lines = new ArrayList<>();

        try {
            return Files.readAllLines(Paths.get(inputFilePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

}
