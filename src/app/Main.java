package app;

import app.console.ConsoleMain;
import app.controller.FlightController;
import app.dao.FlightDAO;
import app.entities.Flight;
import app.library.FillingFiles;
import app.library.Main_Menu;
import app.service.FlightService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
      FillingFiles fillingFiles = new FillingFiles();
      Main_Menu main_menu = new Main_Menu();

      fillingFiles.fillFlights();
      fillingFiles.fillBookings();
      main_menu.showMenu();
    }
}
