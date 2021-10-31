import com.fasterxml.jackson.core.JsonProcessingException;
import com.rpa.vuls.models.Endpoint;
import com.rpa.vuls.models.Project;
import com.rpa.vuls.models.Report;
import com.rpa.vuls.models.VulInfo;
import com.rpa.vuls.proccess.JsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jsontest {

    public static void main(String[] args) {
        testEncode();
    }

    private void testDecode() {

    }

    private static void testEncode() {
        try {
            Project project = createProject();
            JsonBuilder jsBuilder = new JsonBuilder();
            String jsonString = jsBuilder.encode(project);
            System.out.println(jsonString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private static Project createProject() {
        VulInfo vulInfo = new VulInfo().setVulName("SQL").setSeverity("High")
                .setThread("Lay data").setHowfix("su dung prepare statement");
        Endpoint e1 = new Endpoint().setEndpoint("/api/v1/createuser")
                .setDescriber("tao nguoi dung")
                .setRequest("POST /api/v1/createuser");
        Endpoint e2 = new Endpoint().setEndpoint("/api/v1/createbook")
                .setDescriber("tao quyen sach")
                .setRequest("POST /api/v1/createbook");
        Endpoint e3 = new Endpoint().setEndpoint("/api/v1/viewuser")
                .setDescriber("xem nguoi dung")
                .setRequest("GET /api/v1/viewuser");
        List<Endpoint> endpoints1 = new ArrayList<>();
        endpoints1.add(e1);
        endpoints1.add(e2);
        List<Endpoint> endpoints2 = new ArrayList<>();
        endpoints2.add(e3);

        Report re1 = new Report().setVulInfo(vulInfo).setEndpoints(endpoints1);
        Report re2 = new Report().setVulInfo(vulInfo).setEndpoints(endpoints2);
        Map<String, Report> reports = new HashMap<>();
        reports.put("SQL", re1);
        reports.put("XSS", re2);

        Project project = new Project().setProject("HSSK").setReports(reports);
        return project;
    }

}
