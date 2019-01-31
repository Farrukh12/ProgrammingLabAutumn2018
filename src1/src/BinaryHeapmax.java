import java.lang.reflect.Array;
import java.util.*;

public class BinaryHeapmax implements Queue{
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
        build();
    }


    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " " + (i + 1));
        }
    }

    public static void main(String[] args) {
        BinaryHeapmax br = new BinaryHeapmax(new int[]{41, 15, 16, 12, 13});
        br.build();
        br.print();

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
        for(int i = 0; i < list.size(); i++){
            if (o == list.get(i)) return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] obj = new Object[list.size()];
        int i = 0;
        for (Object b: list)
            obj[i++] = b;
        return obj;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return a;
    }

    @Override
    public boolean add(Object o) {
        int size = list.size();
        list.add((Integer) o);
        if (list.size() != size) return true;
        return false;
    }
    @Override
    public boolean remove(Object o) {
        int size = list.size();
        list.remove(o);
        if (list.size() != size) return true;
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        for(int i = 0; i < list.size(); i++){
            list.remove(i);
        }
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
        int size = list.size();
        list.add((Integer) o);
        if (list.size() != size) return true;
        return false;
    }

    @Override
    public Object remove() {
        Object c = list.get(0);
        if (list.get(0) != null) {
            list.remove(0);
            return c;
        }
        else throw new NoSuchElementException();
    }

    @Override
    public Object poll() {
        Object c = list.get(0);
        if (list.get(0) != null) {
            list.remove(0);
            return c;
        }
        return null;
    }

    @Override
    public Object element() {
        if (list.get(0) != null) return list.get(0);
        else throw new NoSuchElementException();
    }

    @Override
    public Object peek() {
        if (list.get(0) != null) return list.get(0);
        return null;
    }
}
