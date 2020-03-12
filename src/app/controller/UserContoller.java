package app.controller;

import app.console.Console;
import app.service.UserService;

public class UserContoller {
    UserService service;
    Console console;

    public UserContoller(Console console, UserService service) {
        this.service = service;
        this.console = console;
    }
}
