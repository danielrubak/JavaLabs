import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class NamesList {
    List<NameUnit> units = new ArrayList<>();
    Map<String, Long> nameToNumMale = new HashMap<>();
    Map<String, Long> nameToNumFemale = new HashMap<>();

    Map<String, Long> nameIn2000NumMale = new HashMap<>();
    Map<String, Long> nameIn2016NumMale = new HashMap<>();
    Map<String, Long> nameIn2000NumFemale = new HashMap<>();
    Map<String, Long> nameIn2016NumFemale = new HashMap<>();


    public void read(String filename) throws IOException {
        CSVReader reader = new CSVReader(filename,";",true);
        while(reader.next()) {
            int rok = reader.getInt("Rok");
            String imie = reader.get("Imię");
            long liczba = reader.getLong("Liczba");
            String plec = reader.get("Płeć");

            NameUnit unit = new NameUnit(rok, imie, liczba, plec);
            units.add(unit);

            if ( plec.equals("M") ) {
                if (!nameToNumMale.containsKey(imie)) {
                    nameToNumMale.put(imie, liczba);
                } else {
                    long licznik = nameToNumMale.get(imie);
                    licznik += liczba;
                    nameToNumMale.put(imie, licznik);
                }

                if (rok == 2000 ) {
                    nameIn2000NumMale.put(imie, liczba);
                } else if (rok == 2016) {
                    nameIn2016NumMale.put(imie, liczba);
                }
            } else if ( plec.equals("K") ){
                if (!nameToNumFemale.containsKey(imie)) {
                    nameToNumFemale.put(imie, liczba);
                } else {
                    long licznik = nameToNumFemale.get(imie);
                    licznik += liczba;
                    nameToNumFemale.put(imie, licznik);
                }

                if (rok == 2000 ) {
                    nameIn2000NumFemale.put(imie, liczba);
                } else if (rok == 2016) {
                    nameIn2016NumFemale.put(imie, liczba);
                }
            }
        }
    }

    void list( PrintStream out ){
        for( NameUnit unit : units ) {
            out.println(unit.toString());
        }
    }

    // nie zdazylem, ale pomysl byl porownywania dla kazdego umienia roznicy w 2000 i 2016 i trzymanie w pamieci
    // tylko najlepszego wyniku, w ten sposob na koniec, po kilku obliczeniach, wiedzialbym jak to procentowo wyglada
    void findMaxDifferentPercentage() {
        long max = -1;
        for(Map.Entry<String, Long> entry : nameIn2000NumMale.entrySet()) {
            if ( nameIn2016NumMale.containsKey(entry.getValue())) {

            }
        }
    }
}
