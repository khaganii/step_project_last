package app.service;

import app.console.ConsoleMain;
import app.dao.BookingDAO;
import app.entities.Booking;
import app.entities.Flight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BookingService {
    ConsoleMain console = new ConsoleMain();
    BookingDAO bookingDAO = new BookingDAO();

    public  BookingService(){}

    public void writeToFile(String s){
      File file = new File("src/app/files/Bookings.txt");
      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(s);
        bw.close();
      }   catch (IOException ex){
        console.printLn("IO EXCEPTION FOUND!");
      }
    }

  public void cancelBooking(int id){
    if(bookingDAO.get(id) != null){
      console.printLn(represent(bookingDAO.get(id)));
      console.print("  === CANCELLED === ");
      //delete from file
    }
    else {
      console.printLn("Flight not found!");
    }
    console.printLn("\n");
  }

  public String represent(Booking booking){
    return String.format("BOOKING ID: %d , PERSON{%s} , FLIGHT{%s}", booking.getBookingId(), booking.getPerson().toString(), booking.getFlight().toString());
  }

}
