package com.tka.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.tka.dao.Booking_Dao;
import com.tka.system.Booking;
import com.tka.system.Customer;
import com.tka.system.Room;

public class main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Booking_Dao dao = new Booking_Dao();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		while (true) {
			System.out.println("\n==== Hotel Booking System ====");
			System.out.println("1. Add Customer");
			System.out.println("2. Add Room");
			System.out.println("3. Make Booking");
			System.out.println("4. View All Customers");
			System.out.println("5. View All Rooms");
			System.out.println("6. View All Bookings");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter customer name: ");
				String cname = sc.nextLine();
				System.out.print("Enter customer email: ");
				String email = sc.nextLine();
				System.out.print("Enter customer phone: ");
				String phone = sc.nextLine();

				Customer c = new Customer(0, cname, email, phone);
				dao.addCustomer(c);
				break;

			case 2:
				System.out.print("Enter room number: ");
				String roomNumber = sc.nextLine();
				System.out.print("Enter room type: ");
				String type = sc.nextLine();
				System.out.print("Enter room price: ");
				double price = sc.nextDouble();
				sc.nextLine(); // consume newline

				Room r = new Room(0, roomNumber, type, price, true);
				dao.addRoom(r);
				break;

			case 3:
				System.out.print("Enter customer ID: ");
				int customerId = sc.nextInt();
				System.out.print("Enter room ID: ");
				int roomId = sc.nextInt();
				sc.nextLine(); // consume newline

				System.out.print("Enter check-in date (yyyy-MM-dd): ");
				String inDate = sc.nextLine();
				System.out.print("Enter check-out date (yyyy-MM-dd): ");
				String outDate = sc.nextLine();

				try {
					Date checkin = sdf.parse(inDate);
					Date checkout = sdf.parse(outDate);
					Booking b = new Booking(0, customerId, roomId, checkin, checkout);
					dao.makeBooking(b);
				} catch (ParseException e) {
					System.out.println("❌ Invalid date format!");
				}
				break;

			case 4:
				List<Customer> customers = dao.getAllCustomers();
				System.out.println("\n--- All Customers ---");
				for (Customer cust : customers) {
					cust.display();
					
				}
				break;

			case 5:
				List<Room> rooms = dao.getAllRooms();
				System.out.println("\n--- All Rooms ---");
				for (Room room : rooms) {
					room.display();
				}
				break;

			case 6:
				List<Booking> bookings = dao.getAllBookings();
				System.out.println("\n--- All Bookings ---");
				for (Booking bk : bookings) {
					bk.display();
				}
				break;

			case 7:
				System.out.println("Exiting... Thank you!");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("❌ Invalid choice. Please try again.");
				break;
			}
		}
	}
}
