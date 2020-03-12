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
  Main_Menu main_menu = new Main_Menu();
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

    public void searching(){
      console.printLn(" === Enter Destination Where you wanna go! === ");
      String destination = console.readLn();
      console.printLn("                 ===== Results for your destination =====               ");
      console.printLn("");
      List<Flight> flightsByDestination = new ArrayList<>(flightService.printSearchByDestination(destination.trim()));

      if(flightsByDestination.size() != 0){
        console.printLn(" === Enter Date When you wanna go! Ex: (2020/03/11 YYYY/MM/DD) === ");
        String time = console.readLn();
        List<Flight> flightsByTime = new ArrayList<>(flightService.printSearchByTime(flightsByDestination, time.trim()));

        if(flightsByTime.size() != 0){
          console.printLn(" === Enter Number of Tickets! === ");
          int tickets = menu_operations.enter_number();
          List<Flight> flightsByTicket = new ArrayList<>(flightService.printSearchByTickets(flightsByTime, tickets));

          if (flightsByTicket.size() != 0){
            console.printLn("Start to book");
            //bookingController.book(tickets, flightsByTicket.get(0));
          }
          else {
            flightService.backToMainMenu();
          }
        }
        else {
          flightService.backToMainMenu();
        }
      }
      else {
        flightService.backToMainMenu();
      }
    }

}
