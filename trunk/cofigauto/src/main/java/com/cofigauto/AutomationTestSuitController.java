package com.cofigauto;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.model.AutomationTestSuite;
import com.cofigauto.runner.TestSuitRunner;
import com.cofigauto.runner.TestSuitRunnerFactory;
import com.cofigauto.runner.ValidTestSuitRunnerTypes;

/**
 * @author Vinay Sharma
 * @version 1.0
 */
public final class AutomationTestSuitController {

    /**
     * slf4j logger instance.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(AutomationTestSuitController.class);

    /**
     * Private default constructor.
     */
    private AutomationTestSuitController() {
    }

    /**
     * Method main.
     * 
     * @param args
     *            String[]
     */
    public static void main(final String[] args) {
        try {
            final Options options = new Options();

            options.addOption("help", false, "Prints this");
            options.addOption("f", true, "Test suite file / directory path.");
            options.addOption("t", true,
                    "Configuration type. Either excel or xml. "
                            + "default is excel.");
            options.addOption("d", true, "Report directory");
            options.addOption("p", true, "Report name prefix");
            options.addOption("t", true, "Type if configuration file "
                    + "(Excel or XML)");

            CommandLineParser parser = new BasicParser();

            CommandLine commandLine = parser.parse(options, args);
            String fileName = commandLine.getOptionValue("f");
            String reportDirectory = commandLine.getOptionValue("d");
            String reportPrefix = commandLine.getOptionValue("p");
            String fileType = commandLine.getOptionValue("t");

            if (StringUtils.isBlank(fileName)) {
                fileName = "test_cases/Test_Scenarios.xls";
            }

            fileName = fileName.trim();

            TestSuitRunner testSuitRunner = null;
            AutomationTestSuite suite = null;

            if (StringUtils.isNotBlank(fileType)) {
                testSuitRunner = TestSuitRunnerFactory
                        .createTestSuitRunner(ValidTestSuitRunnerTypes
                                .valueOf(fileType.trim().toUpperCase().trim()));
            } else if (StringUtils.isBlank(fileType)
                    && fileName.toLowerCase().endsWith("xml")) {
                testSuitRunner = TestSuitRunnerFactory
                        .createTestSuitRunner(ValidTestSuitRunnerTypes.XML);
            } else if (StringUtils.isBlank(fileType)
                    && fileName.toLowerCase().endsWith("xls")) {
                testSuitRunner = TestSuitRunnerFactory
                        .createTestSuitRunner(ValidTestSuitRunnerTypes.EXCEL);
            }

            if (testSuitRunner != null) {
                suite = testSuitRunner.runTestSuite(fileName);
            }

            final ReportBuilder reportBuilder = new ReportBuilder(
                    reportDirectory, reportPrefix);

            LOG.warn("Report created at location '"
                    + reportBuilder.buildReport(suite) + "'");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
