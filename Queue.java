class Queue {
    private Stack stack1;
    private Stack stack2;

    public Queue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void enqueue(int value) {
        stack1.push(value);
    }

    public int dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException("Fila vazia!");
        }
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
