package com.rpa.vuls;

import com.rpa.vuls.proccess.GenDoc;
import com.rpa.vuls.wraper.LineBuilder;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Main {

    public static void main(String[] args) throws Exception {
//        GenDoc genDocx = new GenDoc();
//        genDocx.proccess();
        XWPFDocument doc = new XWPFDocument();
        LineBuilder line = new LineBuilder(doc).setBold(true).setText("test");
        System.out.println(line.getR().text());
        System.out.println(line.getP().getParagraphText());
        System.out.println(line.getR().getFontFamily());
    }
}
