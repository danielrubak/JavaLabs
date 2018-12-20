import java.io.IOException;

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

        System.out.println("\nSelect administrative units from the list which names matches to pattern 'Kraków' and print theirs coords:");
        for (AdminUnit adminUnit : unitsList.selectByName("Kraków", false).units) {
            System.out.println(adminUnit.toString());
            System.out.println(adminUnit.getBbox().getWKT());
        }
    }
}
