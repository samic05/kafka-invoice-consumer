package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.ports.internal;

import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.Invoice;
import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.Sale;

public interface GenerateInvoiceUseCase {
  public Invoice generateInvoice(Sale sale);
}
