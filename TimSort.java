public class TimSort {
    static int MIN_RUN = 32;

    // Função para aplicar insertion sort em runs pequenos
    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    // Função para mesclar dois runs
    public static void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];

        System.arraycopy(arr, l, left, 0, len1);
        System.arraycopy(arr, m + 1, right, 0, len2);

        int i = 0, j = 0, k = l;
        while (i < len1 && j < len2) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < len1) arr[k++] = left[i++];
        while (j < len2) arr[k++] = right[j++];
    }

    // Função principal do TimSort
    public static void timSort(int[] arr) {
        int n = arr.length;

        // Ordena runs pequenos com insertion sort
        for (int i = 0; i < n; i += MIN_RUN) {
            insertionSort(arr, i, Math.min((i + MIN_RUN - 1), (n - 1)));
        }

        // Mescla runs usando merge sort
        for (int size = MIN_RUN; size < n; size = 2 * size) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));
                if (mid < right) merge(arr, left, mid, right);
            }
        }
    }

    // Teste
    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19};
        timSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
