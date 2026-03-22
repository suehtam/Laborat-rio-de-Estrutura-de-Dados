public class Main {
    public static void main(String[] args) {
        Queue fila = new Queue();

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println(fila.dequeue()); // 10
        System.out.println(fila.dequeue()); // 20

        fila.enqueue(40);
        System.out.println(fila.dequeue()); // 30
        System.out.println(fila.dequeue()); // 40
    }
}
