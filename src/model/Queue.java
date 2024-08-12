package model;
public class Queue<T>{
    public class QueueNode {
        public T data;
        public QueueNode next;

        public QueueNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private QueueNode head;
    private QueueNode tail;
    private long size;
    private long maxSize;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Queue(int maxSize) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.maxSize = maxSize;
    }

    public QueueNode searchQueueNode(T value){
        QueueNode search = head;
        while(search.next != null){
            if(value == search.data){
                return search;
            }
            search = search.next;
        }
        return null;
    }

    public void add(T value) {
        QueueNode node = new QueueNode(value);

        if(isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T remove() {
        QueueNode node = head;

        T returnData = null;

        if(!isEmpty()) {
            returnData = head.data;
            if(head == tail) {
                head = null;
                tail = null;
            } else {
                node.next = null;

                size--;
            }
        }
        else {
            System.out.println("Lista vazia");
        }
        return returnData;
    }

    public T peek() {
        if (!isEmpty()) {
            System.out.println("Lista vazia");
            return null;
        }

        return head.data;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public boolean isFull() {
        if(this.size < maxSize){
            return false;
        } else {
            return true;
        }
    }

    public QueueNode getHead() {
        return head;
    }

    public void setHead(QueueNode head) {
        this.head = head;
    }

    public QueueNode getTail() {
        return tail;
    }

    public void setTail(QueueNode tail) {
        this.tail = tail;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}