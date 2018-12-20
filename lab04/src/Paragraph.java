import java.io.PrintStream;

public class Paragraph {
    String content;

    public Paragraph (String content) { setContent(content); }

    public Paragraph setContent (String newContent) {
        this.content = newContent;
        return this;
    }

    void writeHTML (PrintStream out) {
        out.printf("<p>%s</p>", content);
    }
}
