package lab6;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        CSVReader reader1 = new CSVReader("C:\\Users\\danie\\Documents\\po2018-daniel-rubak\\src\\lab6\\csv_utc8\\no-header.csv",";",false);
        while(reader1.next()){
            int id = reader1.getInt("id");
            String name = reader1.get("imię");

            System.out.printf(Locale.US,"%d %s\n",id, name);
        }

        CSVReader reader2 = new CSVReader("C:\\Users\\danie\\Documents\\po2018-daniel-rubak\\src\\lab6\\csv_utc8\\with_header.csv",";",true);
        while(reader2.next()){
            int id = reader2.getInt(0);

            System.out.printf(Locale.US,"%d\n",id);
        }
    }
}
