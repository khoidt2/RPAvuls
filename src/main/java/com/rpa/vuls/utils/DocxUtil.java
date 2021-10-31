package com.rpa.vuls.utils;

import com.rpa.vuls.models.Endpoint;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class DocxUtil {

    protected void insertTable(List<Endpoint> endpoints, XWPFDocument doc) {
        XWPFTable table = doc.createTable(1,3);
        addColumn(table); //title tables
        //create Row new
        for (int i=0 ; i < endpoints.size(); i++) {
            addRow(String.valueOf(i), endpoints.get(i), table);
        }
    }

    private void addColumn(XWPFTable table) {
        XWPFTableRow columnName = table.getRow(0);
        columnName.getCell(0).setText("STT");
        columnName.getCell(1).setText("Endpoint");
        columnName.getCell(2).setText("Describer");
    }

    private void addRow(String stt, Endpoint endpoint, XWPFTable table) {
        XWPFTableRow row = table.createRow();
        row.getCell(0).setText(stt);
        row.getCell(1).setText(endpoint.getEndpoint());
        row.getCell(2).setText(endpoint.getDescriber());
    }

    protected void insertImage(File image, XWPFDocument doc) {
        XWPFParagraph p = doc.createParagraph();
        XWPFRun run = p.createRun();
        try {
            FileInputStream is = new FileInputStream(image);
            run.addPicture(is, Document.PICTURE_TYPE_PNG, image.getName(), Units.toEMU(400), Units.toEMU(200));
        } catch (InvalidFormatException | IOException e) {
            e.printStackTrace();
        }

    }
}
