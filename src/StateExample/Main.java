package StateExample;

// Interface para os estados de cor
interface CorState {
  void mostrarCor();
}

// Estado: Vermelho
class CorVermelho implements CorState {
  @Override
  public void mostrarCor() {
    System.out.println("🔴 O objeto está na cor VERMELHO.");
  }
}

// Estado: Verde
class CorVerde implements CorState {
  @Override
  public void mostrarCor() {
    System.out.println("🟢 O objeto está na cor VERDE.");
  }
}

// Estado: Azul
class CorAzul implements CorState {
  @Override
  public void mostrarCor() {
    System.out.println("🔵 O objeto está na cor AZUL.");
  }
}

// Estado: Amarelo
class CorAmarelo implements CorState {
  @Override
  public void mostrarCor() {
    System.out.println("🟡 O objeto está na cor AMARELO.");
  }
}

// Classe Contexto que mantém a referência para o estado atual
class ObjetoColorido {
  private CorState estadoAtual;

  // Construtor inicializando com uma cor
  public ObjetoColorido(CorState estadoInicial) {
    this.estadoAtual = estadoInicial;
  }

  // Método para alterar o estado (mudar a cor)
  public void setEstado(CorState novoEstado) {
    this.estadoAtual = novoEstado;
  }

  // Método para exibir a cor atual
  public void mostrarCor() {
    estadoAtual.mostrarCor();
  }
}

public class Main {
  public static void main(String[] args) {
    // Criando um objeto que começa na cor Vermelho
    ObjetoColorido objeto = new ObjetoColorido(new CorVermelho());

    // Exibir estado atual
    objeto.mostrarCor();

    // Mudar para Verde
    objeto.setEstado(new CorVerde());
    objeto.mostrarCor();

    // Mudar para Azul
    objeto.setEstado(new CorAzul());
    objeto.mostrarCor();

    // Mudar para Amarelo
    objeto.setEstado(new CorAmarelo());
    objeto.mostrarCor();
  }
}

