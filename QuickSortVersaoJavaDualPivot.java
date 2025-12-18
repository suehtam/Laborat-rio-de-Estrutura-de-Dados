import java.util.Arrays;

public class QuickSortDualPivot {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Escolhe dois pivôs
            if (arr[low] > arr[high]) {
                swap(arr, low, high);
            }
            int pivot1 = arr[low];
            int pivot2 = arr[high];

            int i = low + 1;
            int lt = low + 1;
            int gt = high - 1;

            while (i <= gt) {
                if (arr[i] < pivot1) {
                    swap(arr, i, lt);
                    lt++;
                } else if (arr[i] > pivot2) {
                    swap(arr, i, gt);
                    gt--;
                    i--; // reavaliar posição
                }
                i++;
            }

            lt--; gt++;

            swap(arr, low, lt);
            swap(arr, high, gt);

            // Recursão nas três partes
            quickSort(arr, low, lt - 1);
            quickSort(arr, lt + 1, gt - 1);
            quickSort(arr, gt + 1, high);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Teste
    public static void main(String[] args) {
        int[] arr = {24, 97, 40, 67, 88, 85, 15};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Dual Pivot QuickSort (Java): " + Arrays.toString(arr));
    }
}
