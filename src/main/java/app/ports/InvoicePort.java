package app.ports;

import app.domain.models.Invoice;
import app.domain.models.Person;

import java.util.List;

public interface InvoicePort {
    void saveInvoice(Invoice invoice);
    List<Invoice> getInvoicesByPerson(Person person);
    List<Invoice> getAllInvoices();
}
