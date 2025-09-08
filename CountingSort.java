public class CountingSort {

    // Método principal para ordenar um array usando Counting Sort
    public static void countingSort(int[] array) {
        if (array.length == 0) return;

        // Encontra o maior valor no array
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }

        // Cria o array de contagem
        int[] count = new int[max + 1];

        // Conta a ocorrência de cada valor
        for (int num : array) {
            count[num]++;
        }

        // Reconstrói o array ordenado
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                array[index++] = i;
                count[i]--;
            }
        }
    }

    // Exemplo de uso
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Array original:");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();

        countingSort(array);

        System.out.println("Array ordenado:");
        for (int num : array)
            System.out.print(num + " ");
        System.out.println();
    }
}
