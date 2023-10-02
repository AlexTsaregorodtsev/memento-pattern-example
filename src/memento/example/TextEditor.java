package memento.example;

/**
 * Originator class.
 */
public class TextEditor {

    private StringBuilder currentText;

    public TextEditor() {
        this.currentText = new StringBuilder();
    }

    public void write(String text) {
        currentText.append(text);
    }

    public String getText() {
        return currentText.toString();
    }

    public TextEditorState prepareMemento() {
        return new TextEditorState(currentText.toString());
    }

    public void restore(TextEditorState memento) {
        currentText = new StringBuilder(memento.getText());
    }

    /**
     * Memento class.
     */
    public class TextEditorState {

        private final String text;

        private TextEditorState(String text) {
            this.text = text;
        }

        private String getText() {
            return text;
        }
    }
}
