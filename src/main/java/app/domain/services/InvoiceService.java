package app.domain.services;

import app.domain.models.Invoice;
import app.domain.models.Person;
import app.ports.InvoicePort;

import java.util.List;

public class InvoiceService {
    private final InvoicePort invoicePort;

    public InvoiceService(InvoicePort invoicePort) {
        this.invoicePort = invoicePort;
    }

    public List<Invoice> getInvoicesByPerson(Person person) throws Exception {
        if (person == null) {
            throw new Exception("Person cannot be null.");
        }
        return invoicePort.getInvoicesByPerson(person);
    }
}
