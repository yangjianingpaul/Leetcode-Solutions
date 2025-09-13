import java.util.HashSet;
import java.util.Set;

public class SetMastery {
    public void setOperations() {
        HashSet<Integer> set = new HashSet<Integer>();

        set.add(1);
        set.remove(1);
        set.contains(1);
        set.size();
        set.isEmpty();

        Set<Integer> other = Set.of(2, 3, 4);
        HashSet<Integer> intersection = new HashSet<Integer>(set);
        intersection.retainAll(other);

        HashSet<Integer> union = new HashSet<Integer>(set);
        union.addAll(other);

        HashSet<Integer> difference = new HashSet<Integer>(set);
        difference.removeAll(other);

        for (Integer element : set) {
            System.out.println(element);
        }
    }
}
