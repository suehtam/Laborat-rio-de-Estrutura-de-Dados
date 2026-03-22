class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia!");
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia!");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
