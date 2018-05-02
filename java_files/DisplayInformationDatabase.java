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
import java.util.LinkedList;
import java.util.Queue;

//-----------------------------------------------------------------------------------------------------------------------
// CLASS
//-----------------------------------------------------------------------------------------------------------------------
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
}
