//Importing all necessary packages
import javax.swing.*;
import java.awt.*;

//Declaring the main class
public class QuadEquation extends JFrame {
    MakeQuadEqWork Quad = new MakeQuadEqWork(this);
    
    //Setting up the first row with 2 buttons
    JPanel row1 = new JPanel();
    ButtonGroup choice = new ButtonGroup();
    JButton manual = new JButton("Your Numbers");
    JButton random = new JButton("Random Numbers");
    
    //Setting up row 2 with 3 textfields
    JPanel row2 = new JPanel();
    JTextField[] inputboxes = new JTextField[3];
    
    //setting up row 3 with two buttons
    JPanel row3 = new JPanel();
    JButton solvebutton = new JButton("Solve");
    JButton resetbutton = new JButton("Reset");
    
    //Setting up row 4 with two textfields
    JPanel row4 = new JPanel();
    JTextField answerone = new JTextField(5);
    JTextField answertwo = new JTextField(5);
    
    //Creating the frame of the gui and adding everything to it
    public QuadEquation() {
        super("Quadratic Equation Solver");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(4,0);
        setLayout(grid);
        setResizable(false);
        
        //I will add listeners here at some point
        random.addActionListener(Quad);
        
        //Adding row1 to the frame
        FlowLayout flo = new FlowLayout(FlowLayout.CENTER);
        choice.add(manual);
        choice.add(random);
        row1.setLayout(flo);
        row1.add(manual);
        row1.add(random);
        add(row1);
        
        //Adding row2 to the frame
        row2.setLayout(flo);
        for(int i = 0; i < 3; i++) {
            inputboxes[i] = new JTextField(5);
            row2.add(inputboxes[i]);
        }
        add(row2);
        
        //Adding row3 to the frame
        row3.setLayout(flo);
        row3.add(solvebutton);
        row3.add(resetbutton);
        add(row3);
        
        //Adding row4 to the frame
        row4.setLayout(flo);
        row4.add(answerone);
        row4.add(answertwo);
        add(row4);
        
        //Making it all visible
        setVisible(true);
        
    }
    
    //My main method
    public static void main(String[] args) {
        QuadEquation frame = new QuadEquation();
        
    }
    
}
