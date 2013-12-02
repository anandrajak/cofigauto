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
import com.cofigauto.internal.ValidTestStatus;
import com.cofigauto.model.AutomationTestCase;
import com.cofigauto.model.AutomationTestCaseStep;
import com.cofigauto.model.AutomationTestSuite;

/**
 * @author Vinay Sharma
 *
 */
public class ReportBuilder {
	private String fileDir="test_reports";
	private String fileNamePrefix = "Execution_Report_";
	private BufferedWriter output;
	
	private static final Logger logger = LoggerFactory.getLogger(ReportBuilder.class);
	
	public ReportBuilder(){
		File file = new File(fileDir);
		if(!file.exists()){
			file.mkdir();
		}
	}
	
	public ReportBuilder(String reportPath){
		if(StringUtils.isNotBlank(reportPath)){
			this.fileDir = reportPath;
		}
		File file = new File(fileDir);
		if(!file.exists()){
			file.mkdir();
		}
	}
	
	public ReportBuilder(String reportDirectoryPath, String fileNamePrefix){
		if(StringUtils.isNotBlank(reportDirectoryPath)){
			this.fileDir = reportDirectoryPath;
		}
		
		if(StringUtils.isNotBlank(fileNamePrefix)){
			this.fileNamePrefix=fileNamePrefix;
		}
		File file = new File(fileDir);
		if(!file.exists()){
			file.mkdir();
		}
	}
	
	/**
	 * Method buildReport.
	 * @param suite AutomationTestSuite
	 * @return String
	 */
	public String buildReport(AutomationTestSuite suite) {
		String reportPath = "no report";
		try {
			reportPath = createReport();

			for (AutomationTestCase testCase : suite.getTests()) {
				createTableHeader(testCase);
				for (AutomationTestCaseStep step : testCase.getSteps()) {
					this.writeTestCaseResult(step);
				}
				createTableFooter(testCase);
			}
			closeReport();
		} catch (Exception e) {
			logger.error("Exception occurred",e);
			reportPath = "Exception occurred";
		}
		return reportPath;

	}
	
	// ************************************************************************************************************
	// *** CREATE REPORT FILE ***
	// ************************************************************************************************************

	/**
	 * Method createReport.
	 * @return String
	 * @throws IOException
	 */
	private String createReport() throws IOException {

			File file = new File(fileDir + File.separator + fileNamePrefix+ GetDateTime() + ".html");
			output = new BufferedWriter(new FileWriter(file));
			output.write("<html><body>");
			output.write("<center><h2> <u>AUTOMATED TEST EXECUTION REPORT</u></h2></center>");
			return file.getPath();
		
	}

	// ************************************************************************************************************
	// *** WRITE TEST CASE PASS RESULT IN REPORT FILE ***
	// ************************************************************************************************************
	/**
	 * Method writeTestCaseResult.
	 * @param step AutomationTestCaseStep
	 * @throws IOException
	 */
	void writeTestCaseResult(AutomationTestCaseStep step) throws IOException {

		if(output==null){
			throw new ToolRuntimeException("Exception while writing to report. Writer object is null");
		}
		
			output.write("<tr>");
			output.write("<td width=100 bgcolor=#EFFBF5  align=middle><font face=arial size=2 color=black>" + step.getAction()
					+ "</font></td>");
			output.write("<td width=100 bgcolor=#EFFBF5  align=middle><font face=arial size=2 color=black>" + step.getReportingName()
					+ "</font></td>");
			output.write("<td width=150 bgcolor=#EFFBF5  align=middle><font face=arial size=2 color=black>" + step.getIdentifierType()+"-"+step.getIdentifier()
					+ "</font></td>");
			if(step.getStatus()!=null){
				if(step.getStatus().getStatus().equals(ValidTestStatus.FAIL)){
					output.write("<td width=100 bgcolor=#EFFBF5  align=middle><font face=arial size=2 color=RED><b>"+step.getStatus().getStatus()+"</b></font></td>");
				}else {
					output.write("<td width=100 bgcolor=#EFFBF5  align=middle><font face=arial size=2 color=green><b>"+step.getStatus().getStatus()+"</b></font></td>");
				}
				output.write("<td width=100 bgcolor=#EFFBF5  align=middle><font face=arial size=2><b>"+step.getStatus().getStatusDesc()+"</b></font></td>");
			} else {
				output.write("<td width=100 bgcolor=#EFFBF5  align=middle><font face=arial size=2 color=black ><b>"+ValidTestStatus.NOT_RUN+"</b></font></td>");
				output.write("<td width=100 bgcolor=#EFFBF5  align=middle><font face=arial size=2><b></b></font></td>");
			}
			output.write("</tr>");
	}
	// ************************************************************************************************************
	// *** GET CURRENT SYSTEM DATE & TIME ***
	// ************************************************************************************************************
	/**
	 * Method GetDateTime.
	 * @return String
	 */
	private String GetDateTime() {
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
			logger.error("Exception Occurred ", e);
		}
		
