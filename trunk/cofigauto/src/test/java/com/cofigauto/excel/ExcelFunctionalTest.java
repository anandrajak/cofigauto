package com.cofigauto.excel;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class ExcelFunctionalTest {

	private static final Logger LOG = LoggerFactory.getLogger(ExcelFunctionalTest.class);

	HSSFWorkbook testCaseExcel ;
	private List<Object[]> testCases = new ArrayList<Object[]>();
	
	/*private List<Object[]> testCasesDetails = new ArrayList<Object[]>();*/

	@Before
	public void setup() {
		try {
			testCaseExcel = new HSSFWorkbook(ExcelFunctionalTest.class.getClassLoader().getResourceAsStream(
					"Test_Scenario.xls"));
			
			processMainSheet();
			processTestCaseDetails();
			
		} catch (Exception e) {
			LOG.error("Exception in setup ", e);
			fail("Exception in setup");
		}

	}

	@Test
	public void testAll() {
		System.out.println("testAll start ########################");

		System.out.println("testAll end ########################");
	}

	private void processMainSheet(){
		HSSFSheet mainSheet = testCaseExcel.getSheetAt(0);
		int count = 1;
		for (; count <= 1000; count++) {
			HSSFRow row = mainSheet.getRow(count);
			if (row == null || row.getCell(0) == null) {
				break;
			}
			Object[] temp = new Object[] {
					Double.valueOf(row.getCell(TestConstants.MainSheet.SERIAL_NO).getNumericCellValue()).intValue(),
					row.getCell(TestConstants.MainSheet.FEATURE_NAME),
					row.getCell(TestConstants.MainSheet.DESCRIPION), row.getCell(TestConstants.MainSheet.RUN) };
			LOG.debug("TEST CASE= "+Arrays.toString(temp));
			
			if(temp[TestConstants.MainSheet.RUN].toString().trim().equalsIgnoreCase("Y")){
				testCases.add(temp);
			} else {
				LOG.debug("RUN is 'N'. Ignored TestCase with Feature Name "+ temp[TestConstants.MainSheet.FEATURE_NAME]);
			}			
		}
		LOG.info("Total TestCases to be executed are " + (count - 1));
		
	}
	
	private void  processTestCaseDetails(){
		
		for(Object[] objArr : testCases){
			LOG.debug("Processing TestCase details for Feature Name "+ objArr[TestConstants.MainSheet.FEATURE_NAME]);
			HSSFSheet sheet = testCaseExcel.getSheet(objArr[TestConstants.MainSheet.FEATURE_NAME].toString());
			if(sheet!=null){
				LOG.debug("Sheet found with name "+objArr[TestConstants.MainSheet.FEATURE_NAME].toString());
			}else{
				LOG.error("No sheet found with name "+objArr[TestConstants.MainSheet.FEATURE_NAME].toString());
			}
		}
		
	}
	
	/**
	 */
	static class TestConstants {
		/**
		 */
		static class MainSheet {
			static int SERIAL_NO = 0;
			static int FEATURE_NAME = 1;
			static int DESCRIPION = 2;
			static int RUN = 3;
		}
		/**
		 */
		static class DetailsSheet {
			static int ACTION = 0;
			static int WINDOW = 1;
			static int OBJECT = 2;
			static int IDENIFIER = 3;
			static int DATA = 4;
		}
	}

}
