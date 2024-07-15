package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.infraestructure.kafka.consumer;

import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.ports.internal.SendInvoiceService;
import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.infraestructure.kafka.events.SaleEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaSaleEventConsumer {
  public final SendInvoiceService restaurantInvoiceGenerationService;

  @KafkaListener(
      topics = "event-driven-architecture",
      groupId = "restaurant_invoice",
      containerFactory = "listenerContainerFactory")
  public void consume(SaleEvent event) {
    restaurantInvoiceGenerationService.generateInvoiceFromSaleAndSend(event.toDomainModel());
  }
}
