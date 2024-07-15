package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.ports.external;

import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.Invoice;

public interface SendInvoicePort {
  public void sendInvoice(Invoice invoice);
}
