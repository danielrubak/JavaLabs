package lab7;

import java.io.IOException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        CSVReader reader1 = new CSVReader("src/lab7/admin-units.csv",",",true);
        for (int i = 0; i< 100; i++) {
            reader1.next();
            String name = reader1.get("name");
            //double population = reader1.getDouble("population");
            int admin_level = reader1.getInt("admin_level");

            System.out.printf(Locale.US,"%s %d\n",name, admin_level);
        }
    }
}
