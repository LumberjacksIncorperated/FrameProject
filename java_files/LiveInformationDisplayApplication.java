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

//-----------------------------------------------------------------------------------------------------------------------
// CLASS
//-----------------------------------------------------------------------------------------------------------------------
public class LiveInformationDisplayApplication {
    
    private DisplayInformationDatabase displayInformationDatabase;
    private LiveInformationDisplay liveInformationDisplay;
    private Scanner commandLineInputReader = new Scanner(System.in);
    
    public LiveInformationDisplayApplication() {}
    
    public static void main(String args[]){
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
}
