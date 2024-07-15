package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.infraestructure.kafka.events;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Event {
  private UUID eventId;
}
