import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        CafeteriaSystem sys = new CafeteriaSystem();
        sys.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        sys.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        sys.addToMenu(new MenuItem("S1", "Sandwich", 60.00));

        List<OrderLine> order = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1));

        ITaxPolicy taxPolicy = new StudentTaxPolicy();
        IDiscountPolicy discountPolicy = new StudentDiscountPolicy();
        IInvoiceStore store = new MemoryInvoiceStore();
        IInvoiceFormatter formatter = new StandardFormatter();

        sys.checkout(taxPolicy, discountPolicy, store, formatter, order);
    }
}
