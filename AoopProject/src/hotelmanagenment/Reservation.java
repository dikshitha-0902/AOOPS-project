package hotelmanagenment;
public class Reservation {
    private String guestName;
    private Room room;
    private boolean paid;

    public Reservation(String guestName, Room room) {
        this.guestName = guestName;
        this.room = room;
        this.paid = false;
    }

    public String getGuestName() {
        return guestName;
    }

    public Room getRoom() {
        return room;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
