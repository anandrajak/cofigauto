# Cofigauto in Action #

## Overview - Example test case ##
  1. Open test case excel configuration file (Test\_Scenarios.xls) located in "test\_cases" directory of tool's runtime that you downloaded.
  1. Go to **"main"** sheet - In a new row provide name of your test case and browser to run it https://sites.google.com/a/cofigauto.com/cofigauto/excel_main_sheet.PNG?attredirects=0&d=1
  1. Create a sheet with same name as test case (Create copy of reference sheet). https://sites.google.com/a/cofigauto.com/cofigauto/excel_main_sheet_highlighted.png?attredirects=0&d=1
  1. Configure actions like "launch" a link, "click" on a button, "enter value" in text box etc. https://sites.google.com/a/cofigauto.com/cofigauto/excel_test_case_steps_sheet_highlighted.png?attredirects=0&d=1
  1. Save excel and run automation test. https://sites.google.com/a/cofigauto.com/cofigauto/tool_run.png?attredirects=0&d=1


## Example Test Case Explained ##
> Lets have a deeper look in example test case that is bundled with the tool.
### Excel - Main Sheet Configuration ###
Main sheet is a summary of all the test cases that you have created in this excel workbook. Below image shows a row of this sheet for example test case.
https://sites.google.com/a/cofigauto.com/cofigauto/excel_main_sheet_row.png?attredirects=0&d=1

Lets see what is the meaning of each column in this sheet and what have we configured for example test case
  1. **S. No.** - Test case number. This can be left blank.
  1. **Feature\_Name** - Unique name of test case. Tool will look for a sheet with the same name in workbook and execute test steps configured in it.
  1. **Description** - Small description of test case to increase readability of sheet. This field can be left blank.
  1. **RUN** - This field is used as ON / OFF button for a test case. Test case will be run if value of this field is 'Y' else test case will not be run.
  1. **Browser** - Browser on which you want to run the test case. See section [Browsers Supported by tool](#Browsers_Supported_by_tool.md) for supported browsers.
  1. **Close Window On Exit** - Do you want tool to close browser window after completing test run. If nothing or 'Y' is entered as value then tool will close window after running the test case else it won't.
  1. **Manual Test Scenario Mapping** - This is for QA information purpose. User can enter text here to map the test case to a test case in some test plan.
### Excel - Test Case Configuration ###
TBD
### Actions supported by tool ###
TBD
### Browsers Supported by tool ###
TBD
### Element Identifiers ###
TBD