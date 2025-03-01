package TemplateMethodExample;

public class BankSlitPayment extends TemplatePayment {
  @Override
  protected void applyDiscount() {
    System.out.println("Applying 5% discount for bank slip payment.");
  }
}
