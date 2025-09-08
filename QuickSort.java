public class QuickSort {

    // Método principal para ordenar um array usando Quick Sort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Encontra o índice do pivô
            int pivotIndex = partition(array, low, high);

            // Ordena os elementos antes e depois do pivô
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Método para particionar o array e encontrar o pivô
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Escolhe o último elemento como pivô
        int i = low - 1; // Índice do menor elemento

        for (int j = low; j < high; j++) {
            // Se o elemento atual é menor ou igual ao pivô
            if (array[j] <= pivot) {
                i++;
                // Troca array[i] e array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Troca array[i+1] e array[high] (ou seja, o pivô)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Retorna o índice do pivô
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};

        System.out.println("Array original:");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();

        quickSort(array, 0, array.length - 1);

        System.out.println("Array ordenado:");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();
    }
}
