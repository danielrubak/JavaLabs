import java.io.PrintStream;
import java.util.*;

public class Document {
    private String title;
    private Photo photo;
    private List<Section> sections = new ArrayList<>();

    public Document(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addPhoto(String  url) {
        this.photo = new Photo(url);
    }

    public Section addSection(String title) {
        Section newItem = new Section(title);
        sections.add(newItem);
        return newItem;
    }

    public void writeHTML(PrintStream out) {
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<meta charset=\"UTF-8\">");
        out.printf("<title>%s</title>", title);
        out.print("</head>");
        out.print("<body>");

        out.printf("<h1>%s</h2>", title);
        photo.writeHTML(out);

        for (Section section : sections) {
            section.writeHTML(out);
        }

        out.print("</body>");
        out.print("</html>");
    }
}