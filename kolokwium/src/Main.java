import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class Main {

    static String readFile(String name, Charset charset){
        StringBuilder s = new StringBuilder();
        try( BufferedReader file = new BufferedReader(new InputStreamReader( new FileInputStream(name), charset))){
            for(;;){
                int c=file.read();
                if(c<0)break;
                s.append((char)c);
            }
            return s.toString();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }


    public static void main(String[] args) throws IOException {

        System.out.println("ZADANIE 1");
        NamesList unitsList = new NamesList();
        unitsList.read("src/imiona-2000-2016.csv");

        long sumaUrodzen = 0;
        for ( NameUnit unit : unitsList.units ) {
            sumaUrodzen += unit.getLiczba();
        }
        System.out.println("W latach 2000-2016 urodziło się " + sumaUrodzen + " dzieci!");

        long maxVal = -1;
        String name = "";
        for(Map.Entry<String, Long> entry : unitsList.nameToNumMale.entrySet()){
            if ( entry.getValue() > maxVal ) {
                maxVal = entry.getValue();
                name = entry.getKey();
            }
        }
        System.out.println("Najpopularniejsze imie meskie: " + name);

        String name1 = "";
        maxVal = -1;
        for(Map.Entry<String, Long> entry : unitsList.nameToNumFemale.entrySet()){
            if ( entry.getValue() > maxVal ) {
                maxVal = entry.getValue();
                name1 = entry.getKey();
            }
        }
        System.out.println("Najpopularniejsze imie zenskie: " +  name1);


        // zad 2
        System.out.println("\nZADANIE 2");
        String tekst = readFile("src/w-pustyni.txt", Charset.forName("cp1250")).toLowerCase();
        String[] slowa = tekst.split("[\\s|\\r|\\,|\\.|\\-|\\!|\\—|\\?]+");

        Map<Integer,Integer> wystapieniaSlow = new HashMap<>();
        for ( String slowo : slowa ) {
            int dlugoscSlowa = slowo.length();
            if ( !wystapieniaSlow.containsKey(dlugoscSlowa) ) {
                wystapieniaSlow.put(dlugoscSlowa, 1);
            } else {
                int licznik = wystapieniaSlow.get(dlugoscSlowa);
                licznik += 1;
                wystapieniaSlow.put(dlugoscSlowa, licznik);
            }
        }

        int najwiecejWystapien = -1;
        int szukanaDlugosc = 0;
        for(Map.Entry<Integer,Integer> entry : wystapieniaSlow.entrySet()){
            if ( entry.getValue() > najwiecejWystapien ) {
                najwiecejWystapien = entry.getValue();
                szukanaDlugosc = entry.getKey();
            }
        }

        System.out.println("Najwiecej razy wystapily slowa o dlugosci: " + szukanaDlugosc);
    }
}
