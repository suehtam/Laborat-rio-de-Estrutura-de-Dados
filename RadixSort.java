public class RadixSort {
    // Função para obter o valor máximo no array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }

    // Função para realizar o counting sort baseado no dígito
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Inicializa o count[]
        for (int i = 0; i < 10; i++)
            count[i] = 0;

        // Conta as ocorrências de cada dígito
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Calcula posições cumulativas
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Constroi o array de saída
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copia o resultado para o array original
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // Função principal do Radix Sort
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Aplica counting sort para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, exp);
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Array original:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        radixSort(arr);

        System.out.println("\nArray ordenado:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
