import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {
    BufferedReader reader;
    String delimiter;
    boolean hasHeader;
    String[] current;

    List<String> columnLabels = new ArrayList<>();
    Map<String, Integer> columnLabelsToInt = new HashMap<>();

    public CSVReader(String filename, String delimiter, boolean hasHeader) throws IOException {
        reader = new BufferedReader(new FileReader(filename));
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if (hasHeader)
            parseHeader();
    }

    public CSVReader(String filename, String delimiter) throws IOException {
        this(filename, ",", true);
    }

    public CSVReader(String filename) throws IOException {
        this(filename, ",");
    }

    public CSVReader(BufferedReader reader, String delimiter, boolean hasHeader) throws IOException {
        this.reader = reader;
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if (hasHeader)
            parseHeader();
    }

    void parseHeader() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            return;
        }

        String[] header = line.split(delimiter);
        for (int i = 0; i < header.length; i++) {
            columnLabels.add(header[i]);
            columnLabelsToInt.put(header[i], i);
        }
    }

    boolean next() throws IOException {
        String line = reader.readLine();
        if (line == null) {
            return false;
        } else {
            current = line.split(delimiter);
            return true;
        }
    }

    int getInt(String columnLabel) throws NullPointerException {
        int arrIndex = columnLabelsToInt.get(columnLabel);
        return Integer.parseInt(current[arrIndex]);
    }

    int getInt(int columnIndex) {
        return Integer.parseInt(current[columnIndex]);
    }

    String get(String columnLabel) {
        int arrIndex = columnLabelsToInt.get(columnLabel);
        return current[arrIndex];
    }

    String get(int columnIndex) {
        return current[columnIndex];
    }

    double getDouble(String columnLabel) {
        int arrIndex = columnLabelsToInt.get(columnLabel);
        return Double.parseDouble(current[arrIndex]);
    }

    double getDouble(int columnIndex) {
        return Double.parseDouble(current[columnIndex]);
    }

    long getLong(String columnLabel) {
        int arrIndex = columnLabelsToInt.get(columnLabel);
        return Long.parseLong(current[arrIndex]);
    }

    long getLong(int columnIndex) {
        return Long.parseLong(current[columnIndex]);
    }

    List<String> getColumnLabels() {
        return columnLabels;
    }

    int getRecordLength() {
        return current.length;
    }

    boolean isMissing(int columnIndex) {
        if (columnIndex >= getRecordLength())
            return true;
        return current[columnIndex].isEmpty();
    }

    boolean isMissing(String columnLabel) {
        int columnIndex = columnLabelsToInt.get(columnLabel);
        if (columnIndex >= getRecordLength())
            return true;
        return current[columnIndex].isEmpty();
    }

    LocalTime getTime(int columnIndex, String format) {
        String timeToParse = current[columnIndex];
        LocalTime time = LocalTime.parse(timeToParse, DateTimeFormatter.ofPattern(format));
        return time;
    }

    LocalDate getDate(int columnIndex, String format) {
        String dateToParse = current[columnIndex];
        LocalDate date = LocalDate.parse(dateToParse, DateTimeFormatter.ofPattern(format));
        return date;
    }

}
