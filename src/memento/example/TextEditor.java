package memento.example;

/**
 * Originator class.
 */
public class TextEditor {

    private static final String FONT_SIZE_EXCEPTION = "Expected font size from 1 to 100 inclusive. Received %d.";

    private static final int DEFAULT_FONT_SIZE = 12;
    private StringBuilder currentText;
    private int fontSize;

    public TextEditor() {
        this.currentText = new StringBuilder();
        this.fontSize = DEFAULT_FONT_SIZE;
    }

    public void write(String text) {
        currentText.append(text);
    }

    public String getText() {
        return currentText.toString();
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        if (fontSize <= 0 || fontSize >= 100) {
            throw new IllegalArgumentException(String.format(FONT_SIZE_EXCEPTION, fontSize));
        }
        this.fontSize = fontSize;
    }

    public TextEditorState prepareMemento() {
        return new TextEditorState(currentText.toString(), fontSize);
    }

    public void restore(TextEditorState memento) {
        currentText = new StringBuilder(memento.getText());
        fontSize = memento.getFontSize();
    }

    /**
     * Memento class.
     */
    public class TextEditorState {

        private final String text;
        private final int fontSize;

        private TextEditorState(String text, int fontSize) {
            this.text = text;
            this.fontSize = fontSize;
        }

        private String getText() {
            return text;
        }

        private int getFontSize() {
            return fontSize;
        }
    }
}
