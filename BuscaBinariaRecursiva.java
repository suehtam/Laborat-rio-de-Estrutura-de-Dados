    public static <T extends Comparable<T>> int buscaBinariaRecursiva(T[] arr, T chave, int esq, int dir) {
        if (esq > dir) return -1;
        int meio = (esq + dir) / 2;
        int cmp = arr[meio].compareTo(chave);
        if (cmp == 0) return meio;
        else if (cmp < 0) return buscaBinariaRecursiva(arr, chave, meio+1, dir);
        else return buscaBinariaRecursiva(arr, chave, esq, meio-1);
    }
}
