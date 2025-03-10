package ObserverExample;

import java.util.ArrayList;
import java.util.List;

// Publisher Interface (Sujeito)
interface Publisher {
  void subscribe(Subscriber subscriber);
  void unsubscribe(Subscriber subscriber);
  void notifySubscribers();
}

// ConcretePublisher (Sujeito - Loja de Celulares)
class CellPhoneStore implements Publisher {
  private List<Subscriber> subscribers = new ArrayList<>();
  private String newProduct;  // A loja vai notificar sobre um novo produto ou promoção

  @Override
  public void subscribe(Subscriber subscriber) {
    subscribers.add(subscriber);
  }

  @Override
  public void unsubscribe(Subscriber subscriber) {
    subscribers.remove(subscriber);
  }

  @Override
  public void notifySubscribers() {
    for (Subscriber subscriber : subscribers) {
      subscriber.update(newProduct);
    }
  }

  // Método para a loja anunciar um novo produto ou promoção
  public void setNewProduct(String product) {
    this.newProduct = product;
    notifySubscribers();  // Notificar todos os clientes inscritos
  }
}

// Subscriber Interface (Observador - Cliente)
interface Subscriber {
  void update(String product);  // Método chamado quando há novidades na loja
}

// ConcreteSubscriber (Observador Concreto - Cliente)
class Customer implements Subscriber {
  private String name;

  public Customer(String name) {
    this.name = name;
  }

  @Override
  public void update(String product) {
    System.out.println(name + " recebeu uma notificação sobre: " + product);
  }
}

// Client (Classe Principal)
public class Main {
  public static void main(String[] args) {
    // Criando a loja de celulares (Publisher)
    CellPhoneStore store = new CellPhoneStore();

    // Criando os clientes (Subscribers)
    Customer customer1 = new Customer("João");
    Customer customer2 = new Customer("Maria");

    // Inscrevendo os clientes na loja
    store.subscribe(customer1);
    store.subscribe(customer2);

    // A loja anuncia um novo produto
    store.setNewProduct("iPhone 15 - Lançamento!");

    // Removendo um cliente e anunciando outro produto
    store.unsubscribe(customer1);
    store.setNewProduct("Samsung Galaxy S25 - Promoção!");
  }
}
