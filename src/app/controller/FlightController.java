package app.controller;

import app.console.ConsoleMain;
import app.entities.Flight;
import app.library.Main_Menu;
import app.library.Menu_operations;
import app.service.FlightService;

import java.util.ArrayList;
import java.util.List;

public class FlightController {
  ConsoleMain console = new ConsoleMain();
  FlightService flightService = new FlightService();
  Menu_operations menu_operations = new Menu_operations();
  BookingController bookingController = new BookingController();

    public void showBoard(){
      flightService.printToBoardAll();
    }

    public void showFlight(){
      System.out.println("\n      === Please, Enter flight ID ! ===");
      int id = menu_operations.enter_number();
      console.printLn("");
      flightService.printTOBoardOne(id);
    }

    public void searchAndBook() {
      //flightService.searching();
    }
}
