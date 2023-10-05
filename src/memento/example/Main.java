package memento.example;



public class Main {

    private static final String FONT_SIZE_TEXT = "Font size = %d.%n";

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        TextManager textManager = new TextManager(textEditor);

        textEditor.write("The Memento Design Pattern\n");
        textEditor.write("How to implement it in Java?\n");

        textManager.hitSave();

        textEditor.setFontSize(20);
        textEditor.write("Use Memento when you need to make a snapshot of your object before changing it.\n");
        textManager.hitSave();

        textEditor.write("Buy milk and eggs before coming home\n");

        System.out.printf(FONT_SIZE_TEXT, textEditor.getFontSize());
        System.out.println(textEditor.getText());

        for (int i = 0; i < 4; i++) {
            textManager.hitUndo();
            System.out.printf(FONT_SIZE_TEXT, textEditor.getFontSize());
            System.out.println(textEditor.getText());
        }
    }

}
