package app.adapters.invoice;

import app.domain.models.Invoice;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@NoArgsConstructor
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoiceId;
    
    private double amount;
    private boolean status;

    public InvoiceEntity(Invoice invoice) {
        this.invoiceId = invoice.getInvoiceId();
        this.amount = invoice.getAmount();
        this.status = invoice.isStatus();
    }

    public Invoice toModel() {
        return new Invoice(invoiceId, amount, status);
    }
}

