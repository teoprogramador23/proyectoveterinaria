package app.adapters.invoice.entity;

import app.domain.models.Invoice;
import app.domain.models.Person;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@NoArgsConstructor
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceId;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "status")
    private boolean status;

    public InvoiceEntity(Invoice invoice) {
        this.invoiceId = invoice.getInvoiceId();
        this.person = invoice.getPerson();
        this.amount = invoice.getAmount();
        this.dateCreated = invoice.getDateCreated();
        this.status = invoice.isStatus();
    }
}
