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

        System.out.println("ZADANIE 1");
        NamesList unitsList = new NamesList();
        unitsList.read("src/imiona-2000-2016.csv");

        long sumaUrodzen = 0;
        for (NameUnit unit : unitsList.units) {
            sumaUrodzen += unit.getLiczba();
        }
        System.out.println("W latach 2000-2016 urodziło się " + sumaUrodzen + " dzieci!");

        long maxVal = -1;
        String name = "";
        for (Map.Entry<String, Long> entry : unitsList.nameToNumMale.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                name = entry.getKey();
            }
        }
        System.out.println("Najpopularniejsze imie meskie: " + name);

        String name1 = "";
        maxVal = -1;
        for (Map.Entry<String, Long> entry : unitsList.nameToNumFemale.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                name1 = entry.getKey();
            }
        }
        System.out.println("Najpopularniejsze imie zenskie: " + name1);


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

//        for (Map.Entry<Integer, Integer> entry : wordLengthToOccur.entrySet())
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : wordLengthToOccur.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                maxEntry = entry;
        }

        System.out.println("Words of length '" + maxEntry.getKey() + "' occurred the most.");
    }
}
