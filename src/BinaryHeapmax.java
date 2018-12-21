import java.util.*;

public class BinaryHeapmax implements Queue,max {
    private List<Integer> reg;
    private int[] heap;
    private static final int d = 2;
    int n;

    public BinaryHeapmax(int n) {
        this.n = n;
        heap = new int[this.n + 1];


    }

    public void heapfy(int[] A, int i) {
        heap = A;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < heap.length && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < heap.length && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != i) {
            int t = heap[i];
            heap[i] = heap[largest];
            heap[largest] = t;
            heapfy(heap, largest);
        }

    }

    public void build() {
        int size = heap.length ;
        for (int i = (size- 1) / 2; i >= 0; i--){
            heapfy(heap, i);
        }
    }

    public int[] delete(int[] A,int n){
        A = heap;
        for(int i = 0; i < heap.length; i++){
            if (A[i] == n) {
            }
            else heapfy(A,i);
        }
        for(int i = 0 ; i < A.length; i++){
            System.out.println(A[i]);
        }
        return A;

    }

    public void increase(int[] A,int i,int key){
        if (key <  A[i - 1]) throw new NoSuchElementException("ERROR");
        A[i - 1] = key;
        while(i > 1 && A[i/2 - 1] < A[i - 1]){
            int t = A[i -1];
            A[i - 1] = A[i/2 -1];
            A[i/2 - 1] = t;
            i = i / 2;
        }
    }

    public void insertHeap(int key){
        heapfy(heap, key);
    }

    public void print() {
        for (int i = 0; i < heap.length; i++) {
            System.out.println(heap[i] + " " + (i + 1));
        }
    }

    public static void main(String[] args) {
        BinaryHeapmax br = new BinaryHeapmax(9);
        br.heap = new int[]{3, 4, 5, 6, 7,9,2,1};
        br.build();
        br.insertHeap(15);
        br.insertHeap(31);
        br.insertHeap(19);
        System.out.println(br.max() + "\n");
        System.out.println(br.min() + "\n");
        br.print();

    }

    @Override
    public int max() {
        return heap[0];
    }

    @Override
    public int min() {
        int f = heap[0];
        for(int i = 1; i < heap.length; i++) {
            if (heap[i] < f) f = heap[i];
        }

        return f;
    }

    @Override
    public int size() {
        return heap.length;
    }

    @Override
    public boolean isEmpty() {
        return heap.length == 0;
    }
    //Если в массиве содержится элемент то true;
    @Override
    public boolean contains(Object o) {
        int a = (int) o;
        for(int i = 0; i < heap.length; i++){
            if (a == heap[i]) return true;
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
        int a = (int) o;
        //Если в массиве есть место то мы можем добавить элемент
        if (heap.length < this.n) return true;
        return false;
    }
    // Если мы найдем в массиве элемент то true
    @Override
    public boolean remove(Object o) {
        int a = (int) o;
        for(int i = 0; i < heap.length; i++){
            if (a == heap[i]) return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        for(int i = 0; i < heap.length; i++){
            heap[i] = 0;
        }

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        Object[] a = c.toArray();
        if (n + a.length < heap.length) return false;
        int f = 0;
        for(int i = 0; i < c.size(); i ++){
            if (heap[i] == (int) a[i]) f++;
        }
        if(f == a.length) return true;
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {

        Object[] a = c.toArray();
        if (n + a.length < heap.length) return false;
        int f = 0;
        for(int i = 0; i < c.size(); i ++){
            if (heap[i] == (int) a[i]) f++;
        }
        if(f == a.length) return true;
        return false;
    }

    @Override
    public boolean offer  (Object o) {
        int a = (int) o;
        for(int i = 0; i < heap.length; i++){
            if (heap[i] == a) return true;
        }
        return false;
    }

    @Override
    public Object remove() {
        return heap[heap.length - 1];
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
