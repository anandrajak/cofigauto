package com.cofigauto.model;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.excel.ExcelFunctionalTest;

/**
 */
public class JAXBTest {

    private static final Logger LOG = LoggerFactory.getLogger(JAXBTest.class);

    @Test
    public void testJAXBMarshalling() throws Exception {
        LOG.debug("start ########################");
        AutomationTestSuite suit = new AutomationTestSuite(
                ExcelFunctionalTest.class.getClassLoader()
                        .getResource("Test_Scenarios.xls").getPath());

        JAXBContext jaxbContext = JAXBContext
                .newInstance(AutomationTestSuite.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        // output pretty printed
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(suit, System.out);

        LOG.debug("end ########################");
    }

    @Test
    public void testJAXBUnmarshalling() throws Exception {
        LOG.debug("start ########################");

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
                + "<automationTestSuite>"
                + "<tests serialNumber=\"1.0\" featureName=\"EMAIL REGISTRATION\" description=\"EMAIL REGISTRATION\" run=\"true\" browserName=\"Firefox\" closeBrowserOnExit=\"false\">"
                + "<steps action=\"LAUNCH\" windowName=\"Gmail Login Launch\" reportingName=\"gmail login\" identifier=\"https://mail.google.com/\" identifierType=\"\" data=\"\" exitOnFail=\"true\" failTestCaseIfFails=\"true\"/>"
                + "<steps action=\"CLICK\" windowName=\"Gmail Login Launch\" reportingName=\"Gmail Login Launch\" identifier=\"gmail-sign-in\" identifierType=\"ID\" data=\"\" exitOnFail=\"true\" failTestCaseIfFails=\"true\"/>"
                + "<steps action=\"WAIT_UNTIL\" windowName=\"Gmail Login Page\" reportingName=\"WAIT UNTIL\" identifier=\"Email\" identifierType=\"ID\" data=\"20\" exitOnFail=\"false\" failTestCaseIfFails=\"false\"/>"
                + "<steps action=\"ENTER_VALUE\" windowName=\"Gmail Login Page\" reportingName=\"ENTER USERID\" identifier=\"Email\" identifierType=\"ID\" data=\"&lt;email id&gt;\" exitOnFail=\"false\" failTestCaseIfFails=\"true\"/>"
                + "<steps action=\"ENTER_VALUE\" windowName=\"Gmail Login Page\" reportingName=\"ENTER Password\" identifier=\"Passwd\" identifierType=\"ID\" data=\"&lt;password&gt;\" exitOnFail=\"false\" failTestCaseIfFails=\"true\"/>"
                + "<steps action=\"CLICK\" windowName=\"Gmail Login Page\" reportingName=\"SIGN IN\" identifier=\"signIn\" identifierType=\"ID\" data=\"\" exitOnFail=\"false\" failTestCaseIfFails=\"true\"/>"
                + "<steps action=\"WAIT_UNTIL\" windowName=\"INBOX\" reportingName=\"WAIT UNTIL\" identifier=\"gbg6\" identifierType=\"ID\" data=\"50\" exitOnFail=\"true\" failTestCaseIfFails=\"true\"/>"
                + "<steps action=\"CLICK\" windowName=\"INBOX\" reportingName=\"CLICK a mail link\" identifier=\"do-not-reply\" identifierType=\"linkText\" data=\"0\" exitOnFail=\"false\" failTestCaseIfFails=\"true\"/>"
                + "<steps action=\"WAIT\" windowName=\"Wait for mail\" reportingName=\"WAIT\" identifier=\"\" identifierType=\"\" data=\"10\" exitOnFail=\"false\" failTestCaseIfFails=\"true\"/>"
                + "<steps action=\"CLICK\" windowName=\"MAIL\" reportingName=\"MAIL LINK CLICK\" identifier=\"Confirm Email\" identifierType=\"linkText\" data=\"0\" exitOnFail=\"false\" failTestCaseIfFails=\"true\"/>"
                + "<steps action=\"WAIT\" windowName=\"WAIT\" reportingName=\"WAIT\" identifier=\"\" identifierType=\"\" data=\"20\" exitOnFail=\"false\" failTestCaseIfFails=\"false\"/>"
                + "<steps action=\"PRINT_TITLE\" windowName=\"PRINT_TITLE\" reportingName=\"PRINT_TITLE\" identifier=\"\" identifierType=\"\" data=\"\" exitOnFail=\"false\" failTestCaseIfFails=\"false\"/>"
                + "<steps action=\"SWITCH_WINDOW\" windowName=\"\" reportingName=\"\" identifier=\"\" identifierType=\"\" data=\"2\" exitOnFail=\"false\" failTestCaseIfFails=\"false\"/>"
                + "<steps action=\"PRINT_TITLE\" windowName=\"PRINT_TITLE\" reportingName=\"PRINT_TITLE\" identifier=\"\" identifierType=\"\" data=\"\" exitOnFail=\"false\" failTestCaseIfFails=\"false\"/>"
                + "<steps action=\"CLOSE_WINDOW\" windowName=\"CLOSE_WINDOW\" reportingName=\"CLOSE_WINDOW\" identifier=\"\" identifierType=\"\" data=\"2\" exitOnFail=\"false\" failTestCaseIfFails=\"false\"/>"
                + "<steps action=\"SWITCH_TO_MAIN_WINDOW\" windowName=\"SWITCH_TO_MAIN_WINDOW\" reportingName=\"SWITCH_TO_MAIN_WINDOW\" identifier=\"SWITCH_TO_MAIN_WINDOW\" identifierType=\"\" data=\"\" exitOnFail=\"false\" failTestCaseIfFails=\"false\"/>"
                + "<steps action=\"BROWSE_BACK\" windowName=\"INBOX\" reportingName=\"Go to inbox\" identifier=\"\" identifierType=\"\" data=\"\" exitOnFail=\"false\" failTestCaseIfFails=\"true\"/>"
                + "<steps action=\"PRINT_TITLE\" windowName=\"PRINT_TITLE\" reportingName=\"PRINT_TITLE\" identifier=\"\" identifierType=\"\" data=\"\" exitOnFail=\"false\" failTestCaseIfFails=\"false\"/>"
                + "<steps action=\"COMMAND_ONE\" windowName=\"\" reportingName=\"\" identifier=\"\" identifierType=\"\" data=\"\" exitOnFail=\"false\" failTestCaseIfFails=\"false\"/>"
                + "</tests>" + "</automationTestSuite>";

        InputStream stream = new ByteArrayInputStream(xml.getBytes("UTF-8"));

        AutomationTestSuite suit = null;
        JAXBContext jaxbContext = JAXBContext
                .newInstance(AutomationTestSuite.class);
        Unmarshaller jaxbunmarshaller = jaxbContext.createUnmarshaller();

        suit = (AutomationTestSuite) jaxbunmarshaller.unmarshal(stream);

        LOG.debug(suit.toString());
        LOG.debug("end ########################");
    }

    @Test
    public void testJAXBUnmarshallingFromFile() throws Exception {
        LOG.debug("start ########################");

        InputStream stream = this.getClass().getClassLoader()
                .getResourceAsStream("Test_Scenarios.xml");

        AutomationTestSuite suit = null;
        JAXBContext jaxbContext = JAXBContext
                .newInstance(AutomationTestSuite.class);
        Unmarshaller jaxbunmarshaller = jaxbContext.createUnmarshaller();
       
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
        Schema schema = sf.newSchema(this.getClass().getClassLoader().getResource("cofigauto-model.xsd")); 
        jaxbunmarshaller.setSchema(schema);
        
        suit = (AutomationTestSuite) jaxbunmarshaller.unmarshal(stream);

        LOG.debug(suit.toString());
        LOG.debug("end ########################");
    }

}
