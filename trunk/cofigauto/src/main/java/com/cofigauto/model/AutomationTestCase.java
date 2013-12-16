package com.cofigauto.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.exception.ToolRuntimeException;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AutomationTestCase {
    /**
   * 
   */
    @XmlAttribute(name = "serialNumber", required = false)
    private String serialNumber;
    /**
   * 
   */
    @XmlAttribute(name = "featureName", required = false)
    private String featureName;
    /**
   * 
   */
    @XmlAttribute(name = "description", required = false)
    private String description;
    /**
   * 
   */
    @XmlAttribute(name = "run", required = false)
    private boolean run = Boolean.FALSE;
    /**
   * 
   */
    @XmlAttribute(name = "browserName", required = true)
    private String browserName;
    /**
   * 
   */
    @XmlAttribute(name = "closeBrowserOnExit", required = false)
    private boolean closeBrowserOnExit = true;
    /**
   * 
   */
    @XmlElement(name = "steps", required = false)
    private List<AutomationTestCaseStep> steps = new ArrayList<AutomationTestCaseStep>();
    /**
   * 
   */
    @XmlTransient
    private ValidTestStatus status = ValidTestStatus.NOT_RUN;

    /**
     * Slf4j logger instance
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(AutomationTestCase.class);

    /**
     * Default Constructor.
     */
    AutomationTestCase() {

    }
    /**
     * Constructor for AutomationTestCase.
     * 
     * @param row
     *            HSSFRow
     * @param xls
     *            HSSFWorkbook
     */
    AutomationTestCase(final HSSFRow row, final HSSFWorkbook xls) {
        if (row == null || row.getCell(0) == null
                || StringUtils.isBlank(row.getCell(0).toString().trim())) {
            throw new ToolRuntimeException("row is null");
        }

        if (HSSFCell.CELL_TYPE_NUMERIC == row.getCell(
                ModelConstants.MainSheet.SERIAL_NO).getCellType()) {
            this.serialNumber = ((Double) row.getCell(
                    ModelConstants.MainSheet.SERIAL_NO).getNumericCellValue())
                    .toString();
        } else {
            this.serialNumber = row.getCell(ModelConstants.MainSheet.SERIAL_NO)
                    .getStringCellValue();
        }

        this.featureName = row.getCell(ModelConstants.MainSheet.FEATURE_NAME)
                .getStringCellValue();
        this.description = row.getCell(ModelConstants.MainSheet.DESCRIPION)
                .getStringCellValue();
        this.browserName = row.getCell(ModelConstants.MainSheet.BROWSER_NAME)
                .getStringCellValue();

        String tempVal = row.getCell(ModelConstants.MainSheet.RUN)
                .getStringCellValue();
        if (tempVal.equalsIgnoreCase("Y")) {
            this.run = Boolean.TRUE;
        }

        tempVal = row.getCell(ModelConstants.MainSheet.CLOSE_DRIVER_ON_EXIT)
                .getStringCellValue();
        if (tempVal.equalsIgnoreCase("N")) {
            this.closeBrowserOnExit = Boolean.FALSE;
        }

        HSSFSheet sheet = xls.getSheet(this.featureName);
        if (sheet != null) {
            LOG.debug("Sheet found with name " + this.featureName);

            int count = 1;
            for (; count <= 1000; count++) {
                HSSFRow stepRow = sheet.getRow(count);
                if (stepRow == null
                        || stepRow.getCell(0) == null
                        || StringUtils
                                .isBlank(row.getCell(0).toString().trim())) {
                    break;
                }
                steps.add(new AutomationTestCaseStep(stepRow));
            }

            LOG.info("Total steps to be executed in test case are "
                    + (count - 1));
        } else {
            LOG.error("No sheet found with name " + this.featureName);
        }
    }

    /**
     * Method getSerialNumber.
     * 
     * @return String
     */
    public final String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Method getFeatureName.
     * 
     * @return String
     */
    public final String getFeatureName() {
        return featureName;
    }

    /**
     * Method getDescription.
     * 
     * @return String
     */
    public final String getDescription() {
        return description;
    }

    /**
     * Method isRun.
     * 
     * @return boolean
     */
    public final boolean isRun() {
        return run;
    }

    /**
     * Method getBrowserName.
     * 
     * @return String
     */
    public final String getBrowserName() {
        return browserName;
    }

    /**
     * Method getSteps.
     * 
     * @return List<AutomationTestCaseStep>
     */
    public final List<AutomationTestCaseStep> getSteps() {
        return steps;
    }

    /**
     * Method toString.
     * 
     * @return String
     */
    @Override
    public final String toString() {
        return "AutomationTestCase [serialNumber=" + serialNumber
                + ", featureName=" + featureName + ", description="
                + description + ", run=" + run + ", browserName=" + browserName
                + ", steps=" + steps + "]";
    }

    /**
     * Method isCloseBrowserOnExit.
     * 
     * @return boolean
     */
    public final boolean isCloseBrowserOnExit() {
        return this.closeBrowserOnExit;
    }

    /**
     * @param serialNumber
     *            the serialNumber to set
     */
    protected final void setSerialNumber(final String serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * @param featureName
     *            the featureName to set
     */
    protected final void setFeatureName(final String featureName) {
        this.featureName = featureName;
    }

    /**
     * @param description
     *            the description to set
     */
    protected final void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @param run
     *            the run to set
     */
    protected final void setRun(final boolean run) {
        this.run = run;
    }

    /**
     * @param browserName
     *            the browserName to set
     */
    protected final void setBrowserName(final String browserName) {
        this.browserName = browserName;
    }

    /**
     * @param closeBrowserOnExit
     *            the closeBrowserOnExit to set
     */
    protected final void setCloseBrowserOnExit(final boolean closeBrowserOnExit) {
        this.closeBrowserOnExit = closeBrowserOnExit;
    }

    /**
     * @param steps
     *            the steps to set
     */
    protected final void setSteps(final List<AutomationTestCaseStep> steps) {
        this.steps = steps;
    }

    /**
     * @return the status
     */
    public final ValidTestStatus getStatus() {
        return status;
    }

    /**
     * @param status
     *            the status to set
     */
    public final void setStatus(final ValidTestStatus status) {
        this.status = status;
    }

}
