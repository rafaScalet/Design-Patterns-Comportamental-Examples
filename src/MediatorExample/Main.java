package MediatorExample;


import java.util.ArrayList;
import java.util.List;

// Interface Mediator
interface ChatMediator {
  void sendMessage(String message, User sender);
  void addUser(User user);
}

// Implementação concreta do Mediator
class ChatRoom implements ChatMediator {
  private List<User> users = new ArrayList<>();

  @Override
  public void addUser(User user) {
    users.add(user);
  }

  @Override
  public void sendMessage(String message, User sender) {
    for (User user : users) {
      if (user != sender) {
        user.receiveMessage(message);
      }
    }
  }
}

// Classe base para os participantes do chat
abstract class User {
  protected ChatMediator mediator;
  protected String name;

  public User(String name, ChatMediator mediator) {
    this.name = name;
    this.mediator = mediator;
  }

  public abstract void sendMessage(String message);
  public abstract void receiveMessage(String message);
}

// Implementação concreta de um usuário
class ChatUser extends User {
  public ChatUser(String name, ChatMediator mediator) {
      super(name, mediator);
  }

  @Override
  public void sendMessage(String message) {
    System.out.println(name + " enviando: " + message);
    mediator.sendMessage(message, this);
  }

  @Override
  public void receiveMessage(String message) {
    System.out.println(name + " recebeu: " + message);
  }
}

// Testando a implementação
public class Main {
  public static void main(String[] args) {
    ChatMediator chatRoom = new ChatRoom();

    User alice = new ChatUser("Alice", chatRoom);
    User bob = new ChatUser("Bob", chatRoom);
    User charlie = new ChatUser("Charlie", chatRoom);

    chatRoom.addUser(alice);
    chatRoom.addUser(bob);
    chatRoom.addUser(charlie);

    alice.sendMessage("Oi, pessoal!");
    bob.sendMessage("Olá, Alice!");
  }
}
