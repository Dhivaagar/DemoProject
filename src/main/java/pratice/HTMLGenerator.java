package pratice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HTMLGenerator {

    public static void main(String[] args) throws IOException {
        String generatedResult = generateResult();
        File file = new File("target/CoverageReport.html");
        FileWriter writer = new FileWriter(file);
        writer.write(generatedResult);
        writer.close();
    }

    public static String generateResult() {
        StringBuilder result = new StringBuilder();
        result.append("<!DOCTYPE result>\n");
        result.append("<result lang=\"en\">\n");
        result.append("<head>\n");
        result.append("    <meta charset=\"UTF-8\">\n");
        result.append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        result.append("    <title>Table</title>\n");
        result.append("    <style>\n");
        result.append("        table {\n");
        result.append("            width: 100%;\n");
        result.append("            border-collapse: collapse;\n");
        result.append("        }\n");
        result.append("        th, td {\n");
        result.append("            border: 1px solid #ddd;\n");
        result.append("            padding: 8px;\n");
        result.append("            text-align: center;\n");
        result.append("        }\n");
        result.append("        th {\n");
        result.append("            background-color: #555;\n");
        result.append("            color: #fff;\n");
        result.append("        }\n");
        result.append("        tr:nth-child(even) {\n");
        result.append("            background-color: #f2f2f2;\n");
        result.append("        }\n");
        result.append("        th, td {\n");
        result.append("            text-align: center;\n");
        result.append("            padding: 0.5em 1em;\n");
        result.append("        }\n");
        result.append("        h4{\n");
        result.append("            display: flex;\n");
        result.append("            justify-content: center;\n");
        result.append("        }\n");
        result.append("    </style>\n");
        result.append("</head>\n");
        result.append("<body>\n");
        result.append("    <table id=\"dataTable\">\n");
        result.append("        <thead>\n");
        result.append("            <tr>\n");
        result.append("                <th rowspan=\"4\">Portal Name</th>\n");
        result.append("                <th rowspan=\"4\">Total Cases</th>\n");
        result.append("                <th rowspan=\"4\">Total Cases In Time Period</th>\n");
        result.append("                <th colspan=\"4\">Priority</th>\n");
        result.append("                <th colspan=\"2\">Created</th>\n");
        result.append("                <th colspan=\"2\">Updated</th>\n");
        result.append("            </tr>\n");
        result.append("            <tr>\n");
        result.append("                <th colspan=\"1\">P1</th>\n");
        result.append("                <th colspan=\"1\">P2</th>\n");
        result.append("                <th colspan=\"1\">P3</th>\n");
        result.append("                <th colspan=\"1\">P4</th>\n");
        result.append("                <th colspan=\"1\">By QA</th>\n");
        result.append("                <th colspan=\"1\">By Dev</th>\n");
        result.append("                <th colspan=\"1\">By QA</th>\n");
        result.append("                <th colspan=\"1\">By Dev</th>\n");
        result.append("            </tr>\n");
        result.append("        </thead>\n");
        result.append("        <tbody>\n");

        List<PortalData> portals = getPortalData();

        for (PortalData portal : portals) {
            result.append("            <tr>\n");
            result.append("                <td>").append(portal.getName()).append("</td>\n");
            result.append("                <td>").append(portal.getTotalCases()).append("</td>\n");
            result.append("                <td>").append(portal.getTotalCasesInTimePeriod()).append("</td>\n");
            result.append("                <td>").append(portal.getP1()).append("</td>\n");
            result.append("                <td>").append(portal.getP2()).append("</td>\n");
            result.append("                <td>").append(portal.getP3()).append("</td>\n");
            result.append("                <td>").append(portal.getP4()).append("</td>\n");
            result.append("                <td>").append(portal.getByQA_Created()).append("</td>\n");
            result.append("                <td>").append(portal.getByDev_Created()).append("</td>\n");
            result.append("                <td>").append(portal.getByQA_Updated()).append("</td>\n");
            result.append("                <td>").append(portal.getByDev_Updated()).append("</td>\n");
            result.append("            </tr>\n");
        }

        result.append("            <tr id=\"totalsRow\">\n");
        result.append("                <td>Total</td>\n");
        // Empty cells for other columns (they will be filled by JavaScript)
        for (int i = 1; i < 11; i++) {
            result.append("                <td></td>\n");
        }
        result.append("            </tr>\n");

        result.append("        </tbody>\n");
        result.append("    </table>\n");
        result.append("    <h4 id=\"timeStamp\">Report Generated time : 2024-04-15T22:56:28.345-07:00</h4>\n");
        // JavaScript for calculating column totals
        result.append("    <script>\n");
        result.append("        window.onload = function() {\n");
        result.append("            calculateColumnTotals();\n");
        result.append("        };\n");
        result.append("        function calculateColumnTotals() {\n");
        result.append("            var table = document.getElementById(\"dataTable\");\n");
        result.append("            var rows = table.rows;\n");
        result.append("            var totalsRow = document.getElementById(\"totalsRow\");\n");
        result.append("            var totals = new Array(rows[0].cells.length - 1).fill(0);\n");
        result.append("            for (var i = 1; i < rows.length; i++) {\n");
        result.append("                var row = rows[i];\n");
        result.append("                for (var j = 1; j < row.cells.length; j++) {\n");
        result.append("                    var value = parseFloat(row.cells[j].innerText);\n");
        result.append("                    if (!isNaN(value)) {\n");
        result.append("                        totals[j - 1] += value;\n");
        result.append("                    }\n");
        result.append("                }\n");
        result.append("            }\n");
        result.append("            for (var k = 1; k < totalsRow.cells.length; k++) {\n");
        result.append("                totalsRow.cells[k].innerText = totals[k - 1];\n");
        result.append("            }\n");
        result.append("        }\n");
        result.append("    </script>\n");
        result.append("</body>\n");
        result.append("</html>");

        return result.toString();
    }

    public static List<PortalData> getPortalData() {
        List<PortalData> portals = new ArrayList<>();

        // Add data for each portal
        portals.add(new PortalData("Energy Analytics", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        portals.add(new PortalData("Energy Data Platform", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        portals.add(new PortalData("Energy Data Platform API", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        portals.add(new PortalData("MySunpower", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        portals.add(new PortalData("Nightvision", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        portals.add(new PortalData("SPFM", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        portals.add(new PortalData("Virtual Power Plant", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        return portals;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class PortalData {
        private String name;
        private int totalCases;
        private int totalCasesInTimePeriod;
        private int p1;
        private int p2;
        private int p3;
        private int p4;
        private int byQA_Created;
        private int byDev_Created;
        private int byQA_Updated;
        private int byDev_Updated;
    }
}
