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
        out.print("<!DOCTYPE html>\n");
        out.print("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang = \"en\" lang = \"en\">\n");
        out.print("<head>\n");
        out.print("<meta charset=\"UTF-8\">\n");
        out.printf("<title>%s</title>\n", title);
        out.print("</head>\n");
        out.print("<body>\n");

        out.printf("<div>\n<h1 align=\"left\">%s</h1>\n", title);
        photo.writeHTML(out);
        out.printf("</div>");

        for (Section section : sections) {
            section.writeHTML(out);
        }

        out.print("</body>\n");
        out.print("</html>");
    }
}