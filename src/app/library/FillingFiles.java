package app.library;

import app.console.ConsoleMain;
import app.dao.FlightDAO;
import app.entities.Booking;
import app.entities.Flight;
import app.entities.Person;
import app.service.BookingService;
import app.service.FlightService;

import java.util.*;

public class FillingFiles {
  Random random = new Random();
  ConsoleMain console = new ConsoleMain();
  public void fillFlights(){
    Map<String, Integer> Cities_seats = new HashMap<>();
    FlightService flightService = new FlightService();
    Cities_seats.put("Baku", 30);
    Cities_seats.put("London", 20);
    Cities_seats.put("Paris", 25);
    Cities_seats.put("Moscow", 30);
    Cities_seats.put("Berlin", 45);
    Cities_seats.put("Barcelona", 35);
    Cities_seats.put("Istanbul", 40);
    Cities_seats.put("Madrid", 30);
    Cities_seats.put("Chicago", 50);
    Cities_seats.put("Roma", 35);
    Cities_seats.put("Vienna", 45);
    Cities_seats.put("Porto", 30);
    Cities_seats.put("Helsinki", 25);
    Cities_seats.put("Sydney", 50);
    Cities_seats.put("Beijing", 35);
    StringBuilder sb = new StringBuilder();
    ArrayList<String> cities = new ArrayList<>(Cities_seats.keySet());

    for (int i = 0; i < 50; i++) {
      int freeSeat = (random.nextInt(10)+5);
      sb.append(i+1);
      sb.append(",");
      sb.append("Kiev");
      sb.append(",");
      String city = cities.get(random.nextInt(15));
      sb.append(city);
      sb.append(",");
      sb.append(MakeTime());
      sb.append(",");
      sb.append(freeSeat);
      sb.append(",");
      sb.append(Cities_seats.get(city));
      sb.append("\n");
    }
    flightService.writeToFile(sb.toString());
  }

  public void fillBookings(){
    BookingService bookingService = new BookingService();
    FlightDAO flightDAO = new FlightDAO();
    List<Flight> flights = new ArrayList<>(flightDAO.getAll());
    StringBuilder sb = new StringBuilder();
    String b;
    int k = 0;
    for (Flight f: flights) {
      for (int i = 1; i <= (f.getAllSeats()-f.getFreeSeats()); i++) {
        k++;
        Booking booking = new Booking(k, MakePerson(), f);
        b = booking.toString();
        sb.append(b);
        sb.append("\n");
      }
    }
    bookingService.writeToFile(sb.toString());
  }

  public Person MakePerson(){
    List<String> names = new ArrayList<>(Arrays.asList("Oliver", "Jack", "Harry", "Jacob", "Charlie", "Thomas", "George", "Oscar", "Olivia", "Lily", "Sophie", "Poppy"));
    List<String> surnames = new ArrayList<>(Arrays.asList("Smith", "Jones", "Williams", "Brown", "Davies", "Robinson", "Thompson", "Walker", "White", "Edwards", "Harris", "Linen"));
    Random random = new Random();
    Person person =  new Person(names.get(random.nextInt(names.size())), surnames.get(random.nextInt(names.size())));
    return person;
  }

  public static String MakeTime(){
    Random random = new Random();
    ArrayList<String > listDays = new ArrayList<>(Arrays.asList("12","13", "14", "15", "16", "17"));
    ArrayList<String> listHours = new ArrayList<>(Arrays.asList("00", "06", "09", "10", "12", "18", "20", "23"));
    ArrayList<String > listMinutes = new ArrayList<>(Arrays.asList("00", "15", "30", "45"));
    String time = "2020/03/";
    time += listDays.get(random.nextInt((listDays.size())));
    time += " ";
    time += listHours.get(random.nextInt((listHours.size())));
    time += ":";
    time += listMinutes.get(random.nextInt((listMinutes.size())));
    return time;
  }

}
