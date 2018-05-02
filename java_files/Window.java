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

//-----------------------------------------------------------------------------------------------------------------------
// CLASS
//-----------------------------------------------------------------------------------------------------------------------
public class Window extends JFrame {
    
    private JLabel textDisplayedOnWindow;
    
    public Window(){
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
}
