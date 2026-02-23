public class FakeBookingRepo implements IBookingRepo {
    @Override
    public void save(String bookingId, BookingRequest req, Money monthly, Money deposit) {
        System.out.println("Saved booking: " + bookingId);
    }
}
