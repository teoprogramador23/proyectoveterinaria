package app.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Invoice {
    private long invoiceId;
    private double totalAmount;
}
