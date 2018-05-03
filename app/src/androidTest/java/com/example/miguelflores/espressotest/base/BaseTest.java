package com.example.miguelflores.espressotest.base;

/**
 * Created by miguel.flores
 */
public class BaseTest {

    protected boolean allowSleepPresentation = true;

    /**
     * method used to sleep for a moment a test just to see the execution
     *
     * @param millis
     */
    public void sleepPresentation(long millis) {
        if (allowSleepPresentation) {
            sleep(millis);
        }
    }

    /**
     * TODO I need to check if we can use idling resources instead of this
     * method used to sleep the execution, could be used to wait until a precess is done
     *
     * @param millis
     */
    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
