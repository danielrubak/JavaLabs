import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class NameUnitList {
    List<NameUnit> units = new ArrayList<>();
    Map<String, Long> maleNameToNumberOfBirths = new HashMap<>();
    Map<String, Long> femaleNameToNumberOfBirths = new HashMap<>();
    Map<String, List<Long>> maleNameToBirthInParticularYears = new HashMap<String, List<Long>>();
    Map<String, List<Long>> femaleNameToBirthInParticularYears = new HashMap<String, List<Long>>();
    long birthTotal = 0;

    public void read(String filename) throws IOException {
        CSVReader reader = new CSVReader(filename, ";", true);
        while (reader.next()) {
            int year = reader.getInt("Rok");
            String name = reader.get("Imię");
            long birthCount = reader.getLong("Liczba");
            String gender = reader.get("Płeć");

            NameUnit unit = new NameUnit(year, name, birthCount, gender);
            units.add(unit);
            birthTotal += birthCount;

            if (gender.equals("M")) {
                if (!maleNameToNumberOfBirths.containsKey(name))
                    maleNameToNumberOfBirths.put(name, birthCount);
                else
                    maleNameToNumberOfBirths.put(name, maleNameToNumberOfBirths.get(name) + birthCount);

                if (!maleNameToBirthInParticularYears.containsKey(name)) {
                    List<Long> yearsList = new ArrayList<>();
                    yearsList.add(birthCount);
                    maleNameToBirthInParticularYears.put(name, yearsList);
                } else {
                    List<Long> yearsList = maleNameToBirthInParticularYears.get(name);
                    yearsList.add(birthCount);
                    maleNameToBirthInParticularYears.put(name, yearsList);
                }
            } else if (gender.equals("K")) {
                if (!femaleNameToNumberOfBirths.containsKey(name))
                    femaleNameToNumberOfBirths.put(name, birthCount);
                else
                    femaleNameToNumberOfBirths.put(name, femaleNameToNumberOfBirths.get(name) + birthCount);

                if (!femaleNameToBirthInParticularYears.containsKey(name)) {
                    List<Long> yearsList = new ArrayList<>();
                    yearsList.add(birthCount);
                    femaleNameToBirthInParticularYears.put(name, yearsList);
                } else {
                    List<Long> yearsList = femaleNameToBirthInParticularYears.get(name);
                    yearsList.add(birthCount);
                    femaleNameToBirthInParticularYears.put(name, yearsList);
                }
            }
        }
    }

    void list(PrintStream out) {
        for (NameUnit unit : units) {
            out.println(unit.toString());
        }
    }

    long getBirthTotal() {
        return this.birthTotal;
    }

    String getMostPopularName(String gender) {
        Map.Entry<String, Long> maxEntry = null;
        if (gender.equals("M")) {
            for (Map.Entry<String, Long> entry : this.maleNameToNumberOfBirths.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                    maxEntry = entry;
            }
        } else if (gender.equals("K")) {
            for (Map.Entry<String, Long> entry : this.femaleNameToNumberOfBirths.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                    maxEntry = entry;
            }
        }
        if (maxEntry != null) {
            return maxEntry.getKey();
        } else
            return "Name not found!";
    }

    Map<String, Double> getMostPercentageBirthDifference(String gender) {
        double maxDiff = 0;
        String name = "";
        Map<String, Double> result = new HashMap<>();
        Map<String, List<Long>> unitsList = (gender.equals("M") ? maleNameToBirthInParticularYears : femaleNameToBirthInParticularYears);

        for (Map.Entry<String, List<Long>> entry : unitsList.entrySet()) {
            long firstValue = entry.getValue().get(0);
            long secondValue = entry.getValue().get(entry.getValue().size() - 1);
            if (firstValue > secondValue) {
                long temp = secondValue;
                secondValue = firstValue;
                firstValue = temp;
            }
            double diff = ((secondValue - firstValue)*100)/firstValue;
            if (diff > maxDiff) {
                maxDiff = diff;
                name = entry.getKey();
            }
        }
        result.put(name, maxDiff);
        return result;
    }
}
