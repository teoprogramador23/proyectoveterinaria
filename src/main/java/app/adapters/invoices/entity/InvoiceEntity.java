package app.adapters.invoices.entity;

import app.domain.models.Invoice;
import app.domain.models.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "invoice")
@Setter
@Getter
@NoArgsConstructor
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private long invoiceId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "amount")
    private double amount;

    @Column(name = "is_paid")
    private boolean isPaid;

    public InvoiceEntity(Invoice invoice) {
        this.invoiceId = invoice.getInvoiceId();
        this.person = invoice.getPerson();
        this.dateCreated = invoice.getDateCreated();
        this.amount = invoice.getAmount();
        this.isPaid = invoice.isPaid();
    }
}
