package javaclass;

import static java.lang.Math.sqrt;
import java.util.*;

public class Pythagorean {
    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        
        //Prompt for sidetype
        int sideType;
        System.out.print("Are the sides both legs or is one a hypotenuse? " + "\n" + "Input a 1 for two legs or a 2 for a leg and hypotenuse." + "\n" + "1 or 2?:");
        sideType = user_input.nextInt();
        
        //Prompt for the first side
        double side1;
        System.out.print("Enter the first side: ");
        side1 = user_input.nextDouble();
        
        //Prompt for the second side
        double side2;
        System.out.print("Enter the second side: ");
        side2 = user_input.nextDouble();
        
        //Formula for if there are two legs
        double solution1;
        solution1 = sqrt((side1 * side1) + (side2 * side2));
        
        //Formula for if there is a leg and the hypotenuse
        double solution2;
        solution2 = sqrt((side2 * side2) - (side1 * side1));
        
        //Printing the solution
        if(sideType != 1) {
            System.out.println("The answer is " + solution2);    
        }
        else {
            System.out.println("The answer is " + solution1);
        }
    }
}
