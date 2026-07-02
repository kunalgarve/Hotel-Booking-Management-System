package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.tka.system.Booking;
import com.tka.system.Customer;
import com.tka.system.DBUtil;
import com.tka.system.Room;

public class Booking_Dao {

	// Add new customer
	public void addCustomer(Customer customer) {
		String sql = "INSERT INTO customers(name, email, phone) VALUES (?, ?, ?)";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getEmail());
			ps.setString(3, customer.getPhone());
			ps.executeUpdate();
			System.out.println("✅ Customer added successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addRoom(Room room) {
		String sql = "INSERT INTO rooms(room_number, type, price, status) VALUES (?, ?, ?, ?)";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, room.getRoomNumber());
			ps.setString(2, room.getType());
			ps.setDouble(3, room.getPrice());
			ps.setBoolean(4, room.isAvailable());
			ps.executeUpdate();
			System.out.println("✅ Room added successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Make a booking
	public void makeBooking(Booking booking) {
		String sql = "INSERT INTO bookings(customer_id, room_id, check_in, check_out) VALUES (?, ?, ?, ?)";
		try (Connection conn = DBUtil.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, booking.getCustomerId());
			ps.setInt(2, booking.getRoomId());
			ps.setDate(3, new Date(booking.getCheckinDate().getTime()));
			ps.setDate(4, new Date(booking.getCheckoutDate().getTime()));
			ps.executeUpdate();
			System.out.println("✅ Booking created successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Show all rooms
	public List<Room> getAllRooms() {
		List<Room> rooms = new ArrayList<>();
		String sql = "SELECT * FROM rooms";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Room room = new Room(rs.getInt("room_id"), rs.getString("room_number"), rs.getString("type"),
						rs.getDouble("price"), rs.getBoolean("status"));
				rooms.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	// Show all customers
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		String sql = "SELECT * FROM customers";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Customer customer = new Customer(rs.getInt("customer_id"), rs.getString("name"), rs.getString("email"),
						rs.getString("phone"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	// Show all bookings
	public List<Booking> getAllBookings() {
		List<Booking> bookings = new ArrayList<>();
		String sql = "SELECT * FROM bookings";
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Booking booking = new Booking(rs.getInt("booking_id"), rs.getInt("customer_id"), rs.getInt("room_id"),
						rs.getDate("check_in"), rs.getDate("check_out"));
				bookings.add(booking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookings;
	}
}