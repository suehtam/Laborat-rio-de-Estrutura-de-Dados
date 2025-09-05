public class StableSelectionSort {
    /**
     * Ordena um array de inteiros usando o algoritmo Selection Sort estável.
     * @param arr Array de inteiros a ser ordenado.
     */
    public static void stableSelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // Encontra o índice do menor elemento na parte não ordenada
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            // Salva o valor mínimo
            int minValue = arr[minIdx];

            // Move todos os elementos entre i e minIdx para a direita
            while (minIdx > i) {
                arr[minIdx] = arr[minIdx - 1];
                minIdx--;
            }

            // Coloca o valor mínimo na posição correta
            arr[i] = minValue;
        }
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] lista = {3, 5, 2, 3, 1, 2, 1};
        System.out.print("Lista original: ");
        for (int num : lista) {
            System.out.print(num + " ");
        }
        System.out.println();
        stableSelectionSort(lista);
        System.out.print("Lista ordenada (estável): ");
        for (int num : lista) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
