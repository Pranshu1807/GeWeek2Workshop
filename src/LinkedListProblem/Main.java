package LinkedListProblem;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(80);
        linkedList.add(50);
        linkedList.add(15);
        linkedList.display();
        linkedList.reverse();
        linkedList.display();
    }
}
