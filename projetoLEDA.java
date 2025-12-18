package org.example;
import java.lang.Math.*;
import java.util.Arrays;

public class Main {

    //bubbleSort
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //bubbleSortOtimizado
    public static void bubbleSortOptimized(int[] arr){
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    //selectionSort
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    //selectionSortEstável
    public static void stableSelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {

            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int minValue = arr[minIdx];
            while (minIdx > i) {
                arr[minIdx] = arr[minIdx - 1];
                minIdx--;
            }
            arr[i] = minValue;
        }
    }

    //insertionSort
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    //mergeSort
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
    //Método para mesclar dois subarrays ordenados
    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Arrays temporários
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = array[middle + 1 + j];

        int i = 0, j = 0, k = left;

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
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    //insertionSortAdapted
    public static void insertionSortAdapted(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    //timSort
    private static final int RUN = 32;

    public static void timSort(int[] arr) {
        int n = arr.length;

        //Ordena pequenos blocos com insertionSort
        for (int i = 0; i < n; i += RUN) {
            insertionSortAdapted(arr, i, Math.min(i + RUN - 1, n - 1));
        }
        //Faz os merges (igual ao MergeSort)
        for (int size = RUN; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);

                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }

    //Arrays.sort?
    }

    //quicksSort
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);   // Ordena a sublista à esquerda do pivô
            quickSort(arr, pivotIndex + 1, right); // Ordena a sublista à direita do pivô
        }
    }
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //quickSortSS
    public static void quickSortSS(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partitionSS(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swapSS(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //quickSort do java = dual-pivot quicksort (Arrays.sort)

    //countingSort
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

    //busca linear iterativa
    public static int buscaLinear(int[] arr, int chave) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == chave) {
                return i;
            }
        }
        return -1;
    }

    //busca linear recursiva
    public static int buscaLinearRecursiva(int[] arr, int chave, int indice) {
        if (indice >= arr.length) {
            return -1;
        }
        if (arr[indice] == chave) {
            return indice;
        }
        return buscaLinearRecursiva(arr, chave, indice + 1);
    }

    //busca binária iterativa
    public static int buscaBinariaIterativa(int[] arr, int chave) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == chave) {
                return mid;
            } else if (arr[mid] < chave) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    //busca binária recursiva
    public static int buscaBinariaRecursiva(int[] arr, int chave, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == chave) {
            return mid;
        } else if (arr[mid] < chave) {
            return buscaBinariaRecursiva(arr, chave, mid + 1, right);
        } else {
            return buscaBinariaRecursiva(arr, chave, left, mid - 1);
        }
    }

    //busca linear iterativa duas pontas
    public static int buscaLinearDuasPontas(int[] arr, int chave) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            if (arr[left] == chave) {
                return left;
            }
            if (arr[right] == chave) {
                return right;
            }
            left++;
            right--;
        }

        return -1;
    }

}
