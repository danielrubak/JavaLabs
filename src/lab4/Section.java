package lab4;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Section {
    private String title;
    private List<Paragraph> paragraphs = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public Section addParagraph(String content) {
        paragraphs.add(new Paragraph(content));
        return this;
    }

    public Section addParagraph( Paragraph p) {
        paragraphs.add(p);
        return this;
    }

    void writeHTML(PrintStream out) {
        out.print("<div>");
        for(Paragraph item : paragraphs) {
            item.writeHTML(out);
        }
        out.print("</div>");
    }
}
