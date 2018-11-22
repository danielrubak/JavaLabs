package lab4;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class UnorderedList {
    private List<ListItem> items = new ArrayList<>();

    void writeHTML(PrintStream out) {
        out.print("<ul>");
        for(ListItem item : items) {
            item.writeHTML(out);
        }
        out.print("</ul>");
    }

    void addItem(String item)
    {
        items.add(new ListItem(item));
    }
}
