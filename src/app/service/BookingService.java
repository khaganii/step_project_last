package app.service;

import app.console.ConsoleMain;
import app.dao.BookingDAO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BookingService {
    ConsoleMain console = new ConsoleMain();
    BookingDAO daoBooking;
    public BookingService(BookingDAO daoBooking) {
        this.daoBooking = daoBooking;
    }

    public  BookingService(){}

    public void writeToFile(String s){
      File file = new File("src/main/java/app/files/Bookings.txt");
      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(s);
        bw.close();
      }   catch (IOException ex){
        console.print("IO EXCEPTION FOUND!");
      }
    }

}
