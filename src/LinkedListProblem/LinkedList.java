package LinkedListProblem;

public class LinkedList<T> {
    public Node<T> head;

    public LinkedList() {
        head = null;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(value);

        if (this.head == null) {
            this.head = node;
        } else {
            Node<T> temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void display() {
        Node<T> temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> curr = this.head;
        Node<T> nxt = null;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        this.head = prev;
    }
}
