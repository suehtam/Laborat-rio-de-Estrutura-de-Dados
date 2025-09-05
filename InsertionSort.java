public class InsertionSort {
    /**
     * Ordena um array de inteiros usando o algoritmo Insertion Sort.
     * @param arr Array de inteiros a ser ordenado.
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // Move os elementos maiores que key para uma posição à frente
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] lista = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("Lista original: ");
        for (int num : lista) {
            System.out.print(num + " ");
        }
        System.out.println();
        insertionSort(lista);
        System.out.print("Lista ordenada: ");
        for (int num : lista) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
