import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMastery {
    public void essentialOperations() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(0, 1);
        list.get(0);
        list.remove(0);
        list.size();
        list.contains(1);
        list.indexOf(1);
        list.lastIndexOf(1);
        list.addAll(Arrays.asList(1, 2, 3));
        list.removeAll(Arrays.asList(1, 2));
        list.retainAll(Arrays.asList(2, 3));

        Integer[] array = list.toArray(new Integer[0]);
        List<Integer> fromArray = Arrays.asList(1, 2, 3);
        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1,2,3));
    }
}
