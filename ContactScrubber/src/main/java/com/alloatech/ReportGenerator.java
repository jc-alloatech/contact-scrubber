/**
 * Proprietary and Confidential AlloaTech, LLC. This document contains material which is proprietary and confidential property of ThorCode. The right
 * to view, reproduce, modify, distribute, or in any way display this work is prohibited without the expressed written consent of ThorCode Copyright
 * &copy; 2017 Initial commit: Sep 18, 20177:16:38 AM User: thor
 */
package com.alloatech;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author thor
 */
public class ReportGenerator {

    private static final String HTML_FILE = "src\\main\\resources\\report.html";

    public static void generateReport(ContactScrub scrub) {
        File file = new File(HTML_FILE);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write("<!doctype html>");
            writer.newLine();
            writer.write("<html lang=\"en\">");
            writer.newLine();
            writer.write("<head>");
            writer.newLine();
            writer.write("\t<meta charset=\"utf-8\">");
            writer.newLine();
            writer.write("\t<title>Contact Scrubber Report</title>");
            writer.newLine();
            writer.write(
                    "\t<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css\" integrity=\"sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ\" crossorigin=\"anonymous\">");
            writer.newLine();
            writer.write(
                    "\t<script src=\"https://code.jquery.com/jquery-3.1.1.slim.min.js\" integrity=\"sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n\" crossorigin=\"anonymous\"></script>");
            writer.newLine();
            writer.write(
                    "\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\" integrity=\"sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb\" crossorigin=\"anonymous\"></script>");
            writer.newLine();
            writer.write(
                    "\t<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js\" integrity=\"sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn\" crossorigin=\"anonymous\"></script>");
            writer.newLine();
            writer.write("\t<link href=\"report.css\" rel=\"stylesheet\">");
            writer.newLine();
            writer.write("\t<script src=\"report.js\"></script>");
            writer.newLine();
            writer.write("</head>");
            writer.newLine();
            writer.write("<body>");
            writer.newLine();
            generateReportHeader(writer, scrub);
            generateReportDetails(writer, scrub);
            writer.write("</body>");
            writer.newLine();
            writer.write("</html>");
            writer.newLine();
            writer.flush();
            System.out.println("Done Generating Report.");
        }
        catch (IOException e) {
            e.printStackTrace();
            scrub.getErrors().add("Error Generating Report:" + e.getLocalizedMessage());
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                scrub.getErrors().add("Error Generating Report:" + e.getLocalizedMessage());
            }
        }
    }

    private static void generateReportHeader(BufferedWriter writer, ContactScrub scrub) {
        try {
            writer.write("\t<div class=\"jumbotron\">");
            writer.newLine();
            writer.write("\t\t<h1 class=\"display-3\">Contact Scrubber Report</h1>");
            writer.newLine();
            writer.write("\t<p class=\"lead\">This report was run " + scrub.getTimeStamp() + "</p>");
            writer.newLine();
            writer.write("\t\t<hr class=\"my-4\">");
            writer.newLine();
            writer.write("\t\t<p class=\"lead\">Report Statistics</p>\r\n");
            writer.newLine();
            writer.write("\t\t<container>");
            writer.newLine();
            long secs = scrub.getDuration().getSeconds();
            writer.write("\t\t\t<div class=\"indented\">Execution Duration: "
                    + String.format("%d:%02d:%03d", secs / 3600, (secs / 360000) / 60, (secs % 60)) + "</div>");
            writer.newLine();
            writer.write("\t\t\t\t<p class=\"indented\">Files Processed</p>");
            writer.newLine();
            writer.write("\t\t\t\t<table class=\"table table-striped table-bordered table-hover light-grey indented\">");
            writer.newLine();
            writer.write("\t\t\t\t\t<thead>");
            writer.newLine();
            writer.write("\t\t\t\t\t\t<tr>");
            writer.newLine();
            writer.write("\t\t\t\t\t\t\t<th>Name</th>");
            writer.newLine();
            writer.write("\t\t\t\t\t\t\t<th class=\"text-center\">Contact Count</th>");
            writer.newLine();
            writer.write("\t\t\t\t\t\t\t<th class=\"text-center\">Contact Quality (Avg)</th>");
            writer.newLine();
            writer.write("\t\t\t\t\t\t\t<th class=\"text-center\">Bad Contact Count</th>");
            writer.newLine();
            writer.write("\t\t\t\t\t\t</tr>");
            writer.newLine();
            writer.write("\t\t\t\t\t</thead>");
            writer.newLine();
            writer.write("\t\t\t\t\t<tbody>");
            writer.newLine();
            for (FileConfig fConf : scrub.getFileConfigs()) {
                writer.write("\t\t\t\t\t\t<tr>");
                writer.newLine();
                writer.write("\t\t\t\t\t\t\t<td>" + fConf.getFileName() + "</td>");
                writer.newLine();
                writer.write("\t\t\t\t\t\t\t<td class=\"text-center\">" + fConf.getContactCount() + "</td>");
                writer.newLine();
                writer.write("\t\t\t\t\t\t\t<td class=\"text-center\">" + fConf.getContactQuality() + "% </td>");
                writer.newLine();
                writer.write("\t\t\t\t\t\t\t<td class=\"text-center\">" + fConf.getBadContactCount() + "</td>");
                writer.newLine();
                writer.write("\t\t\t\t\t\t</tr>");
                writer.newLine();
            }
            writer.write("\t\t\t\t\t\t</tr>");
            writer.newLine();
            writer.write("\t\t\t\t\t</tbody>");
            writer.newLine();
            writer.write("\t\t\t\t</table>");
            writer.newLine();
            writer.write("\t\t</container>");
            writer.newLine();
            writer.write("\t\t<hr class=\"my-4\">");
            writer.newLine();
            writer.write("\t\t<p class=\"lead\">");
            writer.newLine();
            writer.write("\t\t\t<a class=\"btn btn-primary btn-lg\" href=\"#details\" role=\"button\">Details</a>");
            writer.newLine();
            writer.write("\t\t</p>");
            writer.newLine();
            writer.write("\t</div>");
            writer.newLine();
        }
        catch (IOException e) {
            scrub.getErrors().add(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    private static void generateReportDetails(BufferedWriter writer, ContactScrub scrub) {
        try {
            writer.write("\t<container id=\"details\">");
            writer.newLine();
            writer.write("\t\t<div class=\"card-deck inset\">");
            writer.newLine();
            for (ScrubbingResult result : scrub.getResults()) {
                writer.write("\t\t\t<div class=\"card\">");
                writer.newLine();
                writer.write("\t\t\t\t<div class=\"card-block\">");
                writer.newLine();
                String id = result.getContact().getId().replaceAll("[:\\.]", "_");
                writer.write("<!-- Nav tabs -->\r\n" + "<ul class=\"nav nav-tabs\" role=\"tablist\">\r\n"
                        + "  <li class=\"nav-item\">\r\n" + "    <a class=\"nav-link active\" data-toggle=\"tab\" href=\"#contact"
                        + id + "\" role=\"tab\">Contact</a>\r\n" + "  </li>\r\n" + "  <li class=\"nav-item\">\r\n"
                        + "    <a class=\"nav-link\" data-toggle=\"tab\" href=\"#scrub-results" + id
                        + "\" role=\"tab\">Scrub Results</a>\r\n" + "  </li>\r\n" + "  <li class=\"nav-item\">\r\n"
                        + "    <a class=\"nav-link\" data-toggle=\"tab\" href=\"#quality" + id + "\" role=\"tab\">Quality</a>\r\n"
                        + "  </li>\r\n" + "</ul>");
                writer.write("\t\t\t\t<div class=\"tab-content\">");
                writer.newLine();
                writer.write("\t\t\t\t<div class=\"tab-pane active\" id=\"contact" + id + "\" role=\"tabpanel\">");
                writer.newLine();
                writer.write("\t\t\t\t<h4 class=\"card-title\">" + result.getContact().getName() + "</h4>");
                writer.newLine();
                writer.write("\t\t\t<p class=\"card-text indented\"> Quality Score:" + result.getContact().getQuality().getScore()
                        + "<br/> Hit Confidence: " + result.getData().stream().mapToInt(d -> d.weightedRation).max().getAsInt()
                        + "</p>");
                writer.newLine();
                for (Address address : result.getContact().getAddresses()) {
                    writer.write(
                            "\t\t\t\t<p class=\"card-text indented\">" + address.getType() + " Address: " + address.getAddress() + "</p>");
                    writer.newLine();
                }
                writer.newLine();
                writer.write("\t\t\t\t<p class=\"card-footer text-muted\"> id:" + id + "</p>");
                writer.newLine();
                writer.write("\t\t\t\t</div>");
                writer.newLine();
                writer.write("\t\t\t\t<div class=\"tab-pane\" id=\"scrub-results" + id + "\" role=\"tabpanel\">");
                writer.newLine();
                writer.write("\t\t\t\t\t<ul class=\"list-group list-group-flush\">");
                writer.newLine();
                for (ScrubbingResultData data : result.getData()) {
                    writer.write("\t\t\t\t\t\t<li class=\"list-group-item\"> ID:" + data.key + "::" + data.fieldName + ":"
                            + data.fieldValue + " - " + data.weightedRation + "% Hit Ratio</li>");
                    writer.newLine();
                }
                writer.write("\t\t\t\t\t</ul>");
                writer.newLine();
                writer.write("\t\t\t\t</div>");
                writer.newLine();
                writer.write("\t\t\t\t<div class=\"tab-pane\" id=\"quality" + id + "\" role=\"tabpanel\">");
                writer.newLine();
                writer.write("\t\t\t\t</div>");
                writer.newLine();
                writer.write("\t\t\t\t</div>");
                writer.newLine();
                writer.write("\t\t\t\t</div>");
                writer.newLine();
                writer.write("\t\t\t\t</div>");
                writer.newLine();
            }
            writer.write("\t\t</div>");
            writer.newLine();
            writer.write("\t</container>");
            writer.newLine();
        }
        catch (IOException e) {
            scrub.getErrors().add(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }
}