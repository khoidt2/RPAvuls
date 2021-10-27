package com.rpa.vuls.proccess;

import com.rpa.vuls.models.VulInfo;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GenDoc {

    public void proccess() {

        try {
            XWPFDocument doc = new XWPFDocument();
            XWPFParagraph ds = doc.createParagraph();
            ds.setAlignment(ParagraphAlignment.CENTER);
            XWPFRun dsrun = ds.createRun();
            dsrun.setBold(true);
            dsrun.setFontSize(16);
            dsrun.setText("DANH SÁCH LỖI AN TOÀN THÔNG TIN");
            dsrun.setFontFamily("Times New Roman");

            writeFile("E:\\projects\\RPA\\out\\report.docx", doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addVulInfo(VulInfo vul, XWPFDocument doc) {
        //line 1 - vulner name: BUG_xx: VUL_NAME
        XWPFParagraph pVul = doc.createParagraph();
        XWPFRun rVul = pVul.createRun();
        rVul.setFontFamily("Times New Roman");
        rVul.setFontSize(13);
        rVul.setBold(true);
        rVul.setText(vul.getVulnerability());

        //line 2 - level

    }

    private void addEndPoints() {

    }

    private void addPoc() {

    }

    private void insertTable() {

    }

    private void insertImage() {

    }

    private void writeFile(String pathSave, XWPFDocument doc) throws IOException {
        //TODO: check path save is exits
        FileOutputStream out = new FileOutputStream(pathSave);
        doc.write(out);
        out.close();
    }

     public void test() throws IOException {
        String template = "E:\\projects\\RPA\\template\\template.docx";
        InputStream file = Files.newInputStream(Paths.get(template));
        XWPFDocument doc = new XWPFDocument(file);
        List<XWPFParagraph> paragraphs = doc.getParagraphs();

        for (XWPFParagraph pa : paragraphs) {
            System.out.println("paragraph: " + pa.getParagraphText());
            for (XWPFRun run : pa.getRuns()) {
                String text = run.getText(0);
                System.out.println(text);
            }
        }
    }
}
