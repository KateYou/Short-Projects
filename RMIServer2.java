import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Creates registry, creates new instance of RemoteImpl and binds it.
 * Starts Server.
 * Displays message that the Server is running.
 * @author Kathryn Youngberg
 * UNF Class: COP4504 Networks
 * Project: 2
 */

public class RMIServer2 {
	/**    
	 * @param args
     * @throws java.rmi.RemoteException
     * @throws java.rmi.AlreadyBoundException
	 */
	public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        RemoteImpl impl = new RemoteImpl();
        Registry registry = LocateRegistry.createRegistry(Constant.RMI_Port);
        registry.rebind(Constant.RMI_ID, impl);
        System.out.println("Server is running...");
    }
}