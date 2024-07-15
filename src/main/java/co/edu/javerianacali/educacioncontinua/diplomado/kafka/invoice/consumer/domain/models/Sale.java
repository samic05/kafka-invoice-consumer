package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sale {
  private UUID id;
  private List<SaleProduct> products;
  private String shopperName;
  private String shopperEmail;
  private double discount;
}
