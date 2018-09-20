//-----------------------------------------------------------------------------------------------------------------------
//
// AUTHOR
// ------
// Lumberjacks Incorperated (2018)
//
//-----------------------------------------------------------------------------------------------------------------------
import java.util.LinkedList;
import java.util.Queue;

public class DisplayInformationDatabase {

    Queue<String> displayInformationQueue;
    
    public DisplayInformationDatabase(){
        this.displayInformationQueue = new LinkedList<>();
    }
    
    public void addDisplayInformationEntry(String newDisplayInformationEntry) {
        this.displayInformationQueue.add(newDisplayInformationEntry);
    }
    
    public String getADisplayInformationEntry() {
        String displayInformationEntry;
        if(queueIsNotEmpty()) {
            displayInformationEntry = this.displayInformationQueue.remove();
        } else {
            displayInformationEntry = null;
        }
        return displayInformationEntry;
    }
    
    private boolean queueIsNotEmpty() {
        boolean queueIsNotEmpty;
        if(this.displayInformationQueue.peek() != null) {
            queueIsNotEmpty = true;
        } else {
            queueIsNotEmpty = false;
        }
        return queueIsNotEmpty;
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        addDisplayInformationEntryTest();
        getADisplayInformationEntryTest();
    }
    
    private static void addDisplayInformationEntryTest() {
        DisplayInformationDatabase testDisplayInformationDatabase = new DisplayInformationDatabase();
        testDisplayInformationDatabase.addDisplayInformationEntry("TEST ENTRY");
        assert(testDisplayInformationDatabase.peekAtTopEntry().equals("TEST ENTRY"));
    }
    
    private static void getADisplayInformationEntryTest() {
        DisplayInformationDatabase testDisplayInformationDatabase = new DisplayInformationDatabase();
        testDisplayInformationDatabase.addDisplayInformationEntry("TEST ENTRY");
        String displayInformationnEntry = testDisplayInformationDatabase.getADisplayInformationEntry();
        assert(displayInformationnEntry.equals("TEST_ENTRY"));
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING UTILITY FUNCTIONS
    //-----------------------------------------------------------------------------------------------------------------------
    private String peekAtTopEntry() {
        return this.displayInformationQueue.peek();
    }
}
