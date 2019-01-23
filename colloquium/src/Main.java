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
import static java.lang.System.setErr;

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
        // Load a file containing information on the number of births in the years 2000-2016, grouped by year, name and gender.
        // Calculate the sum of all births.
        // Determine which male and female names were the most popular in the years 2000-2016
        // Find names which popularity in the years 2000-2016 has changed the most.

        out.println("Exercise 1");
        NameUnitList unitsList = new NameUnitList();
        unitsList.read("src/imiona-2000-2016.csv");
        out.println("Total birth in the years 2000-2016: " + unitsList.getBirthTotal());
        out.println("The most popular male name in the years 2000-2016: " + unitsList.getMostPopularName("M"));
        out.println("The most popular female name in the years 2000-2016: " + unitsList.getMostPopularName("K"));
        Map<String, Double> result = null;
        result = unitsList.getMostPercentageBirthDifference("M");
        for (Map.Entry<String, Double> entry : result.entrySet())
            out.println("The popularity of the name '" + entry.getKey() + "' has changed by " + entry.getValue() + "%.");
        result = unitsList.getMostPercentageBirthDifference("K");
        for (Map.Entry<String, Double> entry : result.entrySet())
            out.println("The popularity of the name '" + entry.getKey() + "' has changed by " + entry.getValue() + "%.");

        // Exercise 2
        // Load a text file and calculate which word length occurred most often
        out.println("\nExercise 2");
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
                out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : wordLengthToOccur.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                maxEntry = entry;
        }

        out.println("Words of length '" + maxEntry.getKey() + "' occurred the most.");
    }
}
