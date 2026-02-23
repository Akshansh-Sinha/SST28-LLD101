public class AttendanceRule implements IEligibilityRule {
    @Override
    public RuleResult check(StudentProfile s) {
        if (s.attendancePct < 75) {
            return RuleResult.failure("attendance below 75");
        }
        return RuleResult.success();
    }
}
