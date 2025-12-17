    public static <T extends Comparable<T>> int buscaLinearRecursiva(T[] arr, T chave, int i) {
        if (i >= arr.length) return -1;
        if (arr[i].compareTo(chave) == 0) return i;
        return buscaLinearRecursiva(arr, chave, i+1);
    }
