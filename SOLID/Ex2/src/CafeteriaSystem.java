import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(ITaxPolicy taxPolicy, IDiscountPolicy discountPolicy, IInvoiceStore store,
            IInvoiceFormatter formatter, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");

        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }

        double taxPct = taxPolicy.getTaxRate();
        double tax = taxPolicy.calculateTax(subtotal);
        double discount = discountPolicy.calculateDiscount(subtotal, lines.size());
        double total = subtotal + tax - discount;

        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f\n", total));

        String printable = formatter.format(out.toString());
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
