public interface IDiscountPolicy {
    double calculateDiscount(double subtotal, int distinctLines);
}
