package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class RegistroHuespedDao {
	final private Connection con;

	public RegistroHuespedDao (Connection con) {
		this.con = con;
	}
	

	public void registrarBooking(java.util.Date date, java.util.Date date2, String method, Long price) {
		String sql = "INSERT INTO bookings (entry_date,departure_date,price,payment_method) Values"
				+ "(?,?,?,?) ";
		try(con) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				

	            pstmt.setDate(1, new Date(date.getTime()));
	            pstmt.setDate(2, new Date(date2.getTime()));
				pstmt.setString(4, method);
				pstmt.setLong(3, price);
				
				pstmt.executeUpdate();
			}
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "El registro fallo debido un problema interno.");
			throw new RuntimeException(e);
		}
	}


	public Long registraUsuario(String apellido, String nombre, java.util.Date fechaNacimiento, String telefono, String nacionalidad,
			Long bookingId) {
		String sql = "INSERT INTO guests (first_name,last_name,birth_date,nationality,phone_number,booking_id) Values"
				+ "(?,?,?,?,?,?) ";
		Long generatedId = null;
		try(con) {
			try(PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
				

	            pstmt.setString(1,nombre);
	            pstmt.setString(2, apellido);
				pstmt.setDate(3, new Date(fechaNacimiento.getTime()));
				pstmt.setString(4, telefono);
				pstmt.setString(5, nacionalidad);
				pstmt.setLong(6, bookingId);
				
				pstmt.executeUpdate();
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if(generatedKeys.next()) {
					generatedId = generatedKeys.getLong(1);
				}
				JOptionPane.showMessageDialog(null, "El registro fue un exito");
			}
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "El registro fallo debido un problema interno.");
			throw new RuntimeException(e);
		}
		return generatedId;	
	}
}
