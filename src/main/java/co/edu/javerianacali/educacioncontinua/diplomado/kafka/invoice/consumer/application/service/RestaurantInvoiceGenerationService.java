package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.application.service;

import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.Sale;
import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.ports.external.SendInvoicePort;
import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.ports.internal.GenerateInvoiceUseCase;
import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.ports.internal.SendInvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RestaurantInvoiceGenerationService implements SendInvoiceService {

  public final GenerateInvoiceUseCase generateInvoiceUseCase;
  private final SendInvoicePort sendInvoicePort;

  @Override
  public void generateInvoiceFromSaleAndSend(Sale sale) {
    var invoice = generateInvoiceUseCase.generateInvoice(sale);
    sendInvoicePort.sendInvoice(invoice);
  }
}
