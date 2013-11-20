package com.cofigauto.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.exception.ToolRuntimeException;
import com.cofigauto.internal.ValidTestStatus;

/**
 */
public class AutomationTestCase {
	private String serialNumber;
	private String featureName;
	private String description;
	private boolean run=Boolean.FALSE;
	private String browserName;
	private boolean closeBrowserOnExit = true;
	private List<AutomationTestCaseStep> steps = new ArrayList<AutomationTestCaseStep>();
	private ValidTestStatus status = ValidTestStatus.NOT_RUN;

	private static final Logger LOG = LoggerFactory.getLogger(AutomationTestCase.class);

	/**
	 * Constructor for AutomationTestCase.
	 * @param row HSSFRow
	 * @param xls HSSFWorkbook
	 */
	AutomationTestCase(HSSFRow row, HSSFWorkbook xls) {
		if (row == null || row.getCell(0) == null || StringUtils.isBlank(row.getCell(0).toString().trim())) {
			throw new ToolRuntimeException("row is null");
		}

		if (HSSFCell.CELL_TYPE_NUMERIC == row.getCell(ModelConstants.MainSheet.SERIAL_NO).getCellType()) {
			this.serialNumber = ((Double) row.getCell(ModelConstants.MainSheet.SERIAL_NO).getNumericCellValue())
					.toString();
		} else {
			this.serialNumber = row.getCell(ModelConstants.MainSheet.SERIAL_NO).getStringCellValue();
		}

		this.featureName = row.getCell(ModelConstants.MainSheet.FEATURE_NAME).getStringCellValue();
		this.description = row.getCell(ModelConstants.MainSheet.DESCRIPION).getStringCellValue();
		this.browserName = row.getCell(ModelConstants.MainSheet.BROWSER_NAME).getStringCellValue();
		
		String tempVal = row.getCell(ModelConstants.MainSheet.RUN).getStringCellValue();
		if (tempVal.equalsIgnoreCase("Y")) {
			this.run = Boolean.TRUE;
		}
		
		tempVal = row.getCell(ModelConstants.MainSheet.CLOSE_DRIVER_ON_EXIT).getStringCellValue();
		if (tempVal.equalsIgnoreCase("N")) {
			this.closeBrowserOnExit = Boolean.FALSE;
		}

		HSSFSheet sheet = xls.getSheet(this.featureName);
		if (sheet != null) {
			LOG.debug("Sheet found with name " + this.featureName);
			
			int count = 1;
			for (; count <= 1000; count++) {
				HSSFRow stepRow = sheet.getRow(count);
				if (stepRow == null || stepRow.getCell(0) == null || StringUtils.isBlank(row.getCell(0).toString().trim())) {
					break;
				}
				steps.add(new AutomationTestCaseStep(stepRow));
			}
			
			LOG.info("Total steps to be executed in test case are " + (count - 1));
		} else {
			LOG.error("No sheet found with name " + this.featureName);
		}
	}

	/**
	 * Method getSerialNumber.
	 * @return String
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Method getFeatureName.
	 * @return String
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * Method getDescription.
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Method isRun.
	 * @return boolean
	 */
	public boolean isRun() {
		return run;
	}

	/**
	 * Method getBrowserName.
	 * @return String
	 */
	public String getBrowserName() {
		return browserName;
	}

	/**
	 * Method getSteps.
	 * @return List<AutomationTestCaseStep>
	 */
	public List<AutomationTestCaseStep> getSteps() {
		return steps;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "AutomationTestCase [serialNumber=" + serialNumber + ", featureName=" + featureName + ", description="
				+ description + ", run=" + run + ", browserName=" + browserName + ", steps=" + steps + "]";
	}

	/**
	 * Method getStatus.
	 * @return ValidTestStatus
	 */
	public ValidTestStatus getStatus() {
		return status;
	}

	/**
	 * Method setStatus.
	 * @param status ValidTestStatus
	 */
	public void setStatus(ValidTestStatus status) {
		this.status = status;
	}

	/**
	 * Method isCloseBrowserOnExit.
	 * @return boolean
	 */
	public boolean isCloseBrowserOnExit() {
		return closeBrowserOnExit;
	}

}
