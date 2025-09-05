public class SelectionSort {
    /**
     * Ordena um array de inteiros usando o algoritmo Selection Sort.
     * @param arr Array de inteiros a ser ordenado.
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Encontra o índice do menor elemento na parte não ordenada
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Troca o menor elemento encontrado com o primeiro elemento não ordenado
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
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
        selectionSort(lista);
        System.out.print("Lista ordenada: ");
        for (int num : lista) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
