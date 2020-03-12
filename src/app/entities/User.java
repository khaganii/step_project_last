package app.entities;

public class User {
    String username;
    String password;
    Flight flight;

    public User(String username, String password, Flight flight) {
        this.username = username;
        this.password = password;
        this.flight = flight;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public Flight getFlight() { return flight; }

    @Override
    public String toString() {
        return String.format("User{username='%s', password='%s', flight=%s}", username, password, flight);
    }
}
