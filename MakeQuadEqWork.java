//Importing everything
import javax.swing.*;
import java.awt.event.*;

public class MakeQuadEqWork implements ActionListener, Runnable {
    QuadEquation gui;
    Thread playing;
    
    public MakeQuadEqWork(QuadEquation in) {
        gui = in;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if(command.equals("Solve")) {
            startSolving();
        }
        if(command.equals("Reset")) {
            clearAllFields();
        }
        if(command.equals("Random Numbers")) {
            addRandomNumbers();
        }
        if(command.equals("Your Numbers")) {
            yourNumbers();
        }
    }
    
    public void addRandomNumbers() {
            int num1;
            int num2;
            int num3;
            
            num1 = (int)Math.floor(Math.random()*50 + 1);
            num2 = (int)Math.floor(Math.random()*50 + 1);
            num3 = (int)Math.floor(Math.random()*50 + 1);
            
            gui.inputboxes[0].setText("" + num1);
            gui.inputboxes[1].setText("" + num2);
            gui.inputboxes[2].setText("" + num3);
    }
    
    public void startSolving() {
        playing = new Thread(this);
        playing.start();
        gui.solvebutton.setEnabled(false);
        gui.resetbutton.setEnabled(true);
        gui.manual.setEnabled(true);
        gui.random.setEnabled(true);
        
        double a = Integer.parseInt("0" + gui.inputboxes[0].getText());
        double b = Integer.parseInt("0" + gui.inputboxes[1].getText());
        double c = Integer.parseInt("0" + gui.inputboxes[2].getText());
        
        float answer1 = (float) (-b + Math.sqrt((b * b)-4 * a * c)/(2 * a));
        float answer2 = (float) (-b - Math.sqrt((b * b)-4 * a * c)/(2 * a));
        
        gui.answerone.setText("" + answer1);
        gui.answertwo.setText("" + answer2);
        
        checkAnswer();
    }
    
    void clearAllFields() {
        for(int i = 0; i < 3; i++) {
            gui.inputboxes[i].setText(null);
        }
        gui.answerone.setText(null);
        gui.answertwo.setText(null);
        gui.solvebutton.setEnabled(true);
    }
    
    void addOneToField(JTextField field) {
        int num = Integer.parseInt("0" + field.getText());
        num++;
        field.setText("" + num);
        
    }
    
    public void checkAnswer() {
        String answer = gui.answerone.getText();
        String noNaN = answer.replace("NaN", "Does Not Exist");
        gui.answerone.setText(noNaN);
        
        String answer1 = gui.answertwo.getText();
        String noNaN1 = answer1.replace("NaN", "Does Not Exist");
        gui.answertwo.setText(noNaN1);
    }
    
    void yourNumbers() {
        for(int i = 0; i < 3; i++) {
            gui.inputboxes[i].setText(null);
        }
        gui.answerone.setText(null);
        gui.answertwo.setText(null);
        gui.solvebutton.setEnabled(true);
    }
    
    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        
        while(playing == thisThread) {
            
        }
    }
    
}
