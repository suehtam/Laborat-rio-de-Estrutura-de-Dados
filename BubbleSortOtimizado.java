public class OptimizedBubbleSort {
    /**
     * Ordena um array de inteiros usando o Bubble Sort otimizado.
     * @param arr Array de inteiros a ser ordenado.
     */
    public static void bubbleSortOptimized(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Após cada passagem, o maior elemento já está na posição correta
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos se estiverem fora de ordem
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // Se não houve nenhuma troca, o array está ordenado
            if (!swapped) break;
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
        bubbleSortOptimized(lista);
        System.out.print("Lista ordenada (otimizada): ");
        for (int num : lista) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
