import java.util.ArrayDeque;

public class ArrayDequeMastery {
    public void versatileOperations() {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        // queue operations
        deque.offerLast(1);
        deque.pollFirst();
        deque.peekFirst();
        // stack operations
        deque.offerFirst(1);
        deque.pollFirst();
        deque.peekFirst();
        // double-ended operations
        deque.offerLast(1);
        deque.offerFirst(1);
        deque.pollLast();
        deque.pollFirst();
        deque.peekLast();
        deque.peekFirst();

        deque.size();
        deque.isEmpty();
    }
}
