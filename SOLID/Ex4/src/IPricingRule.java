public interface IPricingRule {
    Money calculate(BookingRequest req);
}
