import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
	 * Interface TestRemote is invoked by TestClient 
	 * @author Kathryn Youngberg
	 * UNF Class: COP4504 Networks
	 * Project: 2
	 *
*/

public interface TestRemote extends Remote{

    /**
     * @param username
     * @return
     * @throws RemoteException
     */
    public String cmdLine(String username) throws RemoteException, IOException;
}