package app.library;

import app.console.ConsoleMain;
import app.controller.BookingController;
import app.controller.FlightController;

public class Start {
  public void run(){
    FillingFiles fillingFiles = new FillingFiles();
    EnterNumber enterNumber = new EnterNumber();
    ConsoleMain console = new ConsoleMain();
    BookingController bookingController = new BookingController();
    FlightController flightController = new FlightController();

    fillingFiles.fillFlights();
    fillingFiles.fillBookings();
    boolean continuing = true;

      while (continuing)
      {
        console.printLn("====================================================================================");
        console.printLn("|----------------=                     MAIN MENU                  =----------------|");
        console.printLn("====================================================================================");
        console.printLn("    # 1. Online-Board");
        console.printLn("    # 2. Show the flight info");
        console.printLn("    # 3. Search and book a flight");
        console.printLn("    # 4. Cancel the booking");
        console.printLn("    # 5. My flights");
        console.printLn("    # 6. Exit");

        switch (enterNumber.enter_number()) {
          case 1:
            flightController.showBoard();
            break;
          case 2:
            flightController.showFlight();
            break;
          case 3:
            flightController.searching();
            break;
          case 4:
            bookingController.cancelBooking();
            break;
          case 5:
            System.out.println("item5");
            break;
          case 6:
            System.out.println("\n\n##########  Thanks for choosing us!  ##########\n\n");
            continuing = false;
            break;
          default:
            console.printLn("\nPlease, Enter correct number!\n");
        }
    }
  }
}
