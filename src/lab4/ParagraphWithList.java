package lab4;

import java.io.PrintStream;
import java.util.ArrayList;

public class ParagraphWithList extends Paragraph {
    private UnorderedList unorderedList = new UnorderedList();

    public ParagraphWithList(String content) {
        super(content);
    }

    public ParagraphWithList() {
        super("Paragraph");
    }

    public ParagraphWithList setContent(String newContent) {
        super.setContent(newContent);
        return this;
    }

    @Override
    void writeHTML(PrintStream out) {
        super.writeHTML(out);
        unorderedList.writeHTML(out);
    }

    public ParagraphWithList addListItem(String item) {
        unorderedList.addItem(item);
        return this;
    }
}