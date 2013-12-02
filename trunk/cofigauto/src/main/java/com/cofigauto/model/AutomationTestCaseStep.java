package com.cofigauto.model;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

import com.cofigauto.exception.ToolRuntimeException;
import com.cofigauto.internal.TestStatus;

/**
 */
public class AutomationTestCaseStep {

	private String action;
	private String windowName;
	private String reportingName;
	private String identifier;
	private String identifierType;
	private String data;
	private boolean exitOnFail = false;
	private boolean failTestCaseIfFails = false;
	private TestStatus status;

	
	/**
	 * Constructor for AutomationTestCaseStep.
	 * @param row HSSFRow
	 */
	AutomationTestCaseStep(HSSFRow row)
	{
		if (row == null || row.getCell(0) == null) {
			throw new ToolRuntimeException("row is null");
		}
		
		this.action = getCellStringValue(row.getCell(ModelConstants.DetailsSheet.ACTION));
		this.windowName = getCellStringValue(row.getCell(ModelConstants.DetailsSheet.WINDOW_NAME));
		this.reportingName = getCellStringValue(row.getCell(ModelConstants.DetailsSheet.STEP_REPORTING_NAME));
		this.identifier = getCellStringValue(row.getCell(ModelConstants.DetailsSheet.IDENIFIER));
		this.identifierType = getCellStringValue(row.getCell(ModelConstants.DetailsSheet.IDENT_TYPE));
		this.data = getCellStringValue(row.getCell(ModelConstants.DetailsSheet.DATA));
		
		String tempStr = getCellStringValue(row.getCell(ModelConstants.DetailsSheet.EXIT_IF_FAIL));
		if(StringUtils.isNotBlank(tempStr) && tempStr.trim().equalsIgnoreCase("Y")){
			this.exitOnFail = true;
		}
		
		tempStr = getCellStringValue(row.getCell(ModelConstants.DetailsSheet.FAIL_TEST_IF_FAIL));
		if(StringUtils.isNotBlank(tempStr) && tempStr.trim().equalsIgnoreCase("N")){
			this.failTestCaseIfFails = true;
		}
	}
	
	/**
	 * Method getCellStringValue.
	 * @param tempCell HSSFCell
	 * @return String
	 */
	private String getCellStringValue(HSSFCell tempCell){
		if(tempCell!=null){
			return tempCell.toString();
		} else {
			return "";
		}
	}
	
	/**
	 * Method getAction.
	 * @return String
	 */
	public String getAction() {
		return action;
	}

	/**
	 * Method getWindowName.
	 * @return String
	 */
	public String getWindowName() {
		return windowName;
	}
	
	/**
	 * Method getReportingName.
	 * @return String
	 */
	public String getReportingName() {
		return reportingName;
	}
	
	/**
	 * Method getIdentifier.
	 * @return String
	 */
	public String getIdentifier() {
		return identifier;
	}
	
	/**
	 * Method getIdentifierType.
	 * @return String
	 */
	public String getIdentifierType() {
		return identifierType;
	}
	
	/**
	 * Method getData.
	 * @return String
	 */
	public String getData() {
		return data;
	}
	
	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "AutomationTestCaseStep [action=" + action + ", windowName=" + windowName + ", reportingName="
				+ reportingName + ", identifier=" + identifier + ", identifierType=" + identifierType + ", data="
				+ data + "]";
	}

	/**
	 * Method isExitOnFail.
	 * @return boolean
	 */
	public boolean isExitOnFail() {
		return exitOnFail;
	}

	/**
	 * Method isFailTestCaseIfFails.
	 * @return boolean
	 */
	public boolean isFailTestCaseIfFails() {
		return failTestCaseIfFails;
	}

	/**
	 * Method getStatus.
	 * @return TestStatus
	 */
	public TestStatus getStatus() {
		return status;
	}

	/**
	 * Method setStatus.
	 * @param status TestStatus
	 */
	public void setStatus(TestStatus status) {
		this.status = status;
	}

	
}
