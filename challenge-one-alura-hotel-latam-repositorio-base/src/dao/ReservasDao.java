package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class ReservasDao {
	
	final private Connection con;

	public ReservasDao(Connection con) {
		this.con = con;
	}
	

	public Long registrarBooking(java.util.Date date, java.util.Date date2, String method, Long price) {
		String sql = "INSERT INTO bookings (entry_date,departure_date,price,payment_method) Values"
				+ "(?,?,?,?) ";
		Long generatedId = null;
		try(con) {
			try(PreparedStatement pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
				

	            pstmt.setDate(1, new Date(date.getTime()));
	            pstmt.setDate(2, new Date(date2.getTime()));
				pstmt.setString(4, method);
				pstmt.setLong(3, price);
				
				pstmt.executeUpdate();
				
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
				if(generatedKeys.next()) {
					generatedId = generatedKeys.getLong(1);
				}
			}
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "El registro fallo debido un problema interno.");
			throw new RuntimeException(e);
		}
		return generatedId;
	}
}
