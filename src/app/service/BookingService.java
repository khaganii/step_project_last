package app.service;

import app.console.ConsoleMain;
import app.dao.BookingDAO;
import app.entities.Booking;
import app.entities.Flight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

  public boolean check_space(File file){
    return (file.length() == 0);
  }

  public void cancelBooking(int id){
      boolean find = false;
      Flight plusFreeSeats;
      if(bookingDAO.get(id) != null){
        List<Booking> bookings = new ArrayList<>(bookingDAO.getAll());
        StringBuilder sb = new StringBuilder();
        for (Booking b : bookings) {
          if (b.getBookingId() != id) {
            if(!find){
              plusFreeSeats = b.getFlight();
              int s = plusFreeSeats.getFreeSeats()+1;
              plusFreeSeats.setFreeSeats(s);
            }
            sb.append(represent(b));
            sb.append("\n");
          } else {
            find = true;
            console.printLn(represent(b));
            console.printLn("");
            console.print("  === CANCELLED === ");
          }
        }
        writeToFile(sb.toString());
      }
      console.printLn("\n");
  }

  public String represent(Booking booking){
    return String.format("BOOKING ID: %d , PERSON{ %s } , FLIGHT{ %s }", booking.getBookingId(), booking.getPerson().toString(), booking.getFlight().toString());
  }

}
