public class StandardFormatter implements IInvoiceFormatter {
    @Override
    public String format(String rawContent) {
        return rawContent;
    }
}
