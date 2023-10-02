package memento.example;



public class Main {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        TextManager textManager = new TextManager(textEditor);

        textEditor.write("The Memento Design Pattern\n");
        textEditor.write("How to implement it in Java?\n");

        textManager.hitSave();

        textEditor.write("Use Memento when you need to make a snapshot of your object before changing it.\n");
        textManager.hitSave();

        textEditor.write("Buy milk and eggs before coming home\n");

        System.out.println(textEditor.getText());

        textManager.hitUndo();
        System.out.println(textEditor.getText());

        textManager.hitUndo();
        System.out.println(textEditor.getText());

        textManager.hitUndo();
        System.out.println(textEditor.getText());
    }

}
