import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Document cv = new Document("Daniel Rubak - CV");
        cv.addPhoto("src\\Daniel_Rubak_do_CV.jpg");
        cv.addSection("Education")
                .addParagraph("2013-2018 AGH University of Science and Technology - Automatics and Robotics")
                .addParagraph("2017-2021 AGH University of Science and Technology - Computer Science");
        cv.addSection("Skills")
                .addParagraph(
                        new ParagraphWithList().setContent("Programming")
                                .addListItem("Tcl")
                                .addListItem("C++")
                                .addListItem("Python")
                                .addListItem("Java")
                                .addListItem("SQL")
                );

        cv.writeHTML(new PrintStream("cv.html","ISO-8859-2"));
    }
}
