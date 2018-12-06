package lab7;

import java.io.IOException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        //CSVReader reader = new CSVReader("src/lab7/admin-units.csv",",",true);
        /*CSVReader reader = new CSVReader("src\\lab7\\admin-units.csv", ",", true);
        for (int i = 0; i< 100; i++) {
            reader.next();
            String name = reader.get("name");
            double population = reader.getDouble("population");
            int admin_level = reader.getInt("admin_level");

            System.out.printf(Locale.US,"%s %d\n",name, admin_level);
        }*/

        AdminUnitList unitsList = new AdminUnitList();
        unitsList.read("src\\lab7\\admin-units.csv");

        //unitsList.list(System.out, 10, 10);

        AdminUnitList unitsSelectedByName = new AdminUnitList();
        unitsSelectedByName = unitsList.selectByName(".*powiat.*", true);
        unitsSelectedByName.list(System.out);
    }
}
