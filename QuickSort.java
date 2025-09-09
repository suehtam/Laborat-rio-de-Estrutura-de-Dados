public class QuickSortNormal {
    // Função principal para ordenar o array usando Quick Sort
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);   // Ordena a sublista à esquerda do pivô
            quickSort(arr, pivotIndex + 1, right); // Ordena a sublista à direita do pivô
        }
    }

    // Particionamento usando o elemento da esquerda como pivô
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left + 1;
        int j = right;

        while (true) {
            // Move 'i' para a direita enquanto arr[i] <= pivot
            while (i <= j && arr[i] <= pivot) i++;
            // Move 'j' para a esquerda enquanto arr[j] > pivot
            while (i <= j && arr[j] > pivot) j--;
            if (i > j) break;

            // Troca os elementos fora de lugar
            swap(arr, i, j);
        }
        // Coloca o pivô na posição correta
        swap(arr, left, j);
        return j;
    }

    // Função auxiliar para trocar elementos
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] arr = {8, 3, 1, 7, 0, 10, 2};
        System.out.println("Array original:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Array ordenado:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
