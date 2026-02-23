public abstract class Exporter {
    /**
     * Exports the given request.
     * 
     * @param req The request to export. Must not be null.
     * @return A valid ExportResult.
     * @throws IllegalArgumentException if req is null or if content violates
     *                                  format-specific limits.
     */
    public abstract ExportResult export(ExportRequest req);
}
