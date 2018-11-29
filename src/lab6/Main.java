package lab6;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] CSVfiles = new String[6];
        String OS = System.getProperty("os.name").toLowerCase();
        if ( OS.indexOf("win") >= 0 ) {
            CSVfiles[0] = "src\\lab6\\csv_utc8\\no-header.csv";
            CSVfiles[1] = "src\\lab6\\csv_utc8\\with-header.csv";
            CSVfiles[2] = "src\\lab6\\csv_utc8\\accelerator.csv";
            CSVfiles[3] = "src\\lab6\\csv_utc8\\elec.csv";
            CSVfiles[4] = "src\\lab6\\csv_utc8\\missing-values.csv";
            CSVfiles[5] = "src\\lab6\\csv_utc8\\titanic-part.csv";

        } else if ( OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
            CSVfiles[0] = "src/lab6/csv_utc8/no-header.csv";
            CSVfiles[1] = "src/lab6/csv_utc8/with-header.csv";
            CSVfiles[2] = "src/lab6/csv_utc8/accelerator.csv";
            CSVfiles[3] = "src/lab6/csv_utc8/elec.csv";
            CSVfiles[4] = "src/lab6/csv_utc8/missing-values.csv";
            CSVfiles[5] = "src/lab6/csv_utc8/titanic-part.csv";

        }

        int [] testsToRun = {0, 0, 0, 0, 1, 0};
        if ( testsToRun[0] == 1 ) {
            CSVReader reader0 = new CSVReader(CSVfiles[0],";",false);
            System.out.printf("Filename: %s\n", CSVfiles[0]);
            while(reader0.next()){
                int id = reader0.getInt(0);
                String name = reader0.get(1);
                String surname = reader0.get(2);
                String address = reader0.get(3);
                int firstNum = reader0.getInt(4);
                int secondNum = reader0.getInt(5);
                System.out.printf(Locale.US,"%d: %s %s, %s %d/%d\n",id, name, surname, address, firstNum, secondNum);
            }
            System.out.println();
        }

        if ( testsToRun[1] == 1 ) {
            CSVReader reader1 = new CSVReader(CSVfiles[1],";",true);
            System.out.printf("Filename: %s\n", CSVfiles[1]);
            while(reader1.next()) {
                int id = reader1.getInt("id");
                String name = reader1.get("imię");
                String surname = reader1.get("nazwisko");
                String address = reader1.get("ulica");
                int firstNum = reader1.getInt("nrdomu");
                int secondNum = reader1.getInt("nrmieszkania");
                System.out.printf(Locale.US,"%d: %s %s, %s %d/%d\n",id, name, surname, address, firstNum, secondNum);
            }
            System.out.println();
        }

        if ( testsToRun[2] == 1 ) {
            CSVReader reader2 = new CSVReader(CSVfiles[2],";",true);
            System.out.printf("Filename: %s\n", CSVfiles[2]);
            while(reader2.next()) {
                double x = reader2.getDouble("X");
                double y = reader2.getDouble("Y");
                double z = reader2.getDouble("Z");
                double longitude = reader2.getDouble("longitude");
                double latitude = reader2.getDouble("latitude");
                int speed = reader2.getInt("speed");
                int label = reader2.getInt("label");
                System.out.printf(Locale.US,"(%f, %f, %f); Longitude: %f, Latitude: %f\n", x, y, z, longitude, latitude);
            }
            System.out.println();
        }

        if ( testsToRun[3] == 1 ) {
            CSVReader reader3 = new CSVReader(CSVfiles[3],";",true);
            System.out.printf("Filename: %s\n", CSVfiles[3]);
            while (reader3.next()) {

            }
            System.out.println();
        }

        if ( testsToRun[4] == 1 ) {
            CSVReader reader4 = new CSVReader(CSVfiles[4],";",true);
            System.out.printf("Filename: %s\n", CSVfiles[4]);
            while (reader4.next()) {
                long id = (reader4.isMissing("id") ? 0 : reader4.getInt("id"));
                long parent = (reader4.isMissing("parent") ? -1 : reader4.getInt("parent"));
                String name = (reader4.isMissing("name") ? "-" : reader4.get("name"));
                int admin_level = (reader4.isMissing("admin_level") ? -1 : reader4.getInt("admin_level"));
                double density = (reader4.isMissing("density") ? -1.0 : reader4.getDouble("density"));
                //admin_level;population;area;density

                System.out.printf(Locale.US,"%d: %d Name: %s, Level: %d, Density: %f \n", id, parent, name, admin_level, density);
            }
            System.out.println();
        }

        if ( testsToRun[5] == 1 ) {
            CSVReader reader5 = new CSVReader(CSVfiles[5],";",true);
            System.out.printf("Filename: %s\n", CSVfiles[5]);
            while (reader5.next()) {

            }
            System.out.println();
        }

    }
}
