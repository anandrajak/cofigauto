package com.cofigauto.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cofigauto.internal.command.BrowseBack;

/**
 * The class <code>ActionCommandFactoryTest</code> contains tests for the class
 * <code>{@link ActionCommandFactory}</code>.
 * 
 * @generatedBy CodePro at 9/11/13 11:19 AM
 * @author vsha28
 * @version $Revision: 1.0 $
 */
public class ActionCommandFactoryTest {
    /**
     * Run the ActionCommand getActionCommand(String) method test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @Test
    public void testGetActionCommand_1() throws Exception {
        String command = "";

        ActionCommand result = ActionCommandFactory.getActionCommand(command);

        // add additional test code here
        assertEquals(null, result);
    }

    /**
     * Run the ActionCommand registerActionCommand(String,ActionCommand) method
     * test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @Test(expected = com.cofigauto.exception.ToolRuntimeException.class)
    public void testRegisterActionCommand_1() throws Exception {
        String commandName = "";
        ActionCommand command = new BrowseBack();

        ActionCommand result = ActionCommandFactory.registerActionCommand(
                commandName, command);

        // add additional test code here
        // An unexpected exception was thrown in user code while executing this
        // test:
        // com.automation.exception.ToolRuntimeException: Error while
        // registering command. commandName or command is null
        // at
        // com.automation.internal.ActionCommandFactory.registerActionCommand(ActionCommandFactory.java:70)
        assertNotNull(result);
    }

    /**
     * Run the ActionCommand registerActionCommand(String,ActionCommand) method
     * test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @Test(expected = com.cofigauto.exception.ToolRuntimeException.class)
    public void testRegisterActionCommand_2() throws Exception {
        String commandName = "";
        ActionCommand command = new BrowseBack();

        ActionCommand result = ActionCommandFactory.registerActionCommand(
                commandName, command);

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the ActionCommand registerActionCommand(String,ActionCommand) method
     * test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @Test(expected = com.cofigauto.exception.ToolRuntimeException.class)
    public void testRegisterActionCommand_3() throws Exception {
        String commandName = "";
        ActionCommand command = null;

        ActionCommand result = ActionCommandFactory.registerActionCommand(
                commandName, command);

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the ActionCommand registerActionCommand(String,ActionCommand) method
     * test.
     * 
     * @throws Exception
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @Test(expected = com.cofigauto.exception.ToolRuntimeException.class)
    public void testRegisterActionCommand_4() throws Exception {
        String commandName = "";
        ActionCommand command = new BrowseBack();

        ActionCommand result = ActionCommandFactory.registerActionCommand(
                commandName, command);

        // add additional test code here
        assertNotNull(result);
    }

    /**
     * Perform pre-test initialization.
     * 
     * @throws Exception
     *             if the initialization fails for some reason
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @Before
    public void setUp() throws Exception {
        // add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     * 
     * @throws Exception
     *             if the clean-up fails for some reason
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    @After
    public void tearDown() throws Exception {
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     * 
     * @param args
     *            the command line arguments
     * 
     * @generatedBy CodePro at 9/11/13 11:19 AM
     */
    public static void main(String[] args) {
        new org.junit.runner.JUnitCore().run(ActionCommandFactoryTest.class);
    }
}
