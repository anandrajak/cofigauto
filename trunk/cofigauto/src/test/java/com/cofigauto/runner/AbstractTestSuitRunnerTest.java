package com.cofigauto.runner;

import java.io.InputStream;
import java.lang.reflect.Constructor;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import junit.framework.TestCase;
import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Test;

import com.cofigauto.TestCaseContext;
import com.cofigauto.exception.ToolRuntimeException;
import com.cofigauto.internal.ActionCommand;
import com.cofigauto.internal.ActionCommandFactory;
import com.cofigauto.model.AutomationTestCase;
import com.cofigauto.model.AutomationTestCaseStep;
import com.cofigauto.model.AutomationTestSuite;
import com.cofigauto.model.TestStatus;
import com.cofigauto.model.ValidTestStatus;

/**
 * The class <code>AbstractTestSuitRunnerTest</code> contains tests for the
 * class {@link <code>AbstractTestSuitRunner</code>}
 * 
 * @pattern JUnit Test Case
 * 
 * @generatedBy CodePro at 12/13/13 11:15 AM
 * 
 * @author vinay sharma
 * 
 * @version $Revision$
 */

public class AbstractTestSuitRunnerTest extends TestCase {

    @Mocked
    ActionCommandFactory factory;
    @Mocked
    TestCaseContext.TestCaseContextBuilder builder;

    @Test
    public void testrunTestSuit() throws Exception {

        new NonStrictExpectations() {
            {
                new TestCaseContext.TestCaseContextBuilder();
                builder.getTestCaseContext();
                returns(new TestCaseContext());
               // result = new TestCaseContext.TestCaseContextBuilder();

                ActionCommandFactory.getActionCommand(anyString);
                result = new ActionCommand() {
                    @Override
                    public TestStatus execute(AutomationTestCaseStep step,
                            TestCaseContext context) {
                        TestStatus status = new TestStatus(
                                ValidTestStatus.PASS, "Mock");
                        if (step == null) {
                            return status;
                        } else {
                            step.setStatus(status);
                        }
                        return status;
                    }
                };

            }
        };

        AutomationTestCaseStep dummyStep = null;
        try {
            Constructor consturctor = AutomationTestCaseStep.class
                    .getDeclaredConstructor(new Class[] {});
            consturctor.setAccessible(true);
            dummyStep = ((AutomationTestCaseStep) consturctor
                    .newInstance(new Object[] {}));
        } catch (Exception e) {
            throw new ToolRuntimeException("Exception in getting constructor",
                    e);
        }

        System.out.println(ActionCommandFactory.getActionCommand("CLICK")
                .execute(dummyStep, null));

        System.out.println(ActionCommandFactory.getActionCommand("CLICK")
                .execute(null, null));

        TestSuitRunner runner = new AbstractTestSuitRunner() {
            @Override
            public AutomationTestSuite runTestSuite(String testFilePath) {
                InputStream stream = this.getClass().getClassLoader()
                        .getResourceAsStream("Test_Scenarios.xml");

                AutomationTestSuite suit = null;

                try {
                    JAXBContext jaxbContext = JAXBContext
                            .newInstance(AutomationTestSuite.class);
                    Unmarshaller jaxbunmarshaller = jaxbContext
                            .createUnmarshaller();

                    SchemaFactory sf = SchemaFactory
                            .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                    Schema schema = sf.newSchema(this.getClass()
                            .getClassLoader()
                            .getResource("cofigauto-model.xsd"));
                    jaxbunmarshaller.setSchema(schema);

                    suit = (AutomationTestSuite) jaxbunmarshaller
                            .unmarshal(stream);
                } catch (Exception e) {
                    throw new ToolRuntimeException(e.getMessage(), e);
                }

                this.runTestSuit(suit);

                return suit;
            }
        };

        runner.runTestSuite(this.getClass().getClassLoader()
                .getResource("Test_Scenarios.xml").getPath());

    }
}
