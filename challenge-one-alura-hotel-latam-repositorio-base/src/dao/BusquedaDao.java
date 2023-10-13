package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Booking;
import model.Guest;

public class BusquedaDao {

	final private Connection con;

	public BusquedaDao(Connection con) {
		this.con = con;
	}

	public List<Object> listarporId(Long id) {
		List<Object> resultado = new ArrayList<>();
		String sql = "SELECT guests.id, guests.first_name, guests.last_name, guests.nationality, "
		           + "guests.phone_number, guests.birth_date, guests.booking_id, "
		           + "bookings.id, bookings.entry_date, bookings.departure_date, "
		           + "bookings.price, bookings.payment_method "
		           + "FROM guests INNER JOIN bookings ON guests.booking_id = bookings.id "
		           + "WHERE guests.booking_id = ?";
		try (con) {
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				pstmt.setLong(1,id);
				
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					 Guest filaHuesped = new Guest(
							 rs.getLong("id"),
							 rs.getString("first_name"),
							 rs.getString("last_name"),
			                 rs.getString("nationality"),
			                 rs.getString("phone_number"), 
			                 rs.getDate("birth_date"),
			                 rs.getLong("booking_id"));
					 Booking filaReserva = new Booking(
							 rs.getLong("bookings.id"),
							 rs.getDate("bookings.entry_date"),
							 rs.getDate("bookings.departure_date"),
							 rs.getDouble("Bookings.price"),
							 rs.getString("bookings.payment_method"));

					resultado.add(filaHuesped);
					resultado.add(filaReserva);
				}
			}

			return resultado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> listarporApellido(String apellido) {
		List<Object> resultado = new ArrayList<>();
		String sql = "SELECT guests.id, guests.first_name, guests.last_name, guests.nationality, "
		           + "guests.phone_number, guests.birth_date, guests.booking_id, "
		           + "bookings.id, bookings.entry_date, bookings.departure_date, "
		           + "bookings.price, bookings.payment_method "
		           + "FROM guests INNER JOIN bookings ON guests.booking_id = bookings.id "
		           + "WHERE guests.last_name = ?";
		try (con) {
			try (PreparedStatement pstmt = con.prepareStatement(sql)) {
				
				pstmt.setString(1,apellido);
				
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					 Guest filaHuesped = new Guest(
							 rs.getLong("id"),
							 rs.getString("first_name"),
							 rs.getString("last_name"),
			                 rs.getString("nationality"),
			                 rs.getString("phone_number"), 
			                 rs.getDate("birth_date"),
			                 rs.getLong("booking_id"));
					 Booking filaReserva = new Booking(
							 rs.getLong("bookings.id"),
							 rs.getDate("bookings.entry_date"),
							 rs.getDate("bookings.departure_date"),
							 rs.getDouble("Bookings.price"),
							 rs.getString("bookings.payment_method"));

					resultado.add(filaHuesped);
					resultado.add(filaReserva);
				}
			}

			return resultado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void modificarHuespedes(Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono) {
		String sql = "UPDATE guests SET first_name= ? , last_name = ?,nationality = ?,phone_number = ?,"
				+ " birth_date = ? WHERE id = ? ";
		try (con) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setString(1, nombre);
				pstmt.setString(2, apellido);
				pstmt.setString(4, nacionalidad);
				pstmt.setString(3, telefono);
				pstmt.setDate(5, fechaNacimiento);
				pstmt.setInt(6, id);
				
				pstmt.executeUpdate();
				} 
			}catch (SQLException e) {
				throw new RuntimeException(e);
		}
	}

	public void modificarReservas(Integer id, Date checkIn, Date checkOut, Double valor, String formaPago) {
			String sql = "UPDATE bookings SET entry_date= ? , departure_date = ?,price = ?,payment_method = ?"
					+ " WHERE id = ? ";
			try (con) {
				try(PreparedStatement pstmt = con.prepareStatement(sql)){
					
					pstmt.setDate(1, checkIn);
					pstmt.setDate(2, checkOut);
					pstmt.setDouble(3, valor);
					pstmt.setString(4, formaPago);
					pstmt.setInt(5, id);
					
					pstmt.executeUpdate();
					} 
				}catch (SQLException e) {
					throw new RuntimeException(e);
			}
		
	}

	public void eliminarReserva(Integer id) {
		String sql = "DELETE FROM bookings WHERE id = ?";
		try (con) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setInt(1, id);
				
				pstmt.executeUpdate();
				} 
			}catch (SQLException e) {
				throw new RuntimeException(e);
		}
		
	}

	public void eliminarHuesped(Integer id) {
		String sql = "DELETE FROM guests WHERE id = ?";
		try (con) {
			try(PreparedStatement pstmt = con.prepareStatement(sql)){
				
				pstmt.setInt(1, id);
				
				pstmt.executeUpdate();
				} 
			}catch (SQLException e) {
				throw new RuntimeException(e);
		}
		
	}

}