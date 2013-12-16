package com.cofigauto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.exception.ToolRuntimeException;
import com.cofigauto.model.AutomationTestCase;
import com.cofigauto.model.AutomationTestCaseStep;
import com.cofigauto.model.AutomationTestSuite;
import com.cofigauto.model.ValidTestStatus;

/**
 * @author Vinay Sharma
 */
public class ReportBuilder {
    /**
     * Directory to generate reports.
     */
    private String fileDir = "test_reports";
    /**
     * Report file name prefix.
     */
    private String fileNamePrefix = "Execution_Report_";
    /**
     * BufferedWriter to write report to.
     */
    private BufferedWriter output;

    /**
     * Slf4j Logger instance.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ReportBuilder.class);

    /**
     * Default constructor.
     */
    public ReportBuilder() {
        File file = new File(this.fileDir);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /**
     * Constructor.
     * 
     * @param reportPath
     *            Path of report
     */
    public ReportBuilder(final String reportPath) {
        if (StringUtils.isNotBlank(reportPath)) {
            this.fileDir = reportPath;
        }
        File file = new File(this.fileDir);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /**
     * Constructor.
     * 
     * @param reportDirectoryPath
     *            path of directory where reports are to be generated
     * @param reportFileNamePrefix
     *            prefix of report file names
     */
    public ReportBuilder(final String reportDirectoryPath,
            final String reportFileNamePrefix) {
        if (StringUtils.isNotBlank(reportDirectoryPath)) {
            this.fileDir = reportDirectoryPath;
        }

        if (StringUtils.isNotBlank(reportFileNamePrefix)) {
            this.fileNamePrefix = reportFileNamePrefix;
        }
        File file = new File(this.fileDir);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /**
     * Method buildReport.
     * 
     * @param suite
     *            AutomationTestSuite
     * @return String
     */
    public final String buildReport(final AutomationTestSuite suite) {
        String reportPath = "no report";
        try {
            reportPath = createReport();

            for (AutomationTestCase testCase : suite.getTests()) {
                createTableHeader(testCase);
                for (AutomationTestCaseStep step : testCase.getSteps()) {
                    this.writeTestCaseResult(step);
                }
                createTableFooter();
            }
            closeReport();
        } catch (Exception e) {
            LOGGER.error("Exception occurred", e);
            reportPath = "Exception occurred";
        }
        return reportPath;

    }

    /**
     * Method createReport.
     * 
     * @return String
     * @throws IOException
     *             May throw IOException while writing output
     */
    private String createReport() throws IOException {

        File file = new File(this.fileDir + File.separator + this.fileNamePrefix
                + getDateTime() + ".html");
        this.output = new BufferedWriter(new FileWriter(file));
        this.output.write("<html><body>");
        this.output.write("<center><h2> <u>" + "AUTOMATED TEST EXECUTION REPORT"
                + "</u></h2></center>");
        return file.getPath();

    }

    /**
     * Method writeTestCaseResult.
     * 
     * @param step
     *            AutomationTestCaseStep
     * @throws IOException
     *             Can throw exception while writing output.
     */
    final void writeTestCaseResult(final AutomationTestCaseStep step)
            throws IOException {

        if (this.output == null) {
            throw new ToolRuntimeException(
                    "Exception while writing to report. Writer object is null");
        }

        this.output.write("<tr>");
        this.output.write("<td width=100 bgcolor=#EFFBF5  "
                + "align=middle><font face=arial size=2 " + "color=black>"
                + step.getAction() + "</font></td>");
        this.output.write("<td width=100 bgcolor=#EFFBF5  "
                + "align=middle><font face=arial size=2 " + "color=black>"
                + step.getReportingName() + "</font></td>");
        this.output.write("<td width=150 bgcolor=#EFFBF5  "
                + "align=middle><font face=arial size=2 " + "color=black>"
                + step.getIdentifierType() + "-" + step.getIdentifier()
                + "</font></td>");
        if (step.getStatus() != null) {
            if (step.getStatus().getStatus().equals(ValidTestStatus.FAIL)) {
                this.output.write("<td width=100 bgcolor=#EFFBF5  "
                        + "align=middle><font face=arial size=2 "
                        + "color=RED><b>" + step.getStatus().getStatus()
                        + "</b></font></td>");
            } else {
                this.output.write("<td width=100 bgcolor=#EFFBF5  "
                        + "align=middle><font face=arial size=2 "
                        + "color=green><b>" + step.getStatus().getStatus()
                        + "</b></font></td>");
            }
            this.output.write("<td width=100 bgcolor=#EFFBF5  "
                    + "align=middle><font face=arial size=2><b>"
                    + step.getStatus().getStatusDesc() + "</b></font></td>");
        } else {
            this.output.write("<td width=100 bgcolor=#EFFBF5  "
                    + "align=middle><font face=arial size=2 "
                    + "color=black ><b>" + ValidTestStatus.NOT_RUN
                    + "</b></font></td>");
            this.output.write("<td width=100 bgcolor=#EFFBF5  "
                    + "align=middle><font face=arial size=2>"
                    + "<b></b></font></td>");
        }
        this.output.write("</tr>");
    }

    /**
     * Method GetDateTime.
     * 
     * @return String
     */
    private String getDateTime() {
        Date now = new Date();
        try {
            SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");

            String strDate = sdfDate.format(now);
            String strTime = sdfTime.format(now);
            strTime = strTime.replace(":", "-");
            String sDateTime = "D" + strDate + "_T" + strTime;
            return sDateTime;
        } catch (Exception e) {
            LOGGER.error("Exception Occurred ", e);
        }

        return now.toString();
    }

    /**
     * Close report
     */
    private void closeReport() {
        try {
            this.output.close();
        } catch (Exception e) {
            LOGGER.error("Exception Occurred ", e);
        }
    }

    /**
     * Method createTableHeader.
     * 
     * @param testCase
     *            AutomationTestCase
     * @throws IOException
     *             exception on writing output
     */
    private void createTableHeader(final AutomationTestCase testCase)
            throws IOException {
        getDateTime();

        this.output.write("<font face=arial size=3><b>Test Scenario Name :: "
                + "</b>  </font> <font face=arial size=2>"
                + testCase.getFeatureName() + "</font></br>");
        this.output.write("<font face=arial size=3><b>Browser :: </b>  "
                + "</font> <font face=arial size=2>"
                + testCase.getBrowserName() + "</font></br>");

        if (testCase.getStatus().equals(ValidTestStatus.PASS)) {
            this.output.write("<font face=arial size=3><b>Result :: </b> "
                    + " </font> <font face=arial size=2>PASS</font></br>");
        } else if (testCase.getStatus().equals(ValidTestStatus.FAIL)) {
            this.output.write("<font face=arial size=3><b>Result :: </b>  "
                    + "</font> <font face=arial size=2 color=RED>FAIL</font></br>");
        } else if (testCase.getStatus().equals(ValidTestStatus.NOT_RUN)) {
            this.output.write("<font face=arial size=3><b>Result :: </b>  "
                    + "</font> <font face=arial size=2>NOT_RUN</font></br>");
        }

        this.output.write("<font face=arial size=3><b>Execution Start Time "
                + ":: </b>  </font> <font face=arial size=2><b>"
                + getDateTime() + "</b> </font></br></br>");
        this.output.write("<font face=arial size=3><b>Scenario Description "
                + ":: </b> </font> <b> <font face=arial size=2>"
                + testCase.getDescription() + "</b> </font></br>");
        this.output.write("<table cellpadding=0 cellspacing=0 width=1000 "
                + "border=2 bordercolor=BLACK>");
        this.output.write("<tr>");
        this.output.write("<td width=150 bgcolor=#0404B4 align=middle><font "
                + "face=arial size=2 color=white><b>ACTION</b></font></td>");
        this.output.write("<td width=100 bgcolor=#0404B4 align=middle><font "
                + "face=arial size=2 color=white><b>STEP Description</b></font></td>");
        this.output.write("<td width=150 bgcolor=#0404B4 align=middle><font "
                + "face=arial size=2 color=white><b>OBJECT</b></font></td>");
        this.output.write("<td width=100 bgcolor=#0404B4 align=middle><font "
                + "face=arial size=2 color=white><b>RESULT</b></font></td>");
        this.output.write("<td width=100 bgcolor=#0404B4 align=middle><font "
                + "face=arial size=2 color=white><b>EXTRA INFORMATION</b></font></td>");
        this.output.write("</tr>");

    }

    /**
     * Method createTableFooter.
     *
     * @throws IOException
     *             error in writing output
     */
    private void createTableFooter() throws IOException {
        getDateTime();
        this.output.write("</table> <br/>");

    }
}
