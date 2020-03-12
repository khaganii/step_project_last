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
    public int getBookingIdId() { return bookingId; }
    public Person getPerson() { return person; }
    public Flight getFlight() { return flight; }

    @Override
    public String toString() {
        return String.format("BOOKING ID: %d , PERSON{ %s } , FLIGHT{ %s }", bookingId, person.toString(), flight.toString());
    }
}
