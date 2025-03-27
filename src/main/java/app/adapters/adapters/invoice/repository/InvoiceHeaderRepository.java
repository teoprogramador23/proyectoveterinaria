package app.adapters.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.adapters.invoice.entity.InvoiceHeaderEntity;

public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeaderEntity, Long> {
}
