package com.rpa.vuls.proccess;

import com.rpa.vuls.models.Endpoint;
import com.rpa.vuls.models.Project;
import com.rpa.vuls.models.Report;
import com.rpa.vuls.models.VulInfo;
import com.rpa.vuls.utils.DocxUtil;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.Map;

public class GenDoc extends DocxUtil {

    public void proccess(Project project) {
        Map<String, Report> reports = project.getReports();
        reports.forEach((s, report) -> prcReport(report));
    }

    private void prcReport(Report report) {
        try {
            XWPFDocument doc = new XWPFDocument(); // create document
            addTitle(doc); // title report
            addVulInfo(report.getVulInfo(), doc); // add vulnerabbiltity info
            addEndPoints(report.getEndpoints(), doc); // add endpoints
            addPoc(report.getEndpoints(), doc); // add POC

            //write to file docx
            writeFile("E:\\projects\\RPA\\out\\report.docx", doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addTitle(XWPFDocument doc) {
        new LineBuilder(doc).newRuns().setBold()
                .setAlignment(ParagraphAlignment.CENTER)
                .setText("DANH SÁCH LỖI AN TOÀN THÔNG TIN")
                .setSize(16).build();
    }

    private void addVulInfo(VulInfo vul, XWPFDocument doc) {
        //line 1 - vulner name: BUG_xx: VUL_NAME
        new LineBuilder(doc).newRuns().setBold().setText(vul.getVulname());
        //line 2 - level
        new LineBuilder(doc).newRuns().setText("Mức độ: ").setBold()
                .newRuns().setText(vul.getSeverity());
        //line3 - Thread
        new LineBuilder(doc).newRuns().setText("Nguy cơ: ").setBold()
                .newRuns().setText(vul.getThread());
        //line4 - how to fix
        new LineBuilder(doc).newRuns().setText("Khắc phục: ").setBold()
                .newRuns().setText(vul.getHowfix());

    }

    private void addEndPoints(List<Endpoint> endpoints, XWPFDocument doc) {
        //TODO: create tables include all endpoints be vulnerable
        new LineBuilder(doc).newRuns().setText("Các vị trí mắc lỗi:").setBold();
        insertTable(endpoints, doc);
    }

    private void addPoc(List<Endpoint> endpoints, XWPFDocument doc) {
        new LineBuilder(doc).newRuns().setText("Minh họa lỗi:").setBold();

        for (Endpoint e : endpoints) {
            addEndpoint(e, doc);
        }
    }

    private void addEndpoint(Endpoint endpoint, XWPFDocument doc) {
        new LineBuilder(doc).newRuns().setText("Endpoint: ").setBold()
                .newRuns().setText(endpoint.getEndpoint());
        new LineBuilder(doc).newRuns().setText("Describer: ").setBold()
                .newRuns().setText(endpoint.getDescriber());
        new LineBuilder(doc).newRuns().setText("Request: ").setBold();
        new LineBuilder(doc).newRuns().setText(endpoint.getRequest());
        new LineBuilder(doc).newRuns().setText("Hình ảnh minh họa").setBold();
        insertImage(endpoint.getImage(), doc);
    }

    private void writeFile(String pathSave, XWPFDocument doc) throws IOException {
        //TODO: check path save is exits
        FileOutputStream out = new FileOutputStream(pathSave);
        doc.write(out);
        out.close();
    }
}
