package app.controller;

import app.console.ConsoleMain;
import app.library.Main_Menu;
import app.service.FlightService;

public class FlightController {
  ConsoleMain console = new ConsoleMain();
  FlightService flightService = new FlightService();
  Main_Menu main_menu = new Main_Menu();

  public void showBoard(){
    flightService.printToBoardAll();
  }

  public void showFlight(){
    System.out.println("\n      === Please, Enter flight ID ! ===");
    int id = main_menu.enter_number();
    console.printLn("");
    flightService.printTOBoardOne(id);
  }

  public void searchAndBook() {
    //flightService.searching();
    }
}
