import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueMastery {
    public void heapOperations() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<int[]> customHeap = new PriorityQueue<int[]>((a, b) -> a[1] -
                b[1]);

        minHeap.offer(5);
        minHeap.poll();
        minHeap.peek();
        minHeap.size();
        minHeap.isEmpty();

        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5);
        PriorityQueue<Integer> heapFromList = new PriorityQueue<Integer>(list);
    }
}
