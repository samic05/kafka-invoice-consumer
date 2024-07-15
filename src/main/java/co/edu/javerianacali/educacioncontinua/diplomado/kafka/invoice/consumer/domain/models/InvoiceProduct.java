package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvoiceProduct {
  private String productName;
  private int quantity;
  private double unitaryPrice;
  private double totalPrice;
}
