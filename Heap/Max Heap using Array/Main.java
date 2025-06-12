public class Main {
    public static void main(String[] args) {
        PQueue pq = new PQueue(10);

        pq.enqueue(40);
        pq.enqueue(25);
        pq.enqueue(60);
        pq.enqueue(10);

        System.out.println("Priority Queue size: " + pq.size());
        System.out.println("Top priority (peek): " + pq.peek());

        System.out.println("Dequeued: " + pq.dequeue());
        System.out.println("Top priority after dequeue: " + pq.peek());
        System.out.println("Priority Queue size: " + pq.size());
    }
}

class MaxHeap {
    private int[] heapArray;
    private int maxSize;
    private int size;

    // Constructor to initialize the heap
    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heapArray = new int[maxSize];
    }

    // Get index of parent, left child, and right child
    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    // Insert an element into the heap
    public void insert(int element) {
        if (size >= maxSize) {
            System.out.println("Heap is full. Cannot insert.");
            return;
        }

        heapArray[size] = element;
        int current = size;
        size++;

        // Heapify-up
        while (current > 0 && heapArray[current] > heapArray[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    // Remove and return the maximum (root) element
    public int removeMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        int max = heapArray[0];
        heapArray[0] = heapArray[size - 1];
        size--;

        // Heapify-down
        heapify(0);

        return max;
    }

    // Heapify-down method
    private void heapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heapArray[left] > heapArray[largest]) {
            largest = left;
        }

        if (right < size && heapArray[right] > heapArray[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    // Swap elements
    private void swap(int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    // Print the heap (for testing)
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }
    public int getSize() {
        return size;
    }

    // Get the maximum element without removing it
    public int getMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heapArray[0];
    }
}

class PQueue {
    private MaxHeap heap;

    // Constructor: initialize PQueue with a max size
    public PQueue(int capacity) {
        this.heap = new MaxHeap(capacity);
    }

    // Insert an element into the priority queue
    public void enqueue(int element) {
        heap.insert(element);
    }

    // Remove and return the highest priority element
    public int dequeue() {
        return heap.removeMax();
    }

    // Peek at the highest priority element without removing
    public int peek() {
        if (heap.getSize() == 0) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        return heap.getMax();
    }

    // Check if the priority queue is empty
    public boolean isEmpty() {
        return heap.getSize() == 0;
    }

    // Get current size of the priority queue
    public int size() {
        return heap.getSize();
    }
}

