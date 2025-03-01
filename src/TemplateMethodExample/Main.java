package TemplateMethodExample;

public class Main {
  public static void main(String[] args) {
    TemplatePayment creditCardPayment = new CreditCardPayment();
    TemplatePayment bankSlipPayment = new BankSlitPayment();

    System.out.println("\nProcessing credit card payment:");
    creditCardPayment.processPayment();

    System.out.println("\nProcessing bank slip payment:");
    bankSlipPayment.processPayment();
  }
}
