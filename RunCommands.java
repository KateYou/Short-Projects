import java.net.*;
import java.io.*;

/**
	 * Takes int from class ClientProgram and uses switch statement to return appropriate linux command to ClientProgram.
	 * @author Kathryn Youngberg
	 * UNF Class: COP4504 Networks
	 * Project: 2
	 *
*/

public class RunCommands {

    /**
     *
     * @param theInput
     * @return the Linux command chosen by user
     */
    public String processInput(int theInput) {  //user's int input passed in
        String theOutput = null;
        String command;
        String prefix = "You chose ";
        int chooseMenu;

        try{
            chooseMenu = theInput;  //store user's int input

            if (chooseMenu > 5) {   //note the error
                System.out.print("\nError!\n");
            }
            switch (chooseMenu) {  //user's input determines which command is stored and passed back to client program
                case 1:
                    System.out.println(prefix + "Host's current Time\n"+ "");
                    command = "date +'%T'";
                    theOutput = command;
                    break;
                case 2:
                    System.out.println(prefix +"Host's uptime\n"+ "");
                    command = "uptime";
                    theOutput = command;
                    break;
                case 3:
                    System.out.println(prefix + "Host's memory use\n"+"");
                    command = "free "+ "-m";
                    theOutput = command;
                    break;
                case 4:
                    System.out.println(prefix + "Host's current users\n"+"");
                    command = "who -q";
                    theOutput = command;
                    break;
                case 5:
                    System.out.println(prefix + "Exit. Thanks and goodbye.");
                    theOutput = "Bye";
                    break;
                default:
                    break;
            }
        } catch(Throwable t) {
            t.printStackTrace();
        }
        return theOutput;  //returns String
    }
}