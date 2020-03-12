package app.library;

import app.console.ConsoleMain;

public class Main_Menu {
  Menu_operations menu_operations = new Menu_operations();
  ConsoleMain console = new ConsoleMain();
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
    menu_operations.switchOperation();
    }
  }
