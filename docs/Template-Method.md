O template method, é relativamente simples de entender, como está no próprio nome, ele define um template padrão a se seguir por outros algoritmos, e deixa os mesmos, sobrescreverem etapas especificas do seu processo.

## Problema

Vamos supor que um sistema de pagamentos aplique diversos descontos para determinados tipos de clientes, ou então para determinadas formas de pagamento, a maneira mais convencional de se resolver isso, é usando `if...else` para cada forma de pagamento, fazendo o programa tomar rumos diferentes, este método já evita a duplicação de código, mas ainda é extremamente complicado de se manter o código devido a grande quantidade de `if...else` mesmo usando estratégias de `return  early` ou algo parecido.

## Solução

É neste momento que o `template method` entra em ação, encapsulando todos
as diferentes lógicas de um algoritmo em métodos diferentes, e deixando subclasses alterarem somente o necessário. No exemplo dado, teríamos um classe abstrata com métodos para validar o pagamento, realizar o pagamento que seriam fixas independentemente do método de pagamento ou tipo do cliente, e métodos abstratos para lidar com os diferentes tipos de clientes e métodos de pagamento, além de um método que chamará todos os outros (o literal template method), assim executando suas lógicas encapsuladas.

# Código

Neste exemplo foi usado somente duas formas de pagamento para deixar o código menor, mas caso tivesse mais, era só seguir o mesmo padrão

- Classe Abstrata que serve de template para outras classes:

```java
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
```

- Classes que implementam o método abstrato da classe Template:

```java
package TemplateMethodExample;

public class CreditCardPayment extends TemplatePayment {
	@Override
	protected void applyDiscount() {
		System.out.println("Applying 10% discount for credit card payment.");
	}
}
```

```java
package TemplateMethodExample;

public class BankSlitPayment extends TemplatePayment {
	@Override
	protected void applyDiscount() {
		System.out.println("Applying 5% discount for bank slip payment.");
	}
}
```

- Main Class:

```java
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
```

Desta forma, o esqueleto, ou template da minha lógica de pagamentos será executado de forma idêntica independentemente da forma de pagamento que eu escolher, e caso eu queira adicionar novas formas de pagamento, fica muito simples de implementar no sistema, bastando eu criar uma nova classe.