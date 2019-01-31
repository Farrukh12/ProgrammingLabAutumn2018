import static org.junit.Assert.*;

public class BinaryHeapmaxTest {
    BinaryHeapmax br1 = new BinaryHeapmax(new int[]{3,4,5,6,7,17});
    public int size = br1.size();
    @org.junit.Test
    public void add() {
        br1.add(14);
        br1.add(10);
        br1.add(15);
        br1.build();
        assertEquals(9,br1.size());
        br1.add(31);
        br1.add(21);
        assertEquals(11,br1.size());
        br1.add(2);
        br1.add(101);
        br1.add(104);
        br1.add(105);
        assertEquals(15,br1.size());

    }

    @org.junit.Test
    public void delete() {

    }
    @org.junit.Test
    public void getMax(){
        br1.build();
        assertEquals(17,br1.getMax());
        br1.add(105);
        br1.add(41);
        br1.build();
        assertEquals(105,br1.getMax());
    }
    @org.junit.Test
    public void offer() {
    }

    @org.junit.Test
    public void remove() {
    }

    @org.junit.Test
    public void poll() {
        br1.add(42);
        br1.build();
        assertEquals(42,br1.poll());
        br1.add(53);
        br1.build();
        assertEquals(53,br1.poll());

    }

    @org.junit.Test
    public void element() {
        br1.add(42);
        br1.build();
        assertEquals(42,br1.poll());
        br1.add(53);
        br1.build();
        assertEquals(53,br1.poll());
    }

    @org.junit.Test
    public void peek() {
        br1.add(34);
        br1.build();
        assertEquals(34,br1.poll());
        br1.add(33);
        br1.add(41);
        br1.build();
        br1.print();
        assertEquals(41,br1.poll());
    }
}