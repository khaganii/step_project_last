package app.controller;

import app.console.ConsoleMain;
import app.entities.Flight;
import app.library.EnterNumber;
import app.service.BookingService;
import app.service.FlightService;

import java.util.ArrayList;
import java.util.List;

public class FlightController {
  ConsoleMain console = new ConsoleMain();
  FlightService flightService = new FlightService();
  EnterNumber enterNumber = new EnterNumber();
  BookingService bookingService = new BookingService();

  public void showBoard(){
    flightService.printToBoardAll();
  }

  public void showFlight(){
    System.out.println("\n      === Please, Enter flight ID ! ===");
    int id = enterNumber.enter_number();
    console.printLn("");
    flightService.printTOBoardOne(id);
  }

  public boolean searching(){
    console.printLn("\n === Enter Destination Where you wanna go! or Enter '0' (zero) to back 'MAIN MENU' ! === ");
    String destination = console.readLn().trim();
    if(backToMainMenu(destination)){
      return true;
    }
    console.printLn("                 ===== Results for your destination =====               ");
    console.printLn("");
    List<Flight> flightsByDestination = new ArrayList<>(flightService.printSearchByDestination(destination.trim()));

    if(flightsByDestination.size() != 0){
      console.printLn("\n === Enter Date When you wanna go! Ex: (2020/03/11 YYYY/MM/DD) or Enter '0' (zero) to back 'MAIN MENU' ! === ");
      String time = console.readLn().trim();
      if(backToMainMenu(time)) {
        return true;
      }
      console.printLn("                 ===== Results for your destination and date =====               ");
      console.printLn("");
      List<Flight> flightsByTime = new ArrayList<>(flightService.printSearchByTime(flightsByDestination, time.trim()));

      if(flightsByTime.size() != 0){
        console.printLn("\n === Enter Number of Tickets! ===  or Enter '0' (zero) to back 'MAIN MENU' !");
        int tickets = enterNumber.enter_number();
        if(backToMainMenu(String.valueOf(tickets))) {
          return true;
        }
        console.printLn("                 ===== Results for your destination , time and ticket number =====               ");
        console.printLn("");
        List<Flight> flightsByTicket = new ArrayList<>(flightService.printSearchByTickets(flightsByTime, tickets));
        int flightId;
        Flight filteredFlight = null;
        if (flightsByTicket.size() != 0){
          if(flightsByTicket.size()>1){
            console.printLn("Please Select Flight ID: ");
            flightId = enterNumber.enter_number();
            for (Flight f:flightsByTicket) {
              if(f.getId() == flightId)
              filteredFlight = f;
            }
          }
          else {
            filteredFlight = flightsByTicket.get(0);
          }
          console.printLn("\n             =====  Start to book  =====");
          bookingService.book(tickets, filteredFlight);
        }
        else console.printLn("                 ---  )-: Flights Not Found :-(  ---               \n");
      }
      else console.printLn("                 ---  )-: Flights Not Found :-(  ---               \n");
    }
    else console.printLn("                 ---  )-: Flights Not Found :-(  ---               \n");

    return false;
  }

  public boolean backToMainMenu(String a){
    return a.equals("0");
  }

}
