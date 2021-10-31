package com.rpa.vuls.proccess;

import lombok.Getter;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

@Getter
public class LineBuilder {

    private XWPFParagraph p;
    private XWPFRun r;

    public LineBuilder(XWPFDocument doc) {
        this.p = doc.createParagraph();
    }

    public String build() {
        //TODO: build will return Line after set full attribute
        return p.getParagraphText();
    }

    public LineBuilder newRuns() {
        this.r = p.createRun();
        this.r.setFontFamily("Times New Roman");
        this.r.setFontSize(13);
        return this;
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

    public LineBuilder setBold() {
        this.r.setBold(true);
        return this;
    }

    public LineBuilder setAlignment (ParagraphAlignment aligment) {
        this.p.setAlignment(aligment);
        return this;
    }
}
