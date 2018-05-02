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

//-----------------------------------------------------------------------------------------------------------------------
// CLASS
//-----------------------------------------------------------------------------------------------------------------------
public class LiveInformationDisplay extends Thread {  
	
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
}   