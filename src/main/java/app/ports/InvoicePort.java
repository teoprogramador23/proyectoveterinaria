package app.ports;

import app.domain.models.Invoice;
import java.util.List;

public interface InvoicePort {
    void saveInvoice(Invoice invoice);
    List<Invoice> getAllInvoices();
    Invoice findById(long invoiceId);
}
