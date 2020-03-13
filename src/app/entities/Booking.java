package app.entities;

public class Booking {
    int bookingId;
    Person person;
    Flight flight;

    public Booking(int bookingId, Person person, Flight flight) {
      this.bookingId = bookingId;
      this.person = person;
      this.flight = flight;
    }
    public int getBookingId() { return bookingId; }
    public Person getPerson() { return person; }
    public Flight getFlight() { return flight; }

  public void setFlight(Flight flight) {
    this.flight = flight;
  }

  @Override
    public String toString() {
        return String.format("BOOKING ID: %d , PERSON{ %s } , FLIGHT{%s }", bookingId, person.toString(), flight.toString());
    }
}
