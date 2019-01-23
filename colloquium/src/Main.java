import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class Main {

    static String readFile(String name, Charset charset) {
        StringBuilder s = new StringBuilder();
        try (BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(name), charset))) {
            while (true) {
                int c = file.read();
                if (c < 0) break;
                s.append((char) c);
            }
            return s.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        // if debugMode is on then validation outputs will occurred on console
        boolean debugMode = false;

        // Exercise 1
        // Task description (to do later)

        // Exercise 2
        // Load a text file and calculate which word length occurred most often
        System.out.println("\nExercise 2");
        String inputFromFile = readFile("src/w-pustyni.txt", Charset.forName("cp1250")).toLowerCase();
        String[] wordsArray = inputFromFile.split("[\\s|\\r|\\,|\\.|\\-|\\!|\\—|\\?]+");

        Map<Integer, Integer> wordLengthToOccur = new HashMap<>();
        for (String word : wordsArray) {
            int wordLength = word.length();
            if (!wordLengthToOccur.containsKey(wordLength)) {
                wordLengthToOccur.put(wordLength, 1);
            } else {
                wordLengthToOccur.put(wordLength, wordLengthToOccur.get(wordLength) + 1);
            }
        }

        if (debugMode) {
            for (Map.Entry<Integer, Integer> entry : wordLengthToOccur.entrySet())
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : wordLengthToOccur.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                maxEntry = entry;
        }

        System.out.println("Words of length '" + maxEntry.getKey() + "' occurred the most.");
    }
}
