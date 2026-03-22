import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testPushAndPop() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void testPeek() {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(15);

        assertEquals(15, stack.peek());
        assertEquals(15, stack.pop()); // peek não remove
    }

    @Test
    void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPopEmptyThrowsException() {
        Stack stack = new Stack();
        assertThrows(RuntimeException.class, stack::pop);
    }
}
