import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * QueueTest - Test methods for the Queue
 *
 * <pre>
 *
 * Assignment: #2
 * Course: ADEV-3001
 * Date Created: November 11, 2016
 *
 * Revision Log
 * Who          When    Reason
 * --------- ---------- ----------------------------------
 *
 * </pre>
 *
 * @author Chris Usick
 * @version 1.0
 *
 */
public class QueueTest {
    private Queue<String> queue;
    private String str1 = "str1";
    private String str2 = "str2";

    /**
     * Tests the enqueue method
     * @throws Exception
     */
    @Test
    public void enqueue() throws Exception {
        queue = new Queue<>();
        queue.enqueue(str1);
        assertEquals("Failed to enqueue to an empty queue", queue.front(), str1);
        assertEquals(queue.size(), 1);
        queue.enqueue(str2);
        assertEquals("Failed to enqueue to an empty queue", queue.size(), 2);
    }

    /**
     * Tests the front method
     * @throws Exception
     */
    @Test
    public void front() throws Exception {
        queue = new Queue<>();
        queue.enqueue(str1);
        assertEquals("Failed to show front of queue with 1 element", queue.front(), str1);
        queue.enqueue(str2);
        assertEquals("Failed to show front of queue with 2 element", queue.front(), str1);
        queue = new Queue<>();
        try {
            queue.front();
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }

    /**
     * Tests the dequeue method
     * @throws Exception
     */
    @Test
    public void dequeue() throws Exception {
        queue = new Queue<>();
        queue.enqueue(str1);
        queue.enqueue(str2);
        String dequeued = queue.dequeue();
        assertEquals("failed dequeues an element", dequeued, str1);
        assertEquals(queue.size(), 1);
        queue.dequeue();
        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }

    /**
     * Tests the size method
     * @throws Exception
     */
    @Test
    public void size() throws Exception {
        queue = new Queue<>();
        assertEquals("Failed to show size for empty queue", queue.size(), 0);
        queue.enqueue(str1);
        assertEquals("show size of single element queue", queue.size(), 1);
        queue.enqueue(str2);
        assertEquals("show size of multi element queue", queue.size(), 2);
    }

    /**
     * Tests the isEmpty method
     * @throws Exception
     */
    @Test
    public void isEmpty() throws Exception {
        queue = new Queue<>();
        assertTrue("Failed to show queue is empty", queue.isEmpty());
        queue.enqueue(str1);
        assertTrue("Failed to show queue is not empty", !queue.isEmpty());
    }

    /**
     * Tests the add method
     * @throws Exception
     */
    @Test
    public void add() throws Exception {
        queue = new Queue<>();
        queue.add(str1);
        assertEquals("Failed to add to an empty queue", queue.front(), str1);
        assertEquals(queue.size(), 1);
        queue.add(str1);
        assertEquals("Failed to add to queue with elements", queue.front(), str1);
        assertEquals(queue.size(), 2);
    }

    /**
     * Tests the offer method
     * @throws Exception
     */
    @Test
    public void offer() throws Exception {
        queue = new Queue<>();
        queue.offer(str1);
        assertEquals("Failed to add to an empty queue", queue.front(), str1);
        assertEquals(queue.size(), 1);
        queue.offer(str1);
        assertEquals("Failed to add to queue with elements", queue.front(), str1);
        assertEquals(queue.size(), 2);
    }

    /**
     * Tests the poll method
     * @throws Exception
     */
    @Test
    public void poll() throws Exception {
        queue = new Queue<>();
        queue.enqueue(str1);
        queue.enqueue(str2);
        String dequeued = queue.poll();
        assertEquals("failed to poll an element", dequeued, str1);
        assertEquals(queue.size(), 1);
        queue.poll();
        assertNull("poll did not return null", queue.poll());
    }

    /**
     * Tests the remove method
     * @throws Exception
     */
    @Test
    public void remove() throws Exception {
        queue = new Queue<>();
        queue.enqueue(str1);
        queue.enqueue(str2);
        String dequeued = queue.remove();
        assertEquals("failed dequeues an element", dequeued, str1);
        assertEquals(queue.size(), 1);
        queue.remove();
        try {
            queue.remove();
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }

    /**
     * Tests the element method
     * @throws Exception
     */
    @Test
    public void element() throws Exception {
        queue = new Queue<>();
        queue.enqueue(str1);
        assertEquals("Failed to show element of queue with 1 element", queue.element(), str1);
        queue.enqueue(str2);
        assertEquals("Failed to show element of queue with 2 element", queue.element(), str1);
        queue = new Queue<>();
        try {
            queue.element();
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }

    /**
     * Tests the peek method
     * @throws Exception
     */
    @Test
    public void peek() throws Exception {
        queue = new Queue<>();
        queue.enqueue(str1);
        assertEquals("Failed to peek queue with 1 element", queue.peek(), str1);
        queue.enqueue(str2);
        assertEquals("Failed to ppek queue with 2 element", queue.peek(), str1);
        queue = new Queue<>();
        assertNull(queue.peek());
    }
}