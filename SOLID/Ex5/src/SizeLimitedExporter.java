public class SizeLimitedExporter extends Exporter {
    private final Exporter delegate;
    private final int maxLength;

    public SizeLimitedExporter(Exporter delegate, int maxLength) {
        this.delegate = delegate;
        this.maxLength = maxLength;
    }

    @Override
    public ExportResult export(ExportRequest req) {
        if (req != null && req.body != null && req.body.length() > maxLength) {
            throw new IllegalArgumentException("PDF cannot handle content > 20 chars"); // Keeping specific message for
                                                                                        // Main compatibility
        }
        return delegate.export(req);
    }
}
