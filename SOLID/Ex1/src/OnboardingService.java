import java.util.*;

public class OnboardingService {
    private final FakeDb db;

    public OnboardingService(FakeDb db) {
        this.db = db;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        String[] arr = parseString.parse(raw);
        String name = arr[0];
        String email = arr[1];
        String phone = arr[2];
        String program = arr[3];

        validateString.validate(name, email, phone, program);

        String id = IdUtil.nextStudentId(db.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        db.save(rec);

        printText.print(id, db, rec);
    }
}
