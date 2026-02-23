public class CGRPercentageRule implements IEligibilityRule {
    @Override
    public RuleResult check(StudentProfile s) {
        if (s.cgr < 8.0) {
            return RuleResult.failure("CGR below 8.0");
        }
        return RuleResult.success();
    }
}
