package app.controller;


import app.console.ConsoleMain;
import app.library.EnterNumber;
import app.service.BookingService;

public class BookingController {
  ConsoleMain console = new ConsoleMain();
  EnterNumber enterNumber = new EnterNumber();
  BookingService bookingService = new BookingService();

  public void cancelBooking() {
    console.printLn("Please Enter Booking ID: ");
    int id = enterNumber.enter_number();
    console.printLn("");
    bookingService.cancelBooking(id);
  }

  public void myFlights() {
    bookingService.getAllBookings();
  }
}
