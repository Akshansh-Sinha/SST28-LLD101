public interface ITaxPolicy {
    double calculateTax(double subtotal);

    double getTaxRate();
}
