public class MergeSort {

    // Método principal para ordenar um array usando Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Ordena a primeira metade
            mergeSort(array, left, middle);
            // Ordena a segunda metade
            mergeSort(array, middle + 1, right);

            // Mescla as duas metades ordenadas
            merge(array, left, middle, right);
        }
    }

    // Método para mesclar dois subarrays ordenados
    private static void merge(int[] array, int left, int middle, int right) {
        // Tamanhos dos dois subarrays para mesclagem
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Arrays temporários
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia os dados para os arrays temporários
        for (int i = 0; i < n1; i++)
            L[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = array[middle + 1 + j];

        // Índices iniciais dos subarrays e do array mesclado
        int i = 0, j = 0, k = left;

        // Mescla os arrays temporários de volta ao array original
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes de L, se houver
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copia os elementos restantes de R, se houver
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        System.out.println("Array original:");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();

        mergeSort(array, 0, array.length - 1);

        System.out.println("Array ordenado:");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();
    }
}
