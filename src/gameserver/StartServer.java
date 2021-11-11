package GameServer;

import java.rmi.RemoteException;  
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import serverImplementation.serverImplementation;
import Interface.Interface;
public class StartServer {
	public static void main(String[] args) {

		// TODO Auto-generated constructor stub
		System.out.println("Starting The Server............!!!");
		try {
			Interface rmt_intface=new serverImplementation();
			Registry game_reg=LocateRegistry.createRegistry(2021);
			game_reg.rebind("GameService2021", rmt_intface);
			
			System.out.println("Game Server started,Game Service is running now....!");
			
		} catch (RemoteException e) {
			// TODO: handle exception
			System.out.println("Error....!!!"+e.toString());
			e.printStackTrace();
		}
	 
	}

}
