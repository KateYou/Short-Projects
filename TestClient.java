import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
	 *
     * Takes String arg from user to set up Registry and connect to RMIServer2 on Server. Prompts user for int input, passes int to 
	 * RunCommands which returns String to TestClient, then sends String to remote server. Gets and displays returned 
	 * String response from remote server and prompts user for another input with a loop.
	 * @author Kathryn Youngberg
	 * UNF Class: COP4504 Networks
	 * Project: 2
	 *
*/

public class TestClient {

    /**
	 *
     * @param args 1
     */
    public static void main(String[] args) {
		if (args.length != 1) {
            System.err.println(
                    "Command should resemble: java TestClient <host name>");
            System.exit(1);
        }

        String hostName = args[0];
		
		try {
			Registry registry = LocateRegistry.getRegistry(hostName,Constant.RMI_Port);
			TestRemote remote = (TestRemote) registry.lookup(Constant.RMI_ID);
			System.out.println("");
			System.out.println("Connected to server...");

			Scanner stdIn = new Scanner(System.in);
			RunCommands rc = new RunCommands();

			int fromUser;
			String toServer;
			String fromServer;
			long endTime;
			long startTime;
			long totalTime = 0;
			long avgTimeCount = 0;
			long avgTime =0;

			String cmdMenu = "\n"
							  + "Learn stats about your remote connection.\n"
							  + "Please select a number from the options below:\n"
							  + "----------------------------------------------\n"
							  + "Options:\n"
							  + "\n"
							  + "     1. Host's current time\n"
							  + "     2. Host's uptime\n"
							  + "     3. Host's free memory\n"
							  + "     4. Host's number of current users\n"
							  + "     5. Exit\n"
							  + "";

			while(true) {
				System.out.println(cmdMenu);    //display menu
				while (!stdIn.hasNextInt()) {   //validate for int value
						System.out.println("That's not a number! Please try again:");
						System.out.println(cmdMenu);
						stdIn.next();
				}
				fromUser = stdIn.nextInt();  //get user int input, store value

				outer:while (true) {   //loop will run menu selection program until user chooses Exit
					while(fromUser < 1 || fromUser > 7)  {  //validate for int range
							System.out.println("You entered an invalid number. Try again.");
							break outer;  //use scanner validation to deal with above instead.
					}

					toServer = rc.processInput(fromUser);  //runs class to get linux command from user input, stores value

					if (toServer.equals("Bye")) {  //exit if the resulting command indicates exit chosen
							System.exit(0);  //break outer;
					}

					startTime = System.nanoTime();  //starts the clock

					fromServer = remote.cmdLine(toServer);  //calls the method
					Scanner fromSvr = new Scanner(fromServer);
					
					System.out.println("Command has been sent."); //debug print

					//calculate time elapsed, total time elapsed and average time elapsed
					endTime = System.nanoTime()- startTime;
					long endTm = TimeUnit.MILLISECONDS.convert(endTime, TimeUnit.NANOSECONDS);
					totalTime = totalTime + endTm;
					avgTimeCount++;
					avgTime = totalTime / avgTimeCount;
					
					//display the results
					System.out.println("");					
					System.out.println("Server response: ");
					while(!(fromServer = fromSvr.nextLine()).equals("end)) {
						System.out.println(fromServer);
					}
					System.out.println("");
					System.out.println("Response in ms: " + endTm);
					System.out.println("Total time in ms: " + totalTime);
					System.out.println("Average response time in ms: " + avgTime);
					System.out.println("");
					
					System.out.println(cmdMenu);  //display menu

					//validate for int value
					while(!stdIn.hasNextInt()) {  
							System.out.println("That's not a number! Please try again:");
							System.out.println(cmdMenu);
							stdIn.next();  //get next value
					}
					fromUser = stdIn.nextInt();  //get user int input, store value
				}
			}
		} catch (RemoteException e) {  //catch errors
			e.printStackTrace();
			System.exit(1);
        } catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
        } catch (NotBoundException e) {
			System.exit(1);
        }
    }
}