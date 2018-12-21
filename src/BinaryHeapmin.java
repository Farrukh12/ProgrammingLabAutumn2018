import java.util.NoSuchElementException;

public class BinaryHeapmin {
    private int[] heap;
    private static final int d = 2;

    public BinaryHeapmin(int n) {
        heap = new int[n + 1];


    }

    public void heapfy(int[] A, int i) {
        heap = A;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < heap.length && heap[left] < heap[largest]) {
            largest = left;
        }
        if (right < heap.length && heap[right] < heap[largest]) {
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
        for (int i = (size- 1) / 2; i >= 0; i--) heapfy(heap, i);
    }

    public void print() {
        for (int i = 0; i < heap.length; i++) {
            System.out.println(heap[i] + " " + (i + 1));
        }
    }
    public void increase(int[] A,int i,int key){
        if (key >  A[i - 1]) throw new NoSuchElementException("ERROR");
        A[i - 1] = key;
        while(i > 1 && A[i/2 - 1] > A[i - 1]){
            int t = A[i -1];
            A[i - 1] = A[i/2 -1];
            A[i/2 - 1] = t;
            i = i / 2;
        }
    }
    public void insertHeap(int key){
        increase(heap, heap.length , key);
    }
    public int minHeapmin(){
        return heap[0];
    }

    public static void main(String[] args) {
        BinaryHeapmin br = new BinaryHeapmin(11);
        br.heap = new int[]{3, 4, 5, 6, 7,9,2,1};
        br.insertHeap(15);
        br.build();
        br.print();
        br.minHeapmin();
    }

}
