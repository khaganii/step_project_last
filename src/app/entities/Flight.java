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

    public void setDate(String date) {
      this.time = date;
    }
    public void setFreeSeats(int freeSeats) {
      this.freeSeats = freeSeats;
    }

  @Override
    public String toString() {
        return String.format("ID: %d | %s to %s | %s | maxSeats: %d", id, from, to, time, allSeats);
    }


}
