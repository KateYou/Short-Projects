import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Called by TestClient on the client server, receives String from TestClient. 
 * Executes Linux String commands on local drive using external process p outside this Java program. 
 * Returns the output of Linux command as a String result to TestClient.  
 * @author Kathryn Youngberg
 * UNF Class: COP4504 Networks
 * Project: 2
 */

public class RemoteImpl extends UnicastRemoteObject implements TestRemote {
	private static final long serialVersionUID = 1L;

    /**
     *
     * @throws RemoteException
     */
    public RemoteImpl() throws RemoteException {
		super();
    }

    /**
     *
     * @param fromClient
     * @return the result of Linux command
     */
    @Override
    public String cmdLine(String fromClient) {  //passes in command
        String serverOutput = "";
        String command = "";

        command = fromClient;  //store String value from client
        System.out.println("Processing command " + command + "...");

        try {
            String printline;  //stores incoming data
            String output = "";

            Process p = Runtime.getRuntime().exec(command);  //start new process   command

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));  //runs,executes incoming command data through external process

            while ((printline = in.readLine()) !=null) {  //while client data is coming in/processing
                output = output + printline + "\n";  //format the server data
                serverOutput = output;   //store the data
            }
            serverOutput = serverOutput + "end";  //additional formatting with flag.  Is flag necessary here?

        } catch (Exception e) {  //display error message
                        e.printStackTrace();
                        System.exit(1);
        }

        return serverOutput;  //send the server data to client
	}
}
