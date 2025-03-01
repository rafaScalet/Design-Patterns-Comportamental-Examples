package MementoExample;

public class TextEditor {
  private String text;

  public void setText(String text) {
    this.text = text;
  }

  public String getText() {
    return this.text;
  }

  public Memento save() {
    return new Memento(text);
  }

  public void restore(Memento memento) {
    this.text = memento.getState();
  }
}
