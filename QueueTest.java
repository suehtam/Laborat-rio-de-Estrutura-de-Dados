import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void testEnqueueAndDequeue() {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
    }

    @Test
    void testMixedOperations() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.dequeue());

        queue.enqueue(3);
        queue.enqueue(4);

        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
    }

    @Test
    void testIsEmpty() {
        Queue queue = new Queue();
        assertTrue(queue.isEmpty());

        queue.enqueue(99);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    void testDequeueEmptyThrowsException() {
        Queue queue = new Queue();
        assertThrows(RuntimeException.class, queue::dequeue);
    }
}
