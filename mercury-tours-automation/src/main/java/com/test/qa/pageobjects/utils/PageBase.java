package com.test.qa.pageobjects.utils;

import org.testng.Assert;

/**
 * Created by ChandikaH on 5/20/2017.
 */
public class PageBase {

    protected StringBuffer verificationErrors = new StringBuffer();

    public PageBase() {

    }

    /**
     * Assert Verify True
     *
     * @param condition
     * @param message
     */
    public void verifyTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition, message);
        } catch (AssertionError error) {
            this.verificationErrors.append(error.getMessage());
            error.printStackTrace();
        }
    }

    /**
     * Assert Verify False
     *
     * @param condition
     * @param message
     */
    public void verifyFalse(boolean condition, String message) {
        try {
            Assert.assertFalse(condition, message);
        } catch (AssertionError error) {
            this.verificationErrors.append(error.getMessage());
            error.printStackTrace();
        }
    }

    /**
     * Assert Verify Equals
     *
     * @param actual
     * @param expected
     * @param message
     */
    public void verifyEquals(Object actual, Object expected, String message) {
        try {
            Assert.assertEquals(actual, expected, message);
        } catch (AssertionError error) {
            this.verificationErrors.append(error.getMessage());
            error.printStackTrace();
        }
    }

    /**
     * Print Error messages After append to the VerificationErrorString
     *
     */
    public void checkForVerificationErrors() {
        String verificationErrorString = this.verificationErrors.toString();
        this.clearVerificationErrors();
        if(!"".equals(verificationErrorString)) {
            Assert.fail(verificationErrorString);
        }

    }

    /**
     * clear verifications once test is completed
     *
     */
    public void clearVerificationErrors() {
        this.verificationErrors = new StringBuffer();
    }

    /**
     * Make an explicit delay
     *
     * @param timeout
     */
    public static void waitFor(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println("Failed to Wait...!");
            e.printStackTrace();
        }
    }


}
