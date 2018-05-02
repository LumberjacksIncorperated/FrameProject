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
import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {
    //-----------------------------------------------------------------------------------------------------------------------
    // FUNCTIONAL CODE
    //-----------------------------------------------------------------------------------------------------------------------    
    private JLabel textDisplayedOnWindow;
    
    private Window(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.addLabel();
        this.pack();
    }
    
    private void addLabel(){
        textDisplayedOnWindow = new JLabel("I'm a label in the window",SwingConstants.CENTER);
        textDisplayedOnWindow.setPreferredSize(new Dimension(300, 100));
        this.getContentPane().add(textDisplayedOnWindow, BorderLayout.CENTER);
    }
    
    public static Window createWindow(){
        Window newWindow = new Window();
        return newWindow;
    }
    
    public void showWindow() {
        this.setVisible(true);
    }
    
    public void updateTextDisplayedOnWindow(String newTextToDisplayOnWindow) {
        textDisplayedOnWindow.setText(newTextToDisplayOnWindow);
    }

    //-----------------------------------------------------------------------------------------------------------------------
    // TESTING CODE
    //-----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        runTests();
    }

    private static void runTests() {
        createWindowTest();
        showWindowTest();
        updateTextDisplayedOnWindowTest();
    }
    
    private static void createWindowTest() {
        Window testWindow = Window.createWindow();
        assert(testWindow != null);
        testWindow.setVisible(false);
        testWindow.dispose();
    }
    
    private static void showWindowTest() {
        Window testWindow = Window.createWindow();
        testWindow.showWindow();
        assert(testWindow.isShowing());
        testWindow.setVisible(false);
        testWindow.dispose();
    }
    
    private static void updateTextDisplayedOnWindowTest() {
        Window testWindow = Window.createWindow();
        testWindow.showWindow();
        testWindow.updateTextDisplayedOnWindow("Expected Text");
        assert( testWindow.textDisplayedOnWindow.getText().equals("Expected Text") );
        testWindow.setVisible(false);
        testWindow.dispose();
    }
}









