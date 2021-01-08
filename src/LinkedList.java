public class LinkedList {

    private Node top;

    public LinkedList(){
        top = null;
    }

    public void add(Attribute attribute){
        Node newNode = new Node(attribute);
        newNode.setNext(top);
        top = newNode;
    }

    public Node getTop(){
        return top;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public String toString() {
        String retValue = "\n";
        Node next = top;
        int i = 1;
        while (next.getNext() != null) {
            retValue += i + ") " + next.getName() + " level: (" + next.getLevel() +")\n";
            next = next.getNext();
            i++;
        }

        retValue += i + ") " + next.getName() + " level: (" + next.getLevel() +")\n";

        return retValue;
    }

}
class Node {
    private Attribute attribute;
    private Node next;


    public Node(Attribute attribute){
        this.attribute = attribute;
        next = null;
    }

    public String getName(){
        return attribute.getName();
    }

    public double getLevel() { return attribute.getLevel();}

    public Node getNext(){
        return next;
    }

    public void setName(String name) {
        this.attribute.setName(name);
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
