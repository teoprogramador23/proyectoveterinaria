package app.adapters.invoice;

import app.adapters.invoice.entity.InvoiceEntity;
import app.adapters.invoice.repository.InvoiceRepository;
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
    public List<Invoice> getInvoicesByPerson(Person person) {
        return invoiceRepository.findByPersonId(person.getPersonId())
                .stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    private Invoice convertToModel(InvoiceEntity entity) {
        return new Invoice(entity.getInvoiceId(), entity.getPerson(), entity.getAmount(),
                entity.getDateCreated(), entity.isStatus());
    }
}
