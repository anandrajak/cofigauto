setlocal
set PATH=./drivers;
start java -Djava.ext.dirs=jars -Dlog4j.configuration=file:conf/log4j.xml -jar cofigauto-1-jar-with-dependencies.jar -f test_cases/Test_Scenarios.xls -d test_reports -p Automation_Report_