package memento.example;

import java.util.ArrayDeque;
import java.util.Deque;
import memento.example.TextEditor.TextEditorState;

/**
 * Caretaker class.
 */
public class TextManager {

    private final TextEditor textEditor;
    private final Deque<TextEditorState> history = new ArrayDeque<>();

    public TextManager(TextEditor textEditor) {
        this.textEditor = textEditor;
    }

    public void hitSave() {
        TextEditorState memento = textEditor.prepareMemento();
        history.push(memento);
    }

    public void hitUndo() {
        if (!history.isEmpty()) {
            TextEditorState memento = history.pop();
            textEditor.restore(memento);
        } else {
            textEditor.restoreDefault();
        }
    }

}
