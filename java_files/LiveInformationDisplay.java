//-----------------------------------------------------------------------------------------------------------------------
//
// PROJECT
// -------
// "Live Information Display Project"
//
// AUTHOR
// ------
// Lumberjacks Incorperated (2018)
//
//-----------------------------------------------------------------------------------------------------------------------

//-----------------------------------------------------------------------------------------------------------------------
// IMPORTS
//-----------------------------------------------------------------------------------------------------------------------
// <NONE>

public class LiveInformationDisplay extends Thread {
    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------    
    private final DisplayInformationDatabase displayInformationDatabase;
    private final Window displayInformationWindow;
    
    private LiveInformationDisplay(DisplayInformationDatabase displayInformationDatabase) {
        this.displayInformationDatabase = displayInformationDatabase;
        this.displayInformationWindow = Window.createWindow();
        this.displayInformationWindow.showWindow();
    }
    
    public static LiveInformationDisplay createWithLiveInformationDatabase(DisplayInformationDatabase displayInformationDatabase) {
        LiveInformationDisplay newLiveInformationDisplay = new LiveInformationDisplay(displayInformationDatabase);
        return newLiveInformationDisplay;
    }
    
    public void run(){
        while(true) {
            this.sleepForApplicationDelayTime();
            this.updateDisplayWithNewInformationFromDatabase();
        }
    }
    
    private final int APPLICATION_DELAY_TIME = 5000;
    private void sleepForApplicationDelayTime(){
        try {
            Thread.sleep(APPLICATION_DELAY_TIME);
        } catch (Exception e) {
            // Nothing
        }
    }
    
    private void updateDisplayWithNewInformationFromDatabase() {
        String entryFromDatabase = this.displayInformationDatabase.getADisplayInformationEntry();
        if(entryFromDatabase != null) {
            this.displayInformationWindow.updateTextDisplayedOnWindow(entryFromDatabase);
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        createWithLiveInformationDatabaseTest();
    }
    
    private static void createWithLiveInformationDatabaseTest() {
        DisplayInformationDatabase testDatabase = new DisplayInformationDatabase();
        LiveInformationDisplay testLiveInformationDisplay = LiveInformationDisplay.createWithLiveInformationDatabase(testDatabase);
        assert(testLiveInformationDisplay.displayInformationDatabase == testDatabase);
        assert(testLiveInformationDisplay.displayInformationWindow != null);
        assert(testLiveInformationDisplay.displayInformationWindow.isShowing());
        testLiveInformationDisplay.displayInformationWindow.setVisible(false);
        testLiveInformationDisplay.displayInformationWindow.dispose();
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING UTILITY FUNCTIONS
    //-----------------------------------------------------------------------------------------------------------------------
    public DisplayInformationDatabase getDisplayInformationDatabase() {
        return this.displayInformationDatabase;
    }

    public boolean displayIsShowing() {
        return this.displayInformationWindow.isShowing();
    }
}
