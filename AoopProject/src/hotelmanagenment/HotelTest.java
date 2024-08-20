package hotelmanagenment;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HotelTest {
    private Hotel hotel;

    @Before
    public void setUp() {
        hotel = new Hotel(5);  // Hotel with 5 rooms
    }

    @Test
    public void testRoomAvailability() {
        assertTrue(hotel.isRoomAvailable(1));
        assertTrue(hotel.isRoomAvailable(5));
    }

    @Test
    public void testMakeReservation() {
        Reservation reservation = hotel.makeReservation("John Doe", 1);
        assertNotNull(reservation);
        assertEquals("John Doe", reservation.getGuestName());
        assertFalse(hotel.isRoomAvailable(1));
    }

    @Test(expected = IllegalStateException.class)
    public void testMakeReservationRoomNotAvailable() {
        hotel.makeReservation("John Doe", 1);
        hotel.makeReservation("Jane Smith", 1);  // This should throw an exception
    }

    @Test
    public void testProcessPayment() {
        Reservation reservation = hotel.makeReservation("John Doe", 1);
        hotel.processPayment(reservation, 100.0);
        assertTrue(reservation.isPaid());
    }

    @Test
    public void testGetReservations() {
        hotel.makeReservation("John Doe", 1);
        hotel.makeReservation("Jane Smith", 2);
        assertEquals(2, hotel.getReservations().size());
    }

    @Test
    public void testRoomDetails() {
        Room room = hotel.getRoom(1);
        assertEquals(1, room.getRoomNumber());
        assertTrue(room.isAvailable());
    }
}

