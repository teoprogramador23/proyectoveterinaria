package app.adapters.invoice;

import app.domain.models.Invoice;
import app.ports.InvoicePort;
import java.util.List;

public class InvoiceAdapter implements InvoicePort {
    private InvoiceRepository invoiceRepository;

    @Override
    public void saveInvoice(Invoice invoice) {
        InvoiceEntity invoiceEntity = new InvoiceEntity(invoice);
        invoiceRepository.save(invoiceEntity);
        invoice.setInvoiceId(invoiceEntity.getInvoiceId());
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll().stream()
                .map(InvoiceEntity::toModel)
                .toList();
    }
}

