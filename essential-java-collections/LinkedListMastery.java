import java.util.LinkedList;

public class LinkedListMastery {
    public void sequentialOperations() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addFirst(1);
        list.removeFirst();
        list.getFirst();

        list.addLast(1);
        list.removeLast();
        list.getLast();

        list.offer(1); // == list.addLast(1);
        list.poll();
        list.peek();

        list.push(1);
        list.pop();
    }
}
