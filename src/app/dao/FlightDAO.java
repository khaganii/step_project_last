package app.dao;

import app.console.Console;
import app.console.ConsoleMain;
import app.entities.Flight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO implements DAO<Flight> {
  ConsoleMain console = new ConsoleMain();
    @Override
    public Flight get(int id) {
      List<Flight> flights = new ArrayList<>(read());
      Flight flight = null;
      for (Flight f: flights) {
        if (f.getId() == id){
          flight = f;
          break;
        }
      }
      return flight;
    }

    @Override
    public List<Flight> getAll() {
      return read();
    }

    public List<Flight> read(){
      List<Flight> flights = new ArrayList<>();
      try {
        File file = new File("src/app/files/Flights.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null){
          String [] arr = line.split(",");
          flights.add(new Flight(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], Integer.parseInt(arr[4]), Integer.parseInt(arr[5])));
        }
      } catch (Exception e) {
        console.printLn("FILE INPUT OUTPUT ERROR");
      }
      return flights;
    }

}
