package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.infraestructure.pulsar.producer;

import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.Invoice;
import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.ports.external.SendInvoicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InvoicePulsarProducer implements SendInvoicePort {

  public final PulsarTemplate<Invoice> pulsarTemplate;

  @Override
  public void sendInvoice(Invoice invoice) {
    pulsarTemplate.send("restaurant_invoice", invoice);
  }
}
