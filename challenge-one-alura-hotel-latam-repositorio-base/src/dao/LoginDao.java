package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	final private Connection con;

	public LoginDao(Connection con) {
		this.con = con;
	}

	public boolean validarUsuario(String usuario, String contraseña) {
		boolean acceso = false;
		String sql = "SELECT * FROM users WHERE user_name = ? AND " +
		"user_password = ?";
		try (con) {
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(1, usuario);
				pstmt.setString(2, contraseña);
				ResultSet rs = pstmt.executeQuery();

				
				if(rs.next()) {
					acceso = true;
				}
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return acceso;
	}
}
