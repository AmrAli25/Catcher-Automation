package utils;


import org.testng.*;

public class TestngListener implements ISuiteListener, ITestListener, IInvokedMethodListener {

    ////////////////////////////////////////////////////////////
    ////////////////////// ISuiteListener /////////////////////
    //////////////////////////////////////////////////////////
    @Override
    public void onStart(ISuite suite) {
        System.out.println("\n" + "**********************************************");
        System.out.println("Starting Test Suite; By Amr Ali *");
        System.out.println("**********************************************" + "\n");
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("\n" + "**********************************************");
        System.out.println("Finished Test Suite; By Amr Ali *");
        System.out.println("**********************************************" + "\n");
    }

    ////////////////////////////////////////////////////////////
    ////////////////////// ITestListener //////////////////////
    //////////////////////////////////////////////////////////
    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n" + "**************************************************** " + "Test: ["
                + context.getName() + "] Started" + " ****************************************************" + "\n");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n" + "**************************************************** " + "Test: ["
                + context.getName() + "] Finished" + " ****************************************************" + "\n");
    }


    ////////////////////////////////////////////////////////////
    ///////////////// IInvokedMethodListener //////////////////
    //////////////////////////////////////////////////////////
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("\n" + "============================================================================================");
        if (method.isConfigurationMethod()) {
            System.out.println("Starting Configuration Method (Setup or Teardown): [" + testResult.getName() + "]");
        } else {
            System.out.println("Starting Test Case: [" + testResult.getName() + "]");
        }
        System.out.println("============================================================================================" + "\n");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("\n" + "===========================================================================================");
        if (method.isConfigurationMethod()) {
            System.out.println("Finished Configuration Method (Setup or Teardown): [" + testResult.getName() + "]");
        } else {
            System.out.println("Finished Test Case: [" + testResult.getName() + "]");
        }
        System.out.println("===========================================================================================" + "\n");
    }
}

