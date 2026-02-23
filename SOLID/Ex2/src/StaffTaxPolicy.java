public class StaffTaxPolicy implements ITaxPolicy {
    @Override
    public double calculateTax(double subtotal) {
        return subtotal * (getTaxRate() / 100.0);
    }

    @Override
    public double getTaxRate() {
        return 2.0;
    }
}
