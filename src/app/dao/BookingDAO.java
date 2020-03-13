package app.dao;

import app.console.ConsoleMain;
import app.entities.Booking;
import app.entities.Flight;
import app.entities.Person;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO implements DAO<Booking> {
  ConsoleMain console = new ConsoleMain();
    @Override
    public Booking get(int id) {
      List<Booking> bookings = new ArrayList<>(read());
      Booking booking= null;
      for (Booking b: bookings) {
        if (b.getBookingId() == id){
          booking = b;
          break;
        }
      }
      return booking;
    }

    @Override
    public List<Booking> getAll() {
        return read();
    }

    public List<Booking> read(){
      List<Booking> bookings = new ArrayList<>();
      try {
        File file = new File("src/app/files/Bookings.txt");
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String st;
        while (true){
          if ((st = bf.readLine()) == null) break;
          String [] arrAll = st.split(" , ");
          String [] arrId = arrAll[0].split(" "); //arrId[2] => Booking Id;
          String [] arrPerson = arrAll[1].split(" ");  //arrPerson[1] = name, arrPerson[2] = surname
          String [] arrF = arrAll[2].split(" "); //arrFlight[1] = FlytId , [3] = from, [5] = to , [7] = time , [10] = allseats
          bookings.add(new Booking(Integer.parseInt(arrId[2]), new Person(arrPerson[1], arrPerson[2]), new Flight(Integer.parseInt(arrF[1]), arrF[3], arrF[5], arrF[7],0, Integer.parseInt(arrF[11]))));
        }
      } catch (IOException e) {
        console.printLn("Error about reading from Bookings.txt");
      }
      return bookings;
    }

}


