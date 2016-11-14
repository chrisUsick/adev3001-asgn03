import java.util.NoSuchElementException;

/**
 * Queue - A queue implementation for heap objects
 *
 * <pre>
 *
 * Assignment: #2
 * Course: ADEV-3001
 * Date Created: November 7, 2016
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
public class Queue<E> {
    /**
     * Node - A node for a queue data structure
     *
     * <pre>
     *
     * Assignment: #2
     * Course: ADEV-3001
     * Date Created: November 7, 2016
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
    protected class Node<E> {
        private E element;
        private Node<E> next;

        /**
         * Initializes a node with an element and the next node
         * @param element   element to save in node
         * @param next      the next node in the queue
         */
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }


        /**
         * Gets the next node
         * @return The next node
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Sets the next node
         * @param next the node to be next in the queue
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * Gets the element
         * @return The element stored by this node
         */
        public E getElement() {
            return element;
        }
    }

    private static final String NO_SUCH_ELEMENT_MESSAGE = "Element not found";
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Initializes the queue
     */
    public Queue() {
        head = tail = null;
        size = 0;
    }

    /**
     * Enqueues an element to the end of the queue
     * @param element element to add
     */
    public void enqueue(E element) {
        Node<E> toAdd = new Node<>(element, null);
        if (size == 0) {
            head = toAdd;
        } else {
            tail.setNext(toAdd);
        }
        size++;
        tail = toAdd;
    }

    /**
     * Shows the next element in the queue. Does not modify the queue
     * Throws NoSuchElementException if queue is empty
     * @return the First element in the queue
     */
    public E front() {
        if (size == 0) {
            throw new NoSuchElementException(NO_SUCH_ELEMENT_MESSAGE);
        }
        return head.getElement();
    }

    /**
     * Removes the first element from the queue
     * @return  The element that was removed
     */
    public E dequeue() {
        if (size == 0) {
            throw new NoSuchElementException(NO_SUCH_ELEMENT_MESSAGE);
        }
        Node<E> current = head;
        if (size == 1) {
            head = tail = null;
        } else {
            head = current.getNext();
        }
        size--;
        return current.getElement();
    }

    /**
     * Shows the size of the queue
     * @return the size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * Specifies if the queue is empty or not
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an element to the queue
     * @param element   the element to add to the queue
     * @return          true if the addition succeeded
     */
    public boolean add(E element) {
        enqueue(element);
        return true;
    }

    /**
     * Adds an element ot the queue
     * @param element   the element to add to the queue
     * @return          true if the addition was successful
     */
    public boolean offer(E element) {
        enqueue(element);
        return true;
    }

    /**
     * Returns and removes the first element in the queue,
     * Returns null if queue is empty
     * @return  removed element
     */
    public E poll() {
        try {
            return dequeue();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }

    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll poll} only in that it throws an NoSuchElementException if this
     * queue is empty.
     *
     * @return the head of this queue
     */
    public E remove() {
        return dequeue();
    }

    /**
     * Retrieves, but does not remove, the head of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an NoSuchElementException
     * if this queue is empty.
     *
     * @return the head of this queue
     */
    public E element() {
        return front();
    }

    /**
     * Retrieves, but does not remove, the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    public E peek() {
        try {
            return front();
        } catch (NoSuchElementException exception) {
            return null;
        }
    }
}
