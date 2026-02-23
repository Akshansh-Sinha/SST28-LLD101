public interface IReceiptPrinter {
    void print(BookingRequest req, Money monthly, Money deposit);
}
