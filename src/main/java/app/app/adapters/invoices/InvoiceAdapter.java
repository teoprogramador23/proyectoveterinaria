package app.adapters.invoices;

import app.adapters.invoices.entity.InvoiceEntity;
import app.adapters.invoices.repository.InvoiceRepository;
import app.domain.models.Invoice;
import app.domain.models.Person;
import app.ports.InvoicePort;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceAdapter implements InvoicePort {
    private final InvoiceRepository invoiceRepository;

    public InvoiceAdapter(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void saveInvoice(Invoice invoice) {
        InvoiceEntity invoiceEntity = invoiceEntityAdapter(invoice);
        invoiceRepository.save(invoiceEntity);
        invoice.setInvoiceId(invoiceEntity.getInvoiceId());
    }

    @Override
    public List<Invoice> getInvoicesByPerson(Person person) {
        return invoiceRepository.findByPersonId(person.getPersonId()).stream()
                .map(this::invoiceAdapter)
                .collect(Collectors.toList());
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll().stream()
                .map(this::invoiceAdapter)
                .collect(Collectors.toList());
    }

    private Invoice invoiceAdapter(InvoiceEntity entity) {
        return new Invoice(
                entity.getInvoiceId(),
                entity.getPerson(),
                entity.getDateCreated(),
                entity.getAmount(),
                entity.isPaid()
        );
    }

    private InvoiceEntity invoiceEntityAdapter(Invoice invoice) {
        return new InvoiceEntity(invoice);
    }
}
