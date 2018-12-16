import java.io.IOException;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws IOException {

        String csvFilePath = "";
        String OS = System.getProperty("os.name").toLowerCase();
        if ( OS.indexOf("win") >= 0 ) {
            csvFilePath = "src/admin-units.csv";
        } else if ( OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
            csvFilePath = "src\\admin-units.csv";
        }

        AdminUnitList unitsList = new AdminUnitList();
        unitsList.read(csvFilePath);

        // Simple tests
        System.out.println("Select 10 administrative units from the list beginning with the tenth element");
        unitsList.list(System.out, 10, 10);

        System.out.println("\nSelect only this administrative units which name starts with \"Ż\"");
        unitsList.filter(a->a.name.startsWith("Ż")).sortByArea().list(out);

        System.out.println("\nSelect max 100 administrative units which name starts with \"Sz\" or area is greater than 1000 and sort them by area");
        AdminUnitQuery query = new AdminUnitQuery()
                .selectFrom(unitsList)
                .where(a->a.area>1000)
                .or(a->a.name.startsWith("Sz"))
                .sort((a,b)->Double.compare(a.area,b.area))
                .limit(100);
        query.execute().list(out);
    }
}
