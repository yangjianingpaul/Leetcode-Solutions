/**
 * Problem: 295. Find Median from Data Stream
 * Difficulty: hard
 * Approach: heap
 * Time: O(n), Space: O(n)
 */

class MedianFinder {

    ArrayList<Integer> list1;
    ArrayList<Integer> list2;

    public MedianFinder() {
        list1 = new ArrayList<Integer>();
        list2 = new ArrayList<Integer>();
    }

    public void insertNum(ArrayList<Integer> list, Integer num) {
        if (list.size() == 0) {
            list.add(num);
            return;
        }

        int left = 0;
        int right = list.size() - 1;
        if (list.get(left) >= num) {
            list.addFirst(num);
            return;
        }

        if (list.get(right) <= num) {
            list.addLast(num);
            return;
        }

        while (left <= right) {
            int mid = (right + left) / 2;
            if (list.get(mid) > num) {
                if (list.get(mid - 1) <= num) {
                    list.add(mid, num);
                    return;
                } else {
                    right = mid - 1;
                    continue;
                }
            } else if (list.get(mid) < num) {
                if (list.get(mid + 1) >= num) {
                    list.add(mid + 1, num);
                    return;
                } else {
                    left = mid + 1;
                    continue;
                }
            } else {
                list.add(mid, num);
                return;
            }
        }
    }

    public void addNum(int num) {
        if (list1.size() == 0) {
            list1.add(num);
            return;
        }

        if (num < list1.getLast()) {
            insertNum(list1, num);
            if (list1.size() - list2.size() > 1) {
                list2.addFirst(list1.getLast());
                list1.removeLast();
            }
        } else {
            insertNum(list2, num);
            if (list2.size() - list1.size() > 1) {
                list1.addLast(list2.getFirst());
                list2.removeFirst();
            }
        }
    }

    public double findMedian() {
        if (list1.size() == list2.size()) {
            double a = 2.0;
            return (list1.getLast() + list2.getFirst()) / a;
        } else if (list1.size() > list2.size()) {
            return list1.getLast();
        } else {
            return list2.getFirst();
        }
    }
}