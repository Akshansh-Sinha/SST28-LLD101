public class DepositRule implements IPricingRule {
    private final double amount;

    public DepositRule(double amount) {
        this.amount = amount;
    }

    @Override
    public Money calculate(BookingRequest req) {
        return new Money(amount);
    }
}
