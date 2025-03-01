package MementoExample;

public class Main {
  public static void main(String[] args) {
    TextEditor editor = new TextEditor();
    History history = new History();

    editor.setText("Hello, world!");
    history.saveState(editor);
    System.out.println("Texto atual: " + editor.getText());

    editor.setText("Novo texto...");
    System.out.println("Texto modificado: " + editor.getText());

    history.undo(editor);
    System.out.println("Após desfazer: " + editor.getText());
  }
}