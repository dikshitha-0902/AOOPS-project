package hotelmanagenment;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel(int numberOfRooms) {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        for (int i = 1; i <= numberOfRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public boolean isRoomAvailable(int roomNumber) {
        return rooms.get(roomNumber - 1).isAvailable();
    }

    public Reservation makeReservation(String guestName, int roomNumber) {
        if (isRoomAvailable(roomNumber)) {
            Room room = rooms.get(roomNumber - 1);
            room.setAvailable(false);
            Reservation reservation = new Reservation(guestName, room);
            reservations.add(reservation);
            return reservation;
        } else {
            throw new IllegalStateException("Room is not available");
        }
    }

    public void processPayment(Reservation reservation, double amount) {
        reservation.setPaid(true);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public Room getRoom(int roomNumber) {
        return rooms.get(roomNumber - 1);
    }
}
