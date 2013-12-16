package com.cofigauto.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

import com.cofigauto.exception.ToolRuntimeException;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class AutomationTestCaseStep {

    /**
   * 
   */
    @XmlAttribute(name = "action", required = true)
    private String action;
    /**
   * 
   */
    @XmlAttribute(name = "windowName", required = false)
    private String windowName;
    /**
   * 
   */
    @XmlAttribute(name = "reportingName", required = true)
    private String reportingName;
    /**
   * 
   */
    @XmlAttribute(name = "identifier", required = true)
    private String identifier;
    /**
   * 
   */
    @XmlAttribute(name = "identifierType", required = true)
    private String identifierType;
    /**
   * 
   */
    @XmlAttribute(name = "data", required = false)
    private String data;
    /**
   * 
   */
    @XmlAttribute(name = "exitOnFail", required = false)
    private boolean exitOnFail = false;
    /**
   * 
   */
    @XmlAttribute(name = "failTestCaseIfFails", required = false)
    private boolean failTestCaseIfFails = false;
    /**
   * 
   */
    @XmlTransient
    private TestStatus status;

    /**
     * Default Constructor
     */
    AutomationTestCaseStep() {
    }
    /**
     * Constructor for AutomationTestCaseStep.
     * 
     * @param row
     *            HSSFRow
     */
    AutomationTestCaseStep(final HSSFRow row) {
        if (row == null || row.getCell(0) == null) {
            throw new ToolRuntimeException("row is null");
        }

        this.action = getCellStringValue(row
                .getCell(ModelConstants.DetailsSheet.ACTION));
        this.windowName = getCellStringValue(row
                .getCell(ModelConstants.DetailsSheet.WINDOW_NAME));
        this.reportingName = getCellStringValue(row
                .getCell(ModelConstants.DetailsSheet.STEP_REPORTING_NAME));
        this.identifier = getCellStringValue(row
                .getCell(ModelConstants.DetailsSheet.IDENIFIER));
        this.identifierType = getCellStringValue(row
                .getCell(ModelConstants.DetailsSheet.IDENT_TYPE));
        this.data = getCellStringValue(row
                .getCell(ModelConstants.DetailsSheet.DATA));

        String tempStr = getCellStringValue(row
                .getCell(ModelConstants.DetailsSheet.EXIT_IF_FAIL));
        if (StringUtils.isNotBlank(tempStr)
                && tempStr.trim().equalsIgnoreCase("Y")) {
            this.exitOnFail = true;
        }

        tempStr = getCellStringValue(row
                .getCell(ModelConstants.DetailsSheet.FAIL_TEST_IF_FAIL));
        if (StringUtils.isNotBlank(tempStr)
                && tempStr.trim().equalsIgnoreCase("N")) {
            this.failTestCaseIfFails = true;
        }
    }

    /**
     * Method getCellStringValue.
     * 
     * @param tempCell
     *            HSSFCell
     * @return String
     */
    private String getCellStringValue(final HSSFCell tempCell) {
        if (tempCell != null) {
            return tempCell.toString();
        } else {
            return "";
        }
    }

    /**
     * Method getAction.
     * 
     * @return String
     */
    public final String getAction() {
        return action;
    }

    /**
     * Method getWindowName.
     * 
     * @return String
     */
    public final String getWindowName() {
        return windowName;
    }

    /**
     * Method getReportingName.
     * 
     * @return String
     */
    public final String getReportingName() {
        return reportingName;
    }

    /**
     * Method getIdentifier.
     * 
     * @return String
     */
    public final String getIdentifier() {
        return identifier;
    }

    /**
     * Method getIdentifierType.
     * 
     * @return String
     */
    public final String getIdentifierType() {
        return identifierType;
    }

    /**
     * Method getData.
     * 
     * @return String
     */
    public final String getData() {
        return data;
    }

    /**
     * Method toString.
     * 
     * @return String
     */
    @Override
    public final String toString() {
        return "AutomationTestCaseStep [action=" + action + ", windowName="
                + windowName + ", reportingName=" + reportingName
                + ", identifier=" + identifier + ", identifierType="
                + identifierType + ", data=" + data + "]";
    }

    /**
     * Method isExitOnFail.
     * 
     * @return boolean
     */
    public final boolean isExitOnFail() {
        return exitOnFail;
    }

    /**
     * Method isFailTestCaseIfFails.
     * 
     * @return boolean
     */
    public final boolean isFailTestCaseIfFails() {
        return failTestCaseIfFails;
    }

    /**
     * Method getStatus.
     * 
     * @return TestStatus
     */
    public final TestStatus getStatus() {
        return status;
    }

    /**
     * Method setStatus.
     * 
     * @param status
     *            TestStatus
     */
    public final void setStatus(final TestStatus testStatus) {
        this.status = testStatus;
    }

    /**
     * @param actionOnStep
     *            the action to set
     */
    protected final void setAction(final String actionOnStep) {
        this.action = actionOnStep;
    }

    /**
     * @param windowReportingName
     *            the windowName to set
     */
    protected final void setWindowName(final String windowReportingName) {
        this.windowName = windowReportingName;
    }

    /**
     * @param reportingStepName
     *            the reportingName to set
     */
    protected final void setReportingName(final String reportingStepName) {
        this.reportingName = reportingStepName;
    }

    /**
     * @param identifierValue
     *            the identifier to set
     */
    protected final void setIdentifier(final String identifierValue) {
        this.identifier = identifierValue;
    }

    /**
     * @param stepIdentifierType
     *            the identifierType to set
     */
    protected final void setIdentifierType(final String stepIdentifierType) {
        this.identifierType = stepIdentifierType;
    }

    /**
     * @param stepData
     *            the data to set
     */
    protected final void setData(final String stepData) {
        this.data = stepData;
    }

    /**
     * @param exitOnStepFail
     *            the exitOnFail to set
     */
    protected final void setExitOnFail(final boolean exitOnStepFail) {
        this.exitOnFail = exitOnStepFail;
    }

    /**
     * @param failTestOnStepFailure
     *            the failTestCaseIfFails to set
     */
    protected final void setFailTestCaseIfFails(
            final boolean failTestOnStepFailure) {
        this.failTestCaseIfFails = failTestOnStepFailure;
    }

}
