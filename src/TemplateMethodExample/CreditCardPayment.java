package TemplateMethodExample;

public class CreditCardPayment extends TemplatePayment {
  @Override
  protected void applyDiscount() {
    System.out.println("Applying 10% discount for credit card payment.");
  }
}
