/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverImplementation;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import Interface.Interface;


/**
 *
 * @author Thisitha Kavinda
 */
public class serverImplementation extends UnicastRemoteObject implements Interface{
        Connection conn;
    public serverImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/game", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     
	public boolean AdminLogin(String userName, String password) throws RemoteException {
		boolean result = false; //false
		try 
		{			
			
			String sql = "SELECT * FROM login WHERE userName = '" + userName + "' AND password= '" + password +"'";
			
			PreparedStatement  pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();

					while (rs.next()) {
						if (rs.getString("password").equalsIgnoreCase(password)) {				
							result = true;														 
						} else {
							result = false;
							
						}
					}
						return result; //result		
	
			} 
			catch(Exception e) 
			{
				System.out.println("Implementation error in cath clouse");
				System.out.println(e.getMessage().toString());
				return false;
			}
		

		
		
	}
}
