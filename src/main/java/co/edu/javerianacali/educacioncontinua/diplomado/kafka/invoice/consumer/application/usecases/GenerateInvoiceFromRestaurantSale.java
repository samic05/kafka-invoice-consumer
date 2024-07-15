package co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.application.usecases;

import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.Invoice;
import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.InvoiceProduct;
import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.Sale;
import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.models.SaleProduct;
import co.edu.javerianacali.educacioncontinua.diplomado.kafka.invoice.consumer.domain.ports.internal.GenerateInvoiceUseCase;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class GenerateInvoiceFromRestaurantSale implements GenerateInvoiceUseCase {

  public static final double DEFAULT_TAX = 4.20;

  @Override
  public Invoice generateInvoice(Sale sale) {
    var invoice = new Invoice();
    var invoiceProducts =
        sale.getProducts().stream().map(this::saleProductToInvoiceProduct).toList();
    double totalAmountWithoutTaxesOrDiscounts =
        invoiceProducts.stream()
            .map(InvoiceProduct::getTotalPrice)
            .reduce(Double::sum)
            .orElseThrow();
    var discountAmount = sale.getDiscount() * totalAmountWithoutTaxesOrDiscounts;
    invoice.setInvoiceId(UUID.randomUUID());
    invoice.setSaleId(sale.getId());
    invoice.setProducts(invoiceProducts);
    invoice.setShopperEmail(sale.getShopperEmail());
    invoice.setShopperName(sale.getShopperName());
    invoice.setTotalAmountWithoutTaxesOrDiscount(totalAmountWithoutTaxesOrDiscounts);
    invoice.setDiscountedAmount(discountAmount);
    invoice.setTax(DEFAULT_TAX);
    invoice.setTotalAmount((DEFAULT_TAX + totalAmountWithoutTaxesOrDiscounts) - discountAmount);
    return invoice;
  }

  private InvoiceProduct saleProductToInvoiceProduct(SaleProduct saleProduct) {
    return new InvoiceProduct(
        saleProduct.getProductName(),
        saleProduct.getQuantity(),
        saleProduct.getUnitaryPrice(),
        saleProduct.getQuantity() * saleProduct.getUnitaryPrice());
  }
}
