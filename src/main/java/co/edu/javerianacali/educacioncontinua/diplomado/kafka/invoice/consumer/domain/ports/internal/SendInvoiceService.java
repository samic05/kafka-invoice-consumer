package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.ports.internal;

import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.Sale;

public interface SendInvoiceService {
  public void generateInvoiceFromSaleAndSend(Sale sale);
}
