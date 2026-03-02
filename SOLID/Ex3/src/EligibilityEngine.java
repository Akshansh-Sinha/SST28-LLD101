import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore store;
    private final List<IEligibilityRule> rules;

    public EligibilityEngine(FakeEligibilityStore store, List<IEligibilityRule> rules) {
        this.store = store;
        this.rules = rules;
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter p = new ReportPrinter();
        EligibilityEngineResult r = evaluate(s);
        p.print(s, r);
        store.save(s.rollNo, r.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> reasons = new ArrayList<>();
        String status = "ELIGIBLE";

        for (IEligibilityRule rule : rules) {
            RuleResult result = rule.check(s);
            if (!result.isEligible) {
                status = "NOT_ELIGIBLE";
                reasons.add(result.reason);
                // The original code used else if, meaning it stopped at the first failure.
                break;
            }
        }

        return new EligibilityEngineResult(status, reasons);
    }
}
