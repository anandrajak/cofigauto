package com.cofigauto.runner;

import java.io.FileInputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cofigauto.exception.ToolRuntimeException;
import com.cofigauto.model.AutomationTestSuite;

/**
 * @author Vinay Sharma
 * @version 1.1
 */
public final class XmlTestSuitRunner extends AbstractTestSuitRunner
        implements
            TestSuitRunner {

    /**
     * slf4j logger instance.
     */
    private static final Logger LOG = LoggerFactory
            .getLogger(XmlTestSuitRunner.class);

    /**
     * XML Schema.
     */
    private Schema schema = null;

    /**
     * Private default constructor.
     */
    public XmlTestSuitRunner() {
    }

    /**
     * Method runTestSuite.
     * 
     * @param xmlFilePath
     *            String
     * @return AutomationTestSuite
     */
    public AutomationTestSuite runTestSuite(final String xmlFilePath) {
        AutomationTestSuite suit = null;

        try {

            JAXBContext jaxbContext = JAXBContext
                    .newInstance(AutomationTestSuite.class);
            Unmarshaller jaxbunmarshaller = jaxbContext.createUnmarshaller();

            if (this.schema == null) {
                initSchema();
            }

            jaxbunmarshaller.setSchema(schema);

            suit = (AutomationTestSuite) jaxbunmarshaller
                    .unmarshal(new FileInputStream(xmlFilePath));
        } catch (Exception e) {
            LOG.error("Exception Occurred", e);
            System.exit(0);
        }

        this.runTestSuit(suit);

        return suit;

    }

    /**
     * init schema from XSD file.
     */
    private void initSchema() {
        try {
            SchemaFactory sf = SchemaFactory
                    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            this.schema = sf.newSchema(this.getClass().getClassLoader()
                    .getResource("cofigauto-model.xsd"));
        } catch (Exception e) {
            throw new ToolRuntimeException(e.getMessage(), e);
        }
    }
}