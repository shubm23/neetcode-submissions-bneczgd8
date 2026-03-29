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
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!seen.containsKey(key)) return -1;
        remove(seen.get(key));
        add(seen.get(key));
        return seen.get(key).value;
    }

    public void put(int key, int value) {
        if (seen.containsKey(key)) {
            remove(seen.get(key));
        }
        Node node = new Node(key, value);
        add(node);
        seen.put(key, node);

        if (capacity < seen.size()) {
            var lru = tail.prev;
            remove(lru);
            seen.remove(lru.key);
        }
    }

    private void add(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}