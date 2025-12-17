public class BuscaLinear {
    public static <T extends Comparable<T>> int buscaLinearIterativa(T[] arr, T chave) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(chave) == 0) {
                return i;
            }
        }
        return -1; // não encontrado
    }
