package TemplateMethodExample;

abstract class TemplatePayment {
  public final void processPayment() {
    validatePayment();
    applyDiscount();
    processTransaction();
    sendConfirmation();
  }

  private void validatePayment() {
    System.out.println("Validating payment details...");
  }

  protected abstract void applyDiscount();

  private void processTransaction() {
    System.out.println("Processing transaction...");
  }

  private void sendConfirmation() {
    System.out.println("Sending payment confirmation...");
  }
}
