package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class pruebaConexion {
	
	public static void main(String[] args) {

			try {
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost/hotel?useTimeZone=true&serverTimeZone=UTC"
						,"root"
						,"Mixalis212025"
								);
				System.out.println("Entro");
				con.close();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
	
	}
	
}
