package app.library;

import app.console.ConsoleMain;
import app.controller.FlightController;

public class Menu_operations {
  ConsoleMain console = new ConsoleMain();
  FlightController flightController = new FlightController();

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

