package app.service;

import app.console.ConsoleMain;
import app.controller.FlightController;
import app.dao.FlightDAO;
import app.entities.Flight;
import app.library.Main_Menu;
import app.library.Menu_operations;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FlightService {
  ConsoleMain console = new ConsoleMain();
  FlightDAO flightDAO = new FlightDAO();
  Main_Menu main_menu = new Main_Menu();
  Menu_operations menu_operations = new Menu_operations();

  public void printToBoardAll(){
    List<Flight> flights = new ArrayList<>(flightDAO.getAll());
    console.printLn("------------------------------------------------------------------------------------");
    console.print("| ");
    console.print("asdfghrjfghfdvdfvdssd feffd");
    console.print(" |\n");
    console.print("------------------------------------------------------------------------------------\n");
    for (Flight f:flights) {
      if(after24hours(f.getTime())){
        console.printLn(represent(f));
      }
    }
  }

  public void printTOBoardOne(int id){
    console.printLn(represent(flightDAO.get(id)));
  }
  public String represent(Flight flight){
    return "    - Flight ID: " + flight.getId() + " | From " + flight.getFrom() + " To " + flight.getTo() + " | Date: " + flight.getTime() + " | Free seats: " + flight.getFreeSeats() + " | Max seats: " + flight.getAllSeats();
  }
  public boolean after24hours(String a){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    LocalDateTime d1;
    LocalDateTime dateTime = LocalDateTime.parse(a, formatter); //convert to data_time
    LocalDateTime now = LocalDateTime.now(); //present time
    d1 = now.plusDays(1); //after 24 h
    return d1.isBefore(dateTime); //data_time is before d1
  }



  public void writeToFile(String s){
    File file = new File("src/main/java/app/files/Flights.txt");
    try {
      BufferedWriter bw = new BufferedWriter(new FileWriter(file));
      bw.write(s);
      bw.close();
    }   catch (IOException ex){
      console.print("IO EXCEPTION FOUND!");
    }
  }

  public List<Flight> printSearchByDestination(String dest)
  {
    List<Flight> flightsByDestination = new ArrayList<>();
    List<Flight> flights = new ArrayList<>(flightDAO.getAll());
    for (Flight f: flights) {
      if (f.getTo().toLowerCase().equals(dest))
      {
        console.printLn(represent(f));
        flightsByDestination.add(f);
      }
    }
    return flightsByDestination;
  }

  public List<Flight> printSearchByTime(List<Flight> flights, String time)
  {
    List<Flight> flightsByTime = new ArrayList<>();
    for (Flight f: flights) {
      String flightTime = f.getTime();
      if (time.equals(flightTime))
      {
        console.printLn(represent(f));
        flightsByTime.add(f);
      }
    }
    return flightsByTime;
  }

  public List<Flight> printSearchByTickets(List<Flight> flights, int tickets){
    List<Flight> flightsByTickets = new ArrayList<>();
    for (Flight f: flights) {
      int flightTickets = f.getFreeSeats();
      if (flightTickets >= tickets)
      {
        console.printLn(represent(f));
        flightsByTickets.add(f);
      }
    }
    return flightsByTickets;
  }

//  public void backToMainMenu(){
//    console.printLn("                 ===== Results Not Found =====               ");
//    searching();
//    console.printLn("Enter '0' (zero) to back 'MAIN MENU' !");
//    console.printLn("Enter something! >>");
//    if (console.readLn().equals("0")) main_menu.showMenu();
//    else searching();
//  }
//
//  public void searching(){
//    console.printLn(" === Enter Destination Where you wanna go! === ");
//    String destination = console.readLn();
//    console.printLn("                 ===== Results for your destination =====               ");
//    console.printLn("");
//    List<Flight> flightsByDestination = new ArrayList<>(printSearchByDestination(destination.trim()));
//
//    if(flightsByDestination.size() != 0){
//      console.printLn(" === Enter Date When you wanna go! Ex: (2020/03/11 YYYY/MM/DD) === ");
//      String time = console.readLn();
//      List<Flight> flightsByTime = new ArrayList<>(printSearchByTime(flightsByDestination, time.trim()));
//
//      if(flightsByTime.size() != 0){
//        console.printLn(" === Enter Number of Tickets! === ");
//        int tickets = menu_operations.enter_number();
//        List<Flight> flightsByTicket = new ArrayList<>(printSearchByTickets(flightsByTime, tickets));
//
//        if (flightsByTicket.size() != 0){
//          console.printLn("Start to book");
//          //bookingController.book(tickets, flightsByTicket.get(0));
//        }
//        else {
//          backToMainMenu();
//        }
//      }
//      else {
//        backToMainMenu();
//      }
//    }
//    else {
//      backToMainMenu();
//    }
//  }

}
