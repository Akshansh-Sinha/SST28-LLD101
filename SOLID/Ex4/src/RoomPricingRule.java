import java.util.Map;

public class RoomPricingRule implements IPricingRule {
    private final Map<Integer, Double> prices;

    public RoomPricingRule(Map<Integer, Double> prices) {
        this.prices = prices;
    }

    @Override
    public Money calculate(BookingRequest req) {
        double price = prices.getOrDefault(req.roomType, 16000.0);
        return new Money(price);
    }
}
