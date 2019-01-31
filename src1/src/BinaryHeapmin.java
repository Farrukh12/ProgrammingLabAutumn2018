import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryHeapmin {
    private List<Integer> list;
    public int heapsize;

    public BinaryHeapmin(int[] n) {
        list = new ArrayList<>();
        for (int i = 0; i < n.length; i++) {
            list.add(n[i]);
        }
        heapsize = list.size();
    }

    public void add(int value) {
        list.add(value);
        int i = this.heapsize - 1;
        int parent = (i - 1) / 2;

        while (i > 0 && list.get(parent) < list.get(i)) {
            int temp = list.get(i);
            list.set(i, list.get(parent));
            list.set(parent, temp);

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    public void heapfy(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < list.size() && list.get(left) < list.get(largest)) {
            largest = left;
        }
        if (right < list.size() && list.get(right) < list.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            int t = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, t);
            heapfy(largest);
        }

    }

    public void build() {
        for (int i = (list.size() - 1) / 2; i >= 0; i--) {
            heapfy(i);
        }
    }

    public int getMax() {
        int result = list.get(0);
        list.set(0, heapsize - 1);
        list.remove(heapsize - 1);
        return result;
    }

    public void delete(int i) {
        list.remove(i);
        build();
    }


    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " " + (i + 1));
        }
    }

    public static void main(String[] args) {
        BinaryHeapmin br = new BinaryHeapmin(new int[]{9, 2, 3, 5, 6, 7, 11});
        br.add(20);
        br.add(41);
        br.delete(2);
        br.build();
        br.print();

    }

}
