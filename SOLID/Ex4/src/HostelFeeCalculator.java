import java.util.*;

public class HostelFeeCalculator {
    private final IBookingRepo repo;
    private final IReceiptPrinter printer;
    private final List<IPricingRule> monthlyRules;
    private final IPricingRule depositRule;

    public HostelFeeCalculator(IBookingRepo repo, IReceiptPrinter printer, List<IPricingRule> monthlyRules,
            IPricingRule depositRule) {
        this.repo = repo;
        this.printer = printer;
        this.monthlyRules = monthlyRules;
        this.depositRule = depositRule;
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = depositRule.calculate(req);

        printer.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        double total = 0.0;
        for (IPricingRule rule : monthlyRules) {
            total += rule.calculate(req).amount;
        }
        return new Money(total);
    }
}
