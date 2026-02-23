import java.util.Map;

public class AddOnPricingRule implements IPricingRule {
    private final Map<AddOn, Double> prices;

    public AddOnPricingRule(Map<AddOn, Double> prices) {
        this.prices = prices;
    }

    @Override
    public Money calculate(BookingRequest req) {
        double total = 0.0;
        for (AddOn a : req.addOns) {
            total += prices.getOrDefault(a, 0.0);
        }
        return new Money(total);
    }
}
