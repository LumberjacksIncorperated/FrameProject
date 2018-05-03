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
import java.util.Scanner;

public class LiveInformationDisplayApplication {
    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------   
    private DisplayInformationDatabase displayInformationDatabase;
    private LiveInformationDisplay liveInformationDisplay;
    private Scanner commandLineInputReader = new Scanner(System.in);
    
    public LiveInformationDisplayApplication() {}
    
    public static void main(String args[]){
        if(args.length > 0 && args[0] != null && args[0].equals("-test")) {
            runTests();
        } else {
            runApplication();
        }
    }

    public static void runApplication() {
        LiveInformationDisplayApplication liveInformationDisplayApplication = new LiveInformationDisplayApplication();
        liveInformationDisplayApplication.setup();
        liveInformationDisplayApplication.start();
    }
    
    public void setup(){
        this.displayInformationDatabase = new DisplayInformationDatabase();
        this.liveInformationDisplay = LiveInformationDisplay.createWithLiveInformationDatabase(displayInformationDatabase);
    }
    
    public void start(){
        this.liveInformationDisplay.start();
        this.runUserInteractionLoop();
    }
    
    private void runUserInteractionLoop() {
        while(true) {
            runSingleUserInteraction();
        }
    }
    
    private void runSingleUserInteraction() {
        printUserDisplayMessage();
        String userInput = getUserInput();
        addInputToDatabase(userInput);
    }
    
    private void printUserDisplayMessage() {
        System.out.println("\n*** LiveInformationDisplayApplication ***");
        System.out.println("Enter an Entry: ");
    }
    
    private String getUserInput() {
        String userInputString = this.commandLineInputReader.nextLine();
        return userInputString;
    }
    
    private void addInputToDatabase(String inputToAddToDatabase) {
        this.displayInformationDatabase.addDisplayInformationEntry(inputToAddToDatabase);
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING APPLICATION CODE
    //-----------------------------------------------------------------------------------------------------------------------
    private static void runTests() {
        setupTest();
        startTest();
    }
    
    private static void setupTest() {
        LiveInformationDisplayApplication liveInformationDisplayApplication = new LiveInformationDisplayApplication();
        liveInformationDisplayApplication.setup();
        assert(liveInformationDisplayApplication.displayInformationDatabase != null);
        assert(liveInformationDisplayApplication.displayInformationDatabase == liveInformationDisplayApplication.liveInformationDisplay.getDisplayInformationDatabase());
    }
    
    private static void startTest() {
        LiveInformationDisplayApplication liveInformationDisplayApplication = new LiveInformationDisplayApplication();
        liveInformationDisplayApplication.setup();
        liveInformationDisplayApplication.modifiedStart();
        assert(liveInformationDisplayApplication.liveInformationDisplay.displayIsShowing());
        System.exit(1); // TO FIX
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING UTILITY FUNCTIONS
    //-----------------------------------------------------------------------------------------------------------------------
    private void modifiedStart(){
        this.liveInformationDisplay.start();
    }
}
