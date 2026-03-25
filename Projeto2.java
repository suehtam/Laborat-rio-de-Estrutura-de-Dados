// =========================================
// SISTEMA COMPLETO DE ESTOQUE - PROJETO UEPB
// Inclui: Lista, Pilha, Fila(2 pilhas), Hash(chaining), AVL, Heap, JUnit base
// =========================================

import java.util.*;

// ================= LISTA ENCADEADA =================
class No<T> {
    T valor;
    No<T> proximo;

    No(T v) { valor = v; }
}

class ListaEncadeada<T> {
    No<T> head;

    void inserir(T v) {
        No<T> n = new No<>(v);
        n.proximo = head;
        head = n;
    }

    T buscar(java.util.function.Predicate<T> cond) {
        No<T> atual = head;
        while (atual != null) {
            if (cond.test(atual.valor)) return atual.valor;
            atual = atual.proximo;
        }
        return null;
    }
}

// ================= PILHA =================
class Pilha<T> {
    private ListaEncadeada<T> lista = new ListaEncadeada<>();

    void push(T v) { lista.inserir(v); }

    T pop() {
        if (lista.head == null) return null;
        T v = lista.head.valor;
        lista.head = lista.head.proximo;
        return v;
    }

    boolean isEmpty() { return lista.head == null; }
}

// ================= FILA COM 2 PILHAS =================
class Fila<T> {
    private Pilha<T> entrada = new Pilha<>();
    private Pilha<T> saida = new Pilha<>();

    void enqueue(T v) { entrada.push(v); }

    T dequeue() {
        if (saida.isEmpty()) {
            while (!entrada.isEmpty()) {
                saida.push(entrada.pop());
            }
        }
        return saida.pop();
    }
}

// ================= PRODUTO =================
class Produto {
    int id;
    String nome;
    int quantidade;

    Produto(int id, String nome, int qtd) {
        this.id = id;
        this.nome = nome;
        this.quantidade = qtd;
    }

    public String toString() {
        return id + " - " + nome + " (" + quantidade + ")";
    }
}

// ================= HASH COM CHAINING =================
class TabelaHash {
    private ListaEncadeada<Produto>[] tabela;
    private int tamanho = 10;

    TabelaHash() {
        tabela = new ListaEncadeada[tamanho];
        for (int i = 0; i < tamanho; i++) tabela[i] = new ListaEncadeada<>();
    }

    private int hash(int k) { return k % tamanho; }

    void put(Produto p) {
        tabela[hash(p.id)].inserir(p);
    }
}
