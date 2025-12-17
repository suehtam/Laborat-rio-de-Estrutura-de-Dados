public class BuscaBinaria {
    public static <T extends Comparable<T>> int buscaBinariaIterativa(T[] arr, T chave) {
        int esq = 0, dir = arr.length - 1;
        while (esq <= dir) {
            int meio = (esq + dir) / 2;
            int cmp = arr[meio].compareTo(chave);
            if (cmp == 0) return meio;
            else if (cmp < 0) esq = meio + 1;
            else dir = meio - 1;
        }
        return -1;
    }
