## Memento Design Pattern Example

TextEditor is a simple text editor. You can add new text in the end of the existing one, but you cannot edit or delete
existing text.

We use the Memento pattern to save the state of the text editor.

**TextEditor** - Originator.
<br/>
**TextEditor.TextEditorState** - Memento.
<br/>
**TextManager** - Caretaker.

After using the pattern, all functionality of TextEditor was preserved. But now you can save the state of the TextEditor
object using the TextManager object. You can also use TextManager to rollback changes to a previous saved state.

Run Main.main() to see how it works.