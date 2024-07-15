package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Invoice {
  private UUID invoiceId;
  private UUID SaleId;
  private List<InvoiceProduct> products;
  private String shopperName;
  private String shopperEmail;
  private double totalAmountWithoutTaxesOrDiscount;
  private double tax;
  private double discountedAmount;
  private double totalAmount;
  private LocalDateTime billingDate;

  public Invoice() {
    this.billingDate = LocalDateTime.now();
  }
}
