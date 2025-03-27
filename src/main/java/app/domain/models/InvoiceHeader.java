package app.domain.models;

import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InvoiceHeader {
   private long invoiceHeaderId;
   private Person person;
   private Veterinarian veterinarian;
   private Date dateCreated;
   private double amount;
   private boolean status;

   public InvoiceHeader(long invoiceHeaderId, Person person, Veterinarian veterinarian, Date dateCreated, double amount, boolean status) {
      this.invoiceHeaderId = invoiceHeaderId;
      this.person = person;
      this.veterinarian = veterinarian;
      this.dateCreated = dateCreated;
      this.amount = amount;
      this.status = status;
   }
}
