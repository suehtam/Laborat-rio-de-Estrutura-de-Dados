public class Main {
    public static void main(String[] args) {
        Estudante[] estudantes = {
            new Estudante(1, "Ana", 90),
            new Estudante(2, "Carlos", 85),
            new Estudante(3, "Bruno", 90),
            new Estudante(4, "Daniela", 70)
        };

        System.out.println("Original:");
        System.out.println(java.util.Arrays.toString(estudantes));

        BubbleSort.bubbleSortOtimizado(estudantes);
        System.out.println("BubbleSort Otimizado:");
        System.out.println(java.util.Arrays.toString(estudantes));

        // Experimento com int[]
        int[] arr = {5,2,9,1,5,6};
        long start = System.nanoTime();
        java.util.Arrays.sort(arr); // QuickSort/TimSort do Java
        long end
