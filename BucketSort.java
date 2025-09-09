import java.util.*;

public class BucketSort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0)
            return;

        // Criar n buckets vazios
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new List[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Colocar os elementos nos buckets
        for (float num : arr) {
            int bucketIndex = (int) (num * n);
            buckets[bucketIndex].add(num);
        }

        // Ordenar cada bucket individualmente
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatenar os buckets ordenados
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }

    // Exemplo de uso
    public static void main(String[] args) {
        float[] arr = {0.42f, 4.21f, 3.14f, 2.71f, 0.23f, 1.61f, 2.18f};
        System.out.println("Array original: " + Arrays.toString(arr));
        // Para funcionar corretamente, os números devem estar entre 0 e 1.
        // Se não estiverem, pode ser necessário normalizar os valores.
        bucketSort(arr);
        System.out.println("Array ordenado: " + Arrays.toString(arr));
    }
}
