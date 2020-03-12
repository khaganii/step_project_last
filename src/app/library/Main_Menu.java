package app.library;

import app.console.ConsoleMain;
import app.controller.FlightController;

public class Main_Menu {
  ConsoleMain console = new ConsoleMain();
  FlightController flightController = new FlightController();
  public void  showMenu(){
    console.printLn("====================================================================================");
    console.printLn("|----------------=                     MAIN MENU                  =----------------|");
    console.printLn("====================================================================================");
    console.printLn("    # 1. Online-Board");
    console.printLn("    # 2. Show the flight info");
    console.printLn("    # 3. Search and book a flight");
    console.printLn("    # 4. Cancel the booking");
    console.printLn("    # 5. My flights");
    console.printLn("    # 6. Registration");
    console.printLn("    # 7. Exit");
    switchOperation();
  }

  public int enter_number() {
    int number = 0;
    console.print("\nEnter a number: \n");
    boolean t = true;
    while (t) {
      try {
        String a = console.readLn();
        number = Integer.parseInt(a);
        t = false;
      } catch (Exception e) {
        console.printLn("Try again!");
      }
    }
    return number;
  }

  public void switchOperation() {
    Main_Menu main_menu = new Main_Menu();
    switch (enter_number()) {
      case 1:
        flightController.showBoard();
        main_menu.showMenu();
        break;
      case 2:
        flightController.showFlight();
        main_menu.showMenu();
        break;
      case 3:
        flightController.searchAndBook();
        main_menu.showMenu();
        break;
      case 4:
        System.out.println("item4");
        main_menu.showMenu();
        break;
      case 5:
        System.out.println("item5");
        main_menu.showMenu();
        break;
      case 6:
        System.out.println("Item6");
        main_menu.showMenu();
        break;
      case 7:
        System.out.println("\n\n##########  Thanks for choosing us!  ##########\n\n");
        break;
      default:
        System.out.println("\nPlease, Enter correct number!\n");
        switchOperation();
    }
  }
}
