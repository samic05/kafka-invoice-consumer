package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.infraestructure.kafka.events;

import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.SaleProduct;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleEventProduct {
  private UUID productId;
  private String productName;
  private int quantity;
  private double unitaryPrice;

  public static SaleEventProduct fromDomainModel(SaleProduct saleProduct) {
    return new SaleEventProduct(
        saleProduct.getProductId(),
        saleProduct.getProductName(),
        saleProduct.getQuantity(),
        saleProduct.getUnitaryPrice());
  }

  public SaleProduct toDomainModel() {
    return new SaleProduct(productId, productName, quantity, unitaryPrice);
  }
}
