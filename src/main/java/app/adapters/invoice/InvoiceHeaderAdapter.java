package app.adapters.invoice;

import app.adapters.invoice.entity.InvoiceHeaderEntity;
import app.adapters.invoice.repository.InvoiceHeaderRepository;
import app.domain.models.InvoiceHeader;
import app.ports.InvoiceHeaderPort;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceHeaderAdapter implements InvoiceHeaderPort {
   private final InvoiceHeaderRepository invoiceHeaderRepository;

   public InvoiceHeaderAdapter(InvoiceHeaderRepository invoiceHeaderRepository) {
      this.invoiceHeaderRepository = invoiceHeaderRepository;
   }

   @Override
   public List<InvoiceHeader> getAllInvoices() {
      return invoiceHeaderRepository.findAll().stream()
         .map(this::adaptInvoiceHeader)
         .collect(Collectors.toList());
   }

   @Override
   public double getTotalEarnings(Veterinarian veterinarian) {
      return invoiceHeaderRepository.findAll().stream()
         .filter(invoice -> invoice.getVeterinarian().equals(veterinarian))
         .mapToDouble(InvoiceHeaderEntity::getAmount)
         .sum();
   }

   private InvoiceHeader adaptInvoiceHeader(InvoiceHeaderEntity entity) {
      InvoiceHeader invoiceHeader = new InvoiceHeader();
      invoiceHeader.setInvoiceHeaderId(entity.getInvoiceHeaderId());
      invoiceHeader.setDateCreated(entity.getDateCreated());
      invoiceHeader.setAmount(entity.getAmount());
      invoiceHeader.setStatus(entity.isStatus());
      return invoiceHeader;
   }
}
