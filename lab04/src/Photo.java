import java.io.PrintStream;

public class Photo {
    private String url;

    Photo (String url) {
        this.url = url;
    }

    void writeHTML (PrintStream out) {
        out.printf("<img src=\"%s\" alt=\"Photo\" height=\"320\" width=\"250\" align=\"right\"/>\n",url);
    }
}
