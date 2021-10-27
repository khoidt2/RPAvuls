package com.rpa.vuls.wraper;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Line {

    private XWPFParagraph p;
    private XWPFRun r;

    public Line(XWPFDocument doc) {
        this.p = doc.createParagraph();
        this.r = p.createRun();
        this.r.setFontFamily("Times New Roman");
        this.r.setFontSize(13);
    }

    public Line(XWPFParagraph paragraph) {
        this.p = paragraph;
        this.r = p.createRun();
        this.r.setFontFamily("Times New Roman");
        this.r.setFontSize(13);
    }

    // Builder class
    public static class LineBuilder {
        private XWPFParagraph p;
        private XWPFRun r;

        public LineBuilder(XWPFDocument doc) {
            this.p = doc.createParagraph();
            this.r = p.createRun();
            this.r.setFontFamily("Times New Roman");
            this.r.setFontSize(13);
        }

        public void build() {
            //TODO: build will return Line after set full attribute
        }

        public LineBuilder setSize(int size) {
            this.r.setFontSize(size);
            return this;
        }

        public LineBuilder setText(String text) {
            this.r.setText(text);
            return this;
        }

        public LineBuilder setFont(String font) {
            this.r.setFontFamily(font);
            return this;
        }

        public LineBuilder setBold(Boolean bold) {
            this.r.setBold(bold);
            return this;
        }
    }

}
