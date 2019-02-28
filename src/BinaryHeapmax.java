import java.util.*;
import java.lang.*;

class Heap<T extends Comparable<T>> {
    private ArrayList<T> binaryheap;

    public Heap() {
        binaryheap = new ArrayList<T>();
    }

    private void changetoDown() {
        int current = 0;
        int leftChild = 2 * current + 1;
        while (leftChild < binaryheap.size()) {
            int maxelement = leftChild;
            int rightChild = leftChild + 1;
            if (rightChild < binaryheap.size()) {
                if (binaryheap.get(rightChild).compareTo(binaryheap.get(1)) > 0) {
                    ++maxelement;
                }
            }
            if (binaryheap.get(current).compareTo(binaryheap.get(maxelement)) < 0) {
                T tmp = binaryheap.get(current);
                binaryheap.set(current, binaryheap.get(maxelement));
                binaryheap.set(maxelement, tmp);
                current = maxelement;
                leftChild = 2 * current + 1;
            } else break;
        }
    }

    private void changetoUp() {
        int i = binaryheap.size() - 1;
        while (i > 0) {
            int current = (i - 1) / 2;
            T Item = binaryheap.get(i);
            T Parent = binaryheap.get(current);
            if (Item.compareTo(Parent) > 0) {
                binaryheap.set(i, Parent);
                binaryheap.set(current, Item);
                i = current;
            } else break;
        }
    }


    public void insert(T item) {
        binaryheap.add(item);
        changetoUp();
    }

    public T delete() throws NoSuchElementException {
        if (binaryheap.size() == 0) {
            throw new NoSuchElementException();
        }
        if (binaryheap.size() == 1) return binaryheap.remove(0);
        T x = binaryheap.get(0);
        binaryheap.set(0, binaryheap.remove(binaryheap.size() - 1));
        changetoDown();
        return x;
    }

    public int size() {
        return binaryheap.size();
    }

    public boolean isEmpty() {
        return binaryheap.isEmpty();
    }


    public T max() {
        return binaryheap.get(0);
    }

    public void print() {
        for (int i = 0; i < binaryheap.size(); i++) {
            System.out.print(binaryheap.get(i).toString() + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Heap<Integer> heap = new Heap();
        heap.insert(16);
        heap.insert(9);
        heap.insert(11);
        heap.insert(10);
        heap.insert(13);
        heap.insert(31);
        heap.insert(19);
        heap.insert(2);
        heap.insert(50);
        heap.insert(23);
        heap.insert(102);
        heap.delete();
        heap.delete();
        heap.print();

    }
}
