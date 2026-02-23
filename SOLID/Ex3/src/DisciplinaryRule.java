public class DisciplinaryRule implements IEligibilityRule {
    @Override
    public RuleResult check(StudentProfile s) {
        if (s.disciplinaryFlag != LegacyFlags.NONE) {
            return RuleResult.failure("disciplinary flag present");
        }
        return RuleResult.success();
    }
}
