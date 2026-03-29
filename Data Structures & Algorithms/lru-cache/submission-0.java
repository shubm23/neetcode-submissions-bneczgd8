class Node {
    public Node next;
    public int key;
    public Node prev;
    public int value;

    Node(int key, Node next, Node prev, int value) {
        this.key = key;
        this.next = next;
        this.prev = prev;
        this.value = value;
    }

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> seen = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // Dummy nodes to avoid null checks
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!seen.containsKey(key)) return -1;
        
        Node node = seen.get(key);
        remove(node);
        add(node); // Move to head (MRU)
        return node.value;
    }

    public void put(int key, int value) {
        if (seen.containsKey(key)) {
            remove(seen.get(key));
        }
        
        Node node = new Node(key, value);
        add(node);
        seen.put(key, node);

        if (seen.size() > capacity) {
            // The LRU node is the one right before the dummy tail
            Node lru = tail.prev; 
            remove(lru);
            seen.remove(lru.key);
        }
    }

    // Adds node right after the dummy head (Most Recently Used)
    private void add(Node node) {
        Node afterHead = head.next;
        
        head.next = node;
        node.prev = head;
        
        node.next = afterHead;
        afterHead.prev = node;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}