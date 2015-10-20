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
    }
    
    void startSolving() {
        playing = new Thread(this);
        playing.start();
        gui.solvebutton.setEnabled(false);
        gui.resetbutton.setEnabled(true);
        gui.manual.setEnabled(true);
        gui.random.setEnabled(true);
    }
    
    void clearAllFields() {
        for(int i = 0; i < 3; i++) {
            gui.inputboxes[i].setText(null);
        }
        gui.answerone.setText(null);
        gui.answertwo.setText(null);
    }
    
    public void actionPerfomed(ActionEvent event) {
        String command = event.getActionCommand();
        if(command.equals("Random Numbers")) {
            for(int i = 0; i < 3; i++) {
                int pick;
                do {
                    pick = (int)Math.floor(Math.random()*50 + 1);
                } while (numberGone(pick, gui.inputboxes, i));
                gui.inputboxes[i].setText("" + pick);
            }
        } else {
            for(int i = 0; i < 3; i++) {
                gui.inputboxes[i].setText(null);
            }
        }
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
    
    public void run() {
        Thread thisThread = Thread.currentThread();
        
        while(playing == thisThread) {
            
            //float a = inputboxes[0].getText();
        }
    }
    
}
