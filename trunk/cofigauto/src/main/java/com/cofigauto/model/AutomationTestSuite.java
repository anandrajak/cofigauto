package com.cofigauto.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.exception.ToolRuntimeException;

/**
 */
/**
 * @author vsha28
 *
 */
/**
 * @author vsha28
 * 
 */
public class AutomationTestSuite {

    /**
     * List of test cases
     */
    private final List<AutomationTestCase> tests = new ArrayList<AutomationTestCase>();

    /**
     * Expected Max count of rows in a test sheet. (number of test steps in a
     * test case)
     */
    private static final int MAX_ROW_COUNT = 1000;
    /**
     * Lig4j Logger instance
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(AutomationTestSuite.class);

    /**
     * Constructor for AutomationTestSuite.
     * 
     * @param excelFile
     *            String
     * @throws IOException
     *             in case if there is an error while reading file
     */
    public AutomationTestSuite(final String excelFile) throws IOException {

        File file = new File(excelFile);
        if (!file.exists()) {
            throw new ToolRuntimeException("Excel file doesnt "
                    + "exists at location " + excelFile);
        }

        HSSFWorkbook testCaseExcel = new HSSFWorkbook(new FileInputStream(
                excelFile));

        HSSFSheet sheet = testCaseExcel.getSheet("Main");
        if (sheet != null) {
            LOG.info("Main Sheet Found");

            int count = 1;
            for (; count <= MAX_ROW_COUNT; count++) {
                LOG.debug("Processing........ " + count);
                HSSFRow row = sheet.getRow(count);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("row........ " + row);
                    if (row != null) {
                        LOG.debug("row.getCell(0)........ " + row.getCell(0));
                        LOG.debug(" StringUtils.isBlank(row.getCell(0)."
                                + "toString())........ "
                                + StringUtils
                                        .isBlank(row.getCell(0).toString()));
                    }
                }
                if (row == null || row.getCell(0) == null
                        || StringUtils.isBlank(row.getCell(0).toString())) {
                    break;
                }

                AutomationTestCase step = new AutomationTestCase(row,
                        testCaseExcel);

                if (step.isRun()) {
                    tests.add(step);
                } else {
                    LOG.info("Test case run is N. Skipping " + "test at row "
                            + (count - 1));
                }
            }
            LOG.info("Total test cases to be executed are " + tests.size()
                    + ". Out of configured " + (count - 1) + " test cases");
        } else {
            LOG.error("No main sheet found");
        }

    }

    /**
     * Method getTests.
     * 
     * @return List<AutomationTestCase>
     */
    public final List<AutomationTestCase> getTests() {
        return tests;
    }

}