		return now.toString();
	}
	// ************************************************************************************************************
	// *** CLOSE REPORT FILE ***
	// ************************************************************************************************************
	private void closeReport() {
		try {
			output.close();
		} catch (Exception e) {
			logger.error("Exception Occurred ", e);
		}
	}

	// ************************************************************************************************************
	// *** CREATE TABLE HEADER OF REPORT FILE ***
	// ************************************************************************************************************
	/**
	 * Method createTableHeader.
	 * @param testCase AutomationTestCase
	 * @throws IOException
	 */
	private void createTableHeader(AutomationTestCase testCase) throws IOException {
		GetDateTime();
		
			output.write("<font face=arial size=3><b>Test Scenario Name	::	</b>  </font> <font face=arial size=2>"
					+ testCase.getFeatureName() + "</font></br>");
			output.write("<font face=arial size=3><b>Browser ::	</b>  </font> <font face=arial size=2>"
					+ testCase.getBrowserName() + "</font></br>");
			
			if(testCase.getStatus().equals(ValidTestStatus.PASS)){
				output.write("<font face=arial size=3><b>Result ::	</b>  </font> <font face=arial size=2>PASS</font></br>");
			} else if(testCase.getStatus().equals(ValidTestStatus.FAIL)){
				output.write("<font face=arial size=3><b>Result ::	</b>  </font> <font face=arial size=2 color=RED>FAIL</font></br>");
			} else if(testCase.getStatus().equals(ValidTestStatus.NOT_RUN)){
				output.write("<font face=arial size=3><b>Result ::	</b>  </font> <font face=arial size=2>NOT_RUN</font></br>");
			}
			
			
			output.write("<font face=arial size=3><b>Execution Start Time	::	</b>  </font> <font face=arial size=2><b>"
					+ GetDateTime() + "</b> </font></br></br>");
			output.write("<font face=arial size=3><b>Scenario Description	::	</b>  </font> <b> <font face=arial size=2>"
					+ testCase.getDescription() + "</b> </font></br>");
			output.write("<table cellpadding=0 cellspacing=0 width=1000 border=2 bordercolor=BLACK>");
			output.write("<tr>");
			output.write("<td width=150 bgcolor=#0404B4 align=middle><font face=arial size=2 color=white><b>ACTION</b></font></td>");
			output.write("<td width=100 bgcolor=#0404B4 align=middle><font face=arial size=2 color=white><b>STEP Description</b></font></td>");
			output.write("<td width=150 bgcolor=#0404B4 align=middle><font face=arial size=2 color=white><b>OBJECT</b></font></td>");
			output.write("<td width=100 bgcolor=#0404B4 align=middle><font face=arial size=2 color=white><b>RESULT</b></font></td>");
			output.write("<td width=100 bgcolor=#0404B4 align=middle><font face=arial size=2 color=white><b>EXTRA INFORMATION</b></font></td>");
			output.write("</tr>");

	}
	
	// ************************************************************************************************************
	// *** CREATE TABLE HEADER OF REPORT FILE ***
	// ************************************************************************************************************
	/**
	 * Method createTableFooter.
	 * @param testCase AutomationTestCase
	 * @throws IOException
	 */
	private void createTableFooter(AutomationTestCase testCase) throws IOException {
		GetDateTime();
			output.write("</table> <br/>");

	}
}
