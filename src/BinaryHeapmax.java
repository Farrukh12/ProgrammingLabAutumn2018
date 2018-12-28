import java.lang.reflect.Array;
import java.util.*;

public class BinaryHeapmax implements Queue,max {
    private List<Integer> list;
    public int heapsize;

    public BinaryHeapmax(int[] n) {
        list = new ArrayList<>();
        for(int i = 0; i < n.length; i++){
            list.add(n[i]);
        }
        heapsize = list.size();
    }

    public void add(int value) {
        list.add(value);
        int i = this.heapsize - 1;
        int parent = (i - 1) / 2;

        while (i > 0 && list.get(parent) < list.get(i))
        {
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

        if (left < list.size() && list.get(left) > list.get(largest)) {
            largest = left;
        }
        if (right < list.size() && list.get(right) > list.get(largest)) {
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
        for (int i = (list.size()- 1) / 2; i >= 0; i--){
            heapfy(i);
        }
    }
    public int getMax(){
        int result = list.get(0);
        list.set(0,heapsize - 1);
        list.remove(heapsize - 1);
        return result;
    }

    public void  delete(int i){
        list.remove(i);
    }


    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " " + (i + 1));
        }
    }

    public static void main(String[] args) {
        BinaryHeapmax br = new BinaryHeapmax(new int[]{9,2,3,5,6,7,11});
        br.add(20);
        br.add(41);
        br.build();
        br.max();

        br.print();

    }

    @Override
    public int max() {
        return list.get(0);
    }

    @Override
    public int min() {
        int f = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            if (list.get(i) < f) f = list.get(i);
        }

        return f;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }
    //Если в массиве содержится элемент то true;
    @Override
    public boolean contains(Object o) {
        int a = (int) o;
        for(int i = 0; i < list.size(); i++){
            if (a == list.get(i)) return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return true;
    }
    // Если мы найдем в массиве элемент то true
    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {

        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean offer  (Object o) {
        return false;
    }

    @Override
    public Object remove() {
        return list.get(0);
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object element() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
