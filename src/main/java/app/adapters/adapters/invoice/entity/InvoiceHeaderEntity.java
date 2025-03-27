package app.adapters.invoice.entity;

import app.domain.models.InvoiceHeader;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "invoice_header")
@Setter
@Getter
@NoArgsConstructor
public class InvoiceHeaderEntity {
   public InvoiceHeaderEntity(InvoiceHeader invoiceHeader) {
      this.invoiceHeaderId = invoiceHeader.getInvoiceHeaderId();
      this.dateCreated = invoiceHeader.getDateCreated();
      this.amount = invoiceHeader.getAmount();
      this.status = invoiceHeader.isStatus();
   }

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private long invoiceHeaderId;
   
   @Column(name = "date_created")
   private Date dateCreated;
   
   @Column(name = "amount")
   private double amount;
   
   @Column(name = "status")
   private boolean status;
}
