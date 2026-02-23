public class CreditsRule implements IEligibilityRule {
    @Override
    public RuleResult check(StudentProfile s) {
        if (s.earnedCredits < 20) {
            return RuleResult.failure("credits below 20");
        }
        return RuleResult.success();
    }
}
