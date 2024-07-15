package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.infraestructure.kafka.events;

import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.Sale;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class SaleEvent extends Event {
  private UUID id;
  private List<SaleEventProduct> products;
  private String shopperName;
  private String shopperEmail;
  private double discount;

  public SaleEvent(
      UUID eventId,
      UUID id,
      List<SaleEventProduct> products,
      String shopperName,
      String shopperEmail,
      double discount) {
    super(eventId);
    this.id = id;
    this.products = products;
    this.shopperName = shopperName;
    this.shopperEmail = shopperEmail;
    this.discount = discount;
  }

  public static SaleEvent fromDomainModel(Sale sale) {
    return new SaleEvent(
        UUID.randomUUID(),
        sale.getId(),
        sale.getProducts().stream().map(SaleEventProduct::fromDomainModel).toList(),
        sale.getShopperName(),
        sale.getShopperEmail(),
        sale.getDiscount());
  }

  public Sale toDomainModel() {
    return new Sale(
        id,
        products.stream().map(SaleEventProduct::toDomainModel).toList(),
        shopperName,
        shopperEmail,
        discount);
  }
}
