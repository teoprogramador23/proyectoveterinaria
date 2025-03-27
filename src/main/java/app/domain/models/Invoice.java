package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Invoice {
    private long invoiceId;
    private Person person;
    private double amount;
    private Date dateCreated;
    private boolean status;

    public Invoice(long invoiceId, Person person, double amount, Date dateCreated, boolean status) {
        this.invoiceId = invoiceId;
        this.person = person;
        this.amount = amount;
        this.dateCreated = dateCreated;
        this.status = status;
    }
}
