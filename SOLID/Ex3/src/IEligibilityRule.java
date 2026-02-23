public interface IEligibilityRule {
    RuleResult check(StudentProfile s);
}

class RuleResult {
    public final boolean isEligible;
    public final String reason;

    public RuleResult(boolean isEligible, String reason) {
        this.isEligible = isEligible;
        this.reason = reason;
    }

    public static RuleResult success() {
        return new RuleResult(true, null);
    }

    public static RuleResult failure(String reason) {
        return new RuleResult(false, reason);
    }
}
