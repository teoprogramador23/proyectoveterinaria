package app.domain.services;

import app.domain.models.Invoice;
import app.ports.InvoicePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private final InvoicePort invoicePort;

    public InvoiceService(InvoicePort invoicePort) {
        this.invoicePort = invoicePort;
    }

    public void createInvoice(Invoice invoice) {
        invoicePort.saveInvoice(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoicePort.getAllInvoices();
    }

    public Invoice getInvoiceById(long invoiceId) {
        return invoicePort.findById(invoiceId);
    }
}
