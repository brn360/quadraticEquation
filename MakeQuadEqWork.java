//Importing everything
import javax.swing.*;
import java.awt.event.*;

//The overarching class
public class MakeQuadEqWork implements ActionListener, Runnable {
    QuadEquation gui;
    Thread playing;
    
    //This links the gui
    public MakeQuadEqWork(QuadEquation in) {
        gui = in;
        
    }
    
    //This gives all of the buttons different assignments
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        //Solve button
        if(command.equals("Solve")) {
            startSolving();
        }
        //Reset button
        if(command.equals("Reset")) {
            clearAllFields();
        }
        //Random number generator button
        if(command.equals("Random Numbers")) {
            addRandomNumbers();
        }
        //Your number button
        if(command.equals("Your Numbers")) {
            yourNumbers();
        }
    }
    
    //The code that runs when the random number button is clicked
    public void addRandomNumbers() {
            int num1;
            int num2;
            int num3;
            
            //Creates three random numbers
            num1 = (int)Math.floor(Math.random()*100-50);
            num2 = (int)Math.floor(Math.random()*100-50);
            num3 = (int)Math.floor(Math.random()*100-50);
            
            //Assigns those random numbers to three textfields
            gui.inputboxes[0].setText("" + num1);
            gui.inputboxes[1].setText("" + num2);
            gui.inputboxes[2].setText("" + num3);
            
            gui.solvebutton.setEnabled(true);
    }
    
    //The code that runs when the solve button is clicked
    public void startSolving() {
        playing = new Thread(this);
        playing.start();
        gui.solvebutton.setEnabled(false);
        gui.resetbutton.setEnabled(true);
        gui.manual.setEnabled(true);
        gui.random.setEnabled(true);
        
        //Gets the numbers in the text fields
        double a = Double.parseDouble(gui.inputboxes[0].getText());
        double b = Double.parseDouble(gui.inputboxes[1].getText());
        double c = Double.parseDouble(gui.inputboxes[2].getText());
        
        //Does the math with those three numbers
        float answer1 = (float) (((-b) + Math.sqrt(((b * b)-(4 * a * c))))/(2 * a));
        float answer2 = (float) (((-b) - Math.sqrt(((b * b)-(4 * a * c))))/(2 * a));
        
        //Randomness
        if(answer1 = 420) {
            gui.answerone.setText("Dank Memes");
        }
        if(answer2 = 420) {
            gui.answertwo.setText("Dank Memes");
        }
        if(answer1 = 9) {
            gui.answerone.setText("Mr. Skeltal");
        }
        if(answer2 = 9) {
            gui.answertwo.setText("Mr. Skeltal");
        }
        if(answer1 = 69) {
            gui.answerone.setText("");
        }
        if(answer2 = 69) {
            gui.answertwo.setText("");
        }
        if(answer1 = .81) {
            gui.answerone.setText("Asadi");
        }
        if(answer2 = .81) {
            gui.answertwo.setText("Asadi");
        }
        
        //Sets the answers to the textfields
        gui.answerone.setText("" + answer1);
        gui.answertwo.setText("" + answer2);
        
        checkAnswer();
    }
    
    //The code that runs when the reset button is clicked
    void clearAllFields() {
        for(int i = 0; i < 3; i++) {
            gui.inputboxes[i].setText(null);
        }
        gui.answerone.setText(null);
        gui.answertwo.setText(null);
        gui.solvebutton.setEnabled(true);
    }
    
    //The code that runs to make sure the answer exists
    public void checkAnswer() {
        //Basically this checks the textfields for the string NaN and then whenever it finds it replaces it with the string Does Not Exist
        String answer = gui.answerone.getText();
        String noNaN = answer.replace("NaN", "Does Not Exist");
        gui.answerone.setText(noNaN);
        
        String answer1 = gui.answertwo.getText();
        String noNaN1 = answer1.replace("NaN", "Does Not Exist");
        gui.answertwo.setText(noNaN1);
    }
    
    //The code that runs when the your numbers button is clicked
    void yourNumbers() {
        for(int i = 0; i < 3; i++) {
            gui.inputboxes[i].setText(null);
        }
        gui.answerone.setText(null);
        gui.answertwo.setText(null);
        gui.solvebutton.setEnabled(true);
    }
    
    //The method that makes the class run
    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        
        while(playing == thisThread) {
            
        }
    }
    
}
