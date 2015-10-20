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
        
        float a = Integer.parseInt("0" + gui.inputboxes[0].getText());
        float b = Integer.parseInt("0" + gui.inputboxes[1].getText());
        float c = Integer.parseInt("0" + gui.inputboxes[2].getText());
        
        float answer1 = -b + Math.sqrt((b * b)-4 * a * c)/(2 * a);
        float answer2 = -b - Math.sqrt((b * b)-4 * a * c)/(2 * a);
        
        gui.answerone.setText("" + answer1);
        gui.answertwo.setText("" + answer2);
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
    
    boolean numberGone(int num, JTextField[] pastNums, int count) {
        for(int i = 0; i < count; i++) {
            if(Integer.parseInt(pastNums[i].getText()) == num) {
                return true;
            }
        }
        return false;
        }
    
    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        
        while(playing == thisThread) {
            
        }
    }
    
}
