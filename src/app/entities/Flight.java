package app.entities;

public class Flight {
    int id;
    String from;
    String to;
    String time;
    int allSeats;
    int freeSeats;

    public Flight(int id, String from, String to, String time, int freeSeats, int allSeats) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.time = time;
        this.allSeats = allSeats;
        this.freeSeats = freeSeats;
    }

    public int getId() { return id; }
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getTime() { return time; }
    public int getAllSeats() { return allSeats; }
    public int getFreeSeats() { return freeSeats; }

    @Override
    public String toString() {
        return String.format("ID: %s | %s to %s | %s | max seats: %d", id, from, to, time, allSeats);
    }
}
