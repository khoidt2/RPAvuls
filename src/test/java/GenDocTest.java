import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

public class GenDocTest {

    public static void main(String[] args) throws Exception {
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph paragraph = doc.createParagraph();
        XWPFRun run1 = paragraph.createRun();
        run1.setText("Muc do:");
        run1.setBold(true);
        run1 = paragraph.createRun();
        run1.setText("Cao");

        System.out.println(paragraph.getParagraphText());
        System.out.println(paragraph.getRuns().size());
        writeFile("E:\\projects\\RPA\\out\\reporttest.docx", doc);
    }

    private static void writeFile(String pathSave, XWPFDocument doc) throws IOException {
        //TODO: check path save is exits
        FileOutputStream out = new FileOutputStream(pathSave);
        doc.write(out);
        out.close();
    }
}
