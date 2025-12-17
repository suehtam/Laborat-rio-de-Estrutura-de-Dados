public class BuscaLinear {
    public static <T extends Comparable<T>> int buscaLinearDuasPontas(T[] arr, T chave) {
        int esq = 0, dir = arr.length - 1;
        while (esq <= dir) {
            if (arr[esq].compareTo(chave) == 0) return esq;
            if (arr[dir].compareTo(chave) == 0) return dir;
            esq++;
            dir--;
        }
        return -1;
    }
}
