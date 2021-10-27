package com.rpa.vuls.proccess;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GenDoc {

    public void proccess() {

        XWPFDocument doc = new XWPFDocument();

    }

    private void addVulInfo() {

    }

    private void addEndPoints() {

    }

    private void addPoc() {

    }

    private void insertTable() {

    }

    private void insertImage() {

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